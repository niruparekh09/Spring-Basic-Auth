package com.app.service;

import com.app.pojo.UserEntity;
import com.app.repo.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserEntityRepository userEntityRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity authenticatedUser = userEntityRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid User Email"));
        return new CustomUserDetails(authenticatedUser);
    }
}
