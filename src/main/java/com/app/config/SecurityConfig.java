package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private PasswordEncoder encoder;

    //Adding a bean for Authorization rules
    @Bean
    public SecurityFilterChain configureAuthorization(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/product/view", "/user/signin", "/user/signup").permitAll()
                .antMatchers("/product/purchase").hasRole("CUSTOMER")
                .antMatchers("/product/add").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        return httpSecurity.build();
    }
}
