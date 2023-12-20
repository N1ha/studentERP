package dev.erp.student.utils;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public enum EntityRole {
    ROLE_STUDENT, ROLE_PROF, ROLE_HOD;
    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.name()));
        return authorities;
    }
}
