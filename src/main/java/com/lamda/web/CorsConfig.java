package com.lamda.web;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer{
    public void addCorsMapping(CorsRegistry registry){

        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:8000")
                .allowedOrigins("http://localhost:8080");
    }
}
