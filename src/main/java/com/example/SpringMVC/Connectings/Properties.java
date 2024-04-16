package com.example.SpringMVC.Connectings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Configuration
@ConfigurationProperties(prefix="spring.datasource")
@Component
public  class Properties {
    private String url;
    private String username;
    private String password;
}
