package com.heg.hotel;

import com.heg.hotel.service.MappingService;
import com.heg.hotel.service.TMXService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @Description
 * @Author jack
 * @Date 2024/9/6 11:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HegHotelApplication.class)
public class TMXTest {
    @Autowired
    private TMXService tmxService;
    @Autowired
    private MappingService mappingService;

    @Test
    public void test(){
        try {
            tmxService.pullHotel("D:\\response.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void match(){
        mappingService.match();
    }

    @Test
    public void group(){
        mappingService.group();
    }
}
