package com.panaskin.jointableinhapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(value = "com.panaskin.jointableinhapp.repository")
public class JpaConfig {
}
