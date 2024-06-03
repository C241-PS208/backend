package com.shavemax.shavemax.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shavemax.jwt")
@Data
public class JWTConfigProperties {
    private String secret;
}
