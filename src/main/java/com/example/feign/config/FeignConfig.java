package com.example.feign.config;

import com.example.feign.feign.interceptor.DemoFeignInterceptor;
import com.example.feign.feign.logger.FeignCustomLogger;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Logger feignLogger() {
        return new FeignCustomLogger();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
