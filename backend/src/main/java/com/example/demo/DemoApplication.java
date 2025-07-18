package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemoApplication {
	
public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
}

	//bean to configure CORS settings 
	// ანუ რომ ავაგოთ CORS კონფიგურაცია, რათა React აპლიკაციამ შეძლოს კომუნიკაცია Spring Boot ბექენდთან
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Apply CORS to all paths under /api/
                        .allowedOrigins("http://localhost:5173") // Allow requests from your React frontend's origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these HTTP methods
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow sending of cookies, authorization headers etc.
            }
        };
    }
}