package com.panaskin.dockerapp.metric;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
@PropertySource("application.properties")
public class CustomHealthCheck implements HealthIndicator {
    @Override
    public Health getHealth(boolean includeDetails) {
        return health();
    }

    @Override
    public Health health() {
        SecureRandom random = new SecureRandom();
        return Health.up().withDetail("${app.name}", "my application name").build();
    }
}
