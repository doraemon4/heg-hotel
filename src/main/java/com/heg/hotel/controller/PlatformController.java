package com.heg.hotel.controller;

import com.google.common.collect.Lists;
import com.heg.hotel.config.KinkiConfig;
import com.heg.hotel.helper.ExpediaHelper;
import com.heg.hotel.helper.KinkiHelper;
import com.heg.hotel.helper.request.Kinki.PosInfo;
import com.heg.hotel.helper.request.Kinki.RatePlanAllotEnvelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/5 16:25
 */
@Controller
@RequestMapping("/api")
public class PlatformController {
    @Autowired
    private ExpediaHelper expediaHelper;

    @Autowired
    private KinkiHelper kinkiHelper;

    @Autowired
    private KinkiConfig config;

    @RequestMapping("region")
    public String queryRegion(){
        expediaHelper.getRegions();
        return "SUCCESS";
    }

    @RequestMapping("ratePlanAllot")
    public String getRatePlanAllot(){
        RatePlanAllotEnvelope.HotelRef hotelRef = new RatePlanAllotEnvelope.HotelRef();
        hotelRef.setHotelCode("0010018");
        hotelRef.setRatePlanCode("000111010010018051");
        RatePlanAllotEnvelope.SearchDateRange searchDateRange = new RatePlanAllotEnvelope.SearchDateRange();
        searchDateRange.setStart("2024-08-01");
        searchDateRange.setEnd("2024-08-31");
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
        return "SUCCESS";
    }
}
