package com.clumsycoder.controlshift.commons.exceptions;

import com.clumsycoder.controlshift.commons.constants.ExceptionMessageConstants;

public class InvalidOtpException extends GlobalException {
    public InvalidOtpException() {
        super(ExceptionMessageConstants.INVALID_OTP_ERROR);
    }

    public InvalidOtpException(String errorMessage) {
        super(errorMessage);
    }
}