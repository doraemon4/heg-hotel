package com.heg.hotel;

import com.google.common.collect.Lists;
import com.heg.hotel.config.KinkiConfig;
import com.heg.hotel.helper.KinkiHelper;
import com.heg.hotel.helper.request.Kinki.PosInfo;
import com.heg.hotel.helper.request.Kinki.RatePlanAllotEnvelope;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/29 10:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HegHotelApplication.class)
public class KinkiAppTest {
    @Autowired
    private KinkiHelper kinkiHelper;
    @Autowired
    private KinkiConfig config;

    @Test
    public void getRatePlanAllot(){
        RatePlanAllotEnvelope.HotelRef hotelRef = new RatePlanAllotEnvelope.HotelRef();
        hotelRef.setHotelCode("000403002610104017");
        hotelRef.setRatePlanCode("2610104");
        RatePlanAllotEnvelope.SearchDateRange searchDateRange = new RatePlanAllotEnvelope.SearchDateRange();
        searchDateRange.setStart("2020-01-01");
        searchDateRange.setEnd("2020-01-31");
        RatePlanAllotEnvelope.AllotRequestSegment allotRequestSegment = new RatePlanAllotEnvelope.AllotRequestSegment();
        allotRequestSegment.setHotelRef(hotelRef);
        allotRequestSegment.setSearchDateRange(searchDateRange);
        allotRequestSegment.setNumber("1");
        RatePlanAllotEnvelope.AllotRequestSegmentInfo allotRequestSegmentInfo= new RatePlanAllotEnvelope.AllotRequestSegmentInfo();
        allotRequestSegmentInfo.setAllotRequestSegments(Lists.newArrayList(allotRequestSegment));
        RatePlanAllotEnvelope.RatePlanAllotReq ratePlanAllotReq = new RatePlanAllotEnvelope.RatePlanAllotReq();
        ratePlanAllotReq.setAllotRequestSegmentInfo(allotRequestSegmentInfo);
        PosInfo posInfo = new PosInfo();
        PosInfo.SourceInfo sourceInfo = new PosInfo.SourceInfo();
        sourceInfo.setRequestorID(PosInfo.RequestorID.builder()
                .id(config.getId())
                .type("5").password(config.getPassword()).build());
        posInfo.setSourceInfo(sourceInfo);
        ratePlanAllotReq.setPosInfo(posInfo);
        RatePlanAllotEnvelope envelope = new RatePlanAllotEnvelope();
        RatePlanAllotEnvelope.RatePlanAllotBody body = new RatePlanAllotEnvelope.RatePlanAllotBody();
        body.setRatePlanAllotReq(ratePlanAllotReq);
        envelope.setBody(body);

        kinkiHelper.getRatePlanAllot(envelope);
    }
}
