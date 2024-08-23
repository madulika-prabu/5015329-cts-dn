package com.example.employeemanagementsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Normally, you would get the current username from the security context.
        // For simplicity, we'll use a fixed username here.
        return Optional.of("admin");
    }
}
