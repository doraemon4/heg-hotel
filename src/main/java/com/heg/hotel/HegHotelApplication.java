package com.heg.hotel;

import com.heg.hotel.util.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author jack
 */
@MapperScan("com.heg.hotel.infrastructure.dao")
@SpringBootApplication
@Import({SpringUtil.class})
public class HegHotelApplication {
    public static void main(String[] args) {
        SpringApplication.run(HegHotelApplication.class,args);
    }
}
