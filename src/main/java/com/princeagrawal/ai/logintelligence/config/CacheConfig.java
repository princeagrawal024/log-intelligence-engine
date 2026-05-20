package com.princeagrawal.ai.logintelligence.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    public static final String LOGS_CACHE = "logs";

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(LOGS_CACHE, "responses");
    }
}