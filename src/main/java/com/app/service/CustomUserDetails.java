package com.app.service;

import com.app.pojo.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {
    private UserEntity authUserDetails;

    public CustomUserDetails(UserEntity authenticatedUser) {
        super();
        this.authUserDetails = authenticatedUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Here We Are mapping the Role to That Particular User to Grant Authority
        return Arrays.asList(new SimpleGrantedAuthority(authUserDetails.getRole().getRoleName().name()));
    }

    @Override
    public String getPassword() {
        return authUserDetails.getPassword();
    }

    @Override
    public String getUsername() {
        return authUserDetails.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
