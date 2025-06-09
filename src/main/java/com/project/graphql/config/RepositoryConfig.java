package com.project.graphql.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.project.graphql.persistance")
@EnableRedisRepositories(basePackages = ".com.project.graphql.cache")
public class RepositoryConfig {
}
