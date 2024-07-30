package com.heg.hotel.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/29 10:23
 */
@Data
@Configuration
public class KinkiConfig {
    @Value("${kinki.id}")
    private String id;

    @Value("${kinki.password}")
    private String password;

    /**产品层的接口地址*/
    @Value("${kinki.productUrl}")
    private String productUrl;

    /**预定层的接口地址*/
    @Value("${kinki.reservationUrl}")
    private String reservationUrl;
}
