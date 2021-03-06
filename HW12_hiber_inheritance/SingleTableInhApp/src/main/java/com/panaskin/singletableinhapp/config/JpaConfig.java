package com.panaskin.singletableinhapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.panaskin.singletableinhapp.repository")
public class JpaConfig {
}
