package com.morceguito.training.config;

import com.github.slugify.Slugify;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlugConfig {

    @Bean
    Slugify slugify(){
        return Slugify.builder().build();
    }
}
