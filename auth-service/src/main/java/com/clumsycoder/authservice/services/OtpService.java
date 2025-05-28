package com.clumsycoder.authservice.services;

import com.clumsycoder.authservice.models.OtpEntity;
import com.clumsycoder.authservice.models.Player;
import com.clumsycoder.authservice.repositories.OtpRepository;
import com.clumsycoder.authservice.repositories.PlayerRepository;
import com.clumsycoder.controlshift.commons.email.EmailService;
import com.clumsycoder.controlshift.commons.enums.OtpPurpose;
import com.clumsycoder.controlshift.commons.enums.OtpType;
import com.clumsycoder.controlshift.commons.generators.OtpGenerator;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OtpService {
    private final OtpRepository otpRepository;
    private final PlayerRepository playerRepository;
    private final EmailService emailService;

    @Transactional
    public void sendEmailVerificationOtp(String email, String playerId) {

        OtpPurpose otpPurpose = OtpPurpose.EMAIL_VERIFICATION;
        int otpExpiry = otpPurpose.getExpirySeconds();

        Player player = new Player();
        player.setId(playerId);

        String otpCode = OtpGenerator.generate(OtpType.ALPHANUMERIC);
        LocalDateTime currentTimeStamp = LocalDateTime.now();

        OtpEntity otpEntity = new OtpEntity();
        otpEntity.setOtpCode(otpCode);
        otpEntity.setPurpose(otpPurpose);
        otpEntity.setPlayer(player);
        otpEntity.setCreatedAt(currentTimeStamp);
        otpEntity.setExpiresAt(currentTimeStamp.plusSeconds(otpExpiry));

        otpRepository.save(otpEntity);

        try {
            emailService.sendVerificationOtp(email, otpCode);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email otp");
        }
    }

    @Transactional
    public boolean validateEmailVerificationOtp(String playerId, String otpCode) {
        Optional<OtpEntity> otpEntityOpt = otpRepository.findByPlayer_IdAndOtpCodeAndUsedFalseAndExpiresAtAfter(
                playerId, otpCode, LocalDateTime.now()
        );
        if (otpEntityOpt.isEmpty()) {
            return false;
        }

        OtpEntity otpEntity = otpEntityOpt.get();
        Player player = otpEntity.getPlayer();
        player.setEmailVerified(true);
        playerRepository.save(player);
        otpRepository.delete(otpEntity);
        return true;
    }

}