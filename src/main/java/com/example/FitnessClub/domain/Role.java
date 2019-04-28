package com.example.FitnessClub.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    TRAINER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
