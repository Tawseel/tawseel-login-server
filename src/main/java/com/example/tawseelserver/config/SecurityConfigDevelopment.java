package com.example.tawseelserver.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile(Profiles.DEVELOPMENT)
public class SecurityConfigDevelopment  extends WebSecurityConfigurerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfigDevelopment.class);

    @Override
    protected void configure(HttpSecurity http) {
        LOGGER.info("Run DEVELOPMENT Security Configuration");
    }
}
