package com.heg.hotel;

import com.heg.hotel.helper.ExpediaHelper;
import com.heg.hotel.infrastructure.dao.HotelMapper;
import com.heg.hotel.service.ExpediaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HegHotelApplication.class)
public class ExpediaAppTest {
    @Autowired
    private ExpediaHelper expediaHelper;
    @Autowired
    private ExpediaService expediaService;
    @Autowired
    private HotelMapper hotelMapper;

    @Test
    public void getRegin(){
        expediaHelper.getRegions();
    }

    @Test
    public void getPropertyContent(){
        System.out.println(expediaHelper.getPropertyContent("US"));
    }

    @Test
    public void getPropertyFile(){
        System.out.println(expediaHelper.getPropertyFile());
    }


    @Test
    public void getGuestReview(){
        System.out.println(expediaHelper.getGuestReviews());
    }

    @Test
    public void getSingleRoomPropertiesAvailability(){
        expediaHelper.getSingleRoomPropertiesAvailability();
    }

}
