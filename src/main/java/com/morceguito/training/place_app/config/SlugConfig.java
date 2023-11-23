package com.morceguito.training.place_app.config;

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
