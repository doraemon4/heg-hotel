package com.heg.hotel.helper.response.Kinki;

import lombok.Data;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/31 14:27
 */
@Data
public class HotelReservation {
    @Element(name = "RoomStays")
    private RoomStayInfo roomStayInfo;
    @Element(name = "ResGlobalInfo")
    private ResGlobalInfo resGlobalInfo;

    @Data
    public static class RoomStayInfo{
        @Element(name = "RoomStay")
        private RoomStay roomStay;
    }

    @Data
    public static class RoomStay{
        @Element(name = "RatePlans")
        private RatePlanDetail ratePlanInfoDetail;
    }

    /**
     * 统计总的费率
     */
    @Data
    public static class RatePlanDetail{
        @Element(name = "RatePlan")
        private RatePlan ratePlan;
        @Element(name = "Rate")
        private RateInfo rateInfo;
        @Element(name = "CancelRates")
        private CancelRateInfo cancelRateInfo;
    }

    @Data
    public static class RatePlan{
        @Attribute(name = "RatePlanCode")
        private String ratePlanCode;
    }

    @Data
    public static class ResGlobalInfo{
        @Element(name = "HotelReservationIDs")
        private HotelReservationID hotelReservationID;
    }

    @Data
    public static class HotelReservationID{
        @Element(name = "HotelReservationID")
        private HotelResIdInfo hotelResIdInfo;
    }

    @Data
    public static class HotelResIdInfo{
        @Attribute(name = "ResID")
        private String resNo;   //供应商订单号

        @Attribute(name = "ReserveNo")
        private String reserveNo;   //分销商订单号

        @Attribute(name = "ReserveType")
        private String reserveType; //订单预定类型  1:Reserve 2:Cancel
    }
}
