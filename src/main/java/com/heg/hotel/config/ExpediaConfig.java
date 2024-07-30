package com.heg.hotel.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/5 9:42
 */
@Data
@Configuration
public class ExpediaConfig {
    @Value("${expedia.apiKey}")
    private String apiKey;
    @Value("${expedia.secret}")
    private String secret;
    @Value("${expedia.url}")
    private String url;
}
