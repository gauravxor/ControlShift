package com.clumsycoder.playerservice.models;

import com.clumsycoder.controlshift.commons.generators.Cuid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "player_profile")
public class PlayerProfile {

    @Id
    private String id;

    @Column(nullable = false)
    private String first_name;

    @Column
    private String last_name;

    @Column(nullable = true)
    private Integer age;

    @Column(name="created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    public void prePersist() {
        Instant currentTime = Instant.now();
        if (this.id == null) this.id = Cuid.getCuid();
        if (this.createdAt == null) this.createdAt = currentTime;
        if (this.updatedAt == null) this.updatedAt = currentTime;
    }
}