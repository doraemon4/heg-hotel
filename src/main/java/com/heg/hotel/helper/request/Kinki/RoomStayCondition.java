package com.heg.hotel.helper.request.Kinki;

import lombok.Data;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/31 19:36
 */
@Data
public class RoomStayCondition {
    @Element(name = "StayDateRange")
    private StayDateRange stayDateRange;
    @Element(name = "RoomStayCandidates")
    private RoomStayCandidateInfo roomStayCandidateInfo;
    @Element(name = "HotelSearchCriteria")
    private HotelSearchCriteria hotelSearchCriteria;

    @Data
    public static class StayDateRange{
        @Attribute(name = "Start")
        private String start;
        @Attribute(name = "end")
        private String end;
    }

    @Data
    public static class RoomStayCandidateInfo{
        @ElementList(entry = "RoomStayCandidate",inline = true,required = false,type = RoomStayCandidate.class)
        private List<RoomStayCandidate> roomStayCandidates;
    }

    @Data
    public static class RoomStayCandidate{
        @Attribute(name = "RoomNumber")
        private String roomNo;
        @Attribute(name = "Quantity")
        private Integer quantity = 1;   //默认是1
        @Element(name = "GuestCounts")
        private GuestCountInfo guestCountInfo;
    }

    @Data
    public static class GuestCountInfo{
        @ElementList(entry = "GuestCount",inline = true,required = false,type = GuestInfo.class)
        private List<GuestInfo> guestInfos;
    }

    @Data
    public static class GuestInfo{
        @Attribute(name = "AgeQualifyingCode")
        private String ageQualifyingCode;    //10:Adult　8:Child

        @Attribute(name = "Age")
        private Integer age;

        @Attribute(name = "Count")
        private Integer count;
    }

    @Data
    public static class HotelSearchCriteria{
        @Element(name = "Criterion")
        private Criterion criterion;
    }

    @Data
    public static class Criterion{
        @Element(name = "HotelRef")
        private HotelRef hotelRef;
    }

    @Data
    public static class HotelRef{
        @Attribute(name = "RatePlanCode")
        private String ratePlanCode;
    }
}
