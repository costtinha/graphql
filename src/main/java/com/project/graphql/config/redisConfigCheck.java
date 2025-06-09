package com.project.graphql.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class redisConfigCheck {
    @Value("${SPRING_REDIS_HOST}")
    private String redisHost;

    @Value("${SPRING_REDIS_PORT}")
    private String redisPort;

    @Bean
    public CommandLineRunner checkRedisConfig() {
        return args -> {
            System.out.println("Redis Host configurado: " + redisHost);
            System.out.println("Redis Port configurado: " + redisPort);
        };
    }

}
