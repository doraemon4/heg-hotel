package com.heg.hotel.helper.request.Kinki;

import lombok.Data;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * @Description: 酒店预定
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/30 14:58
 */
@Data
@Root(name = "soap:Envelope",strict = false)
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
})
public class HotelReservationEnvelope {
    @Element(name = "soap:Body",required = false)
    private HotelReservationBody body;

    @Data
    public static class HotelReservationBody{
        @Element(name = "HotelResRQ",required = false)
        @Namespace(reference = "http://gv.knt.co.jp/")
        private HotelReservationReq hotelReservationReq;
    }

    @Data
    public static class HotelReservationReq{
        @Element(name = "POS")
        private PosInfo posInfo;

        @Element(name = "HotelReservations")
        private HotelReservationInfo hotelReservationInfo;
    }

    /**
     * 支持批量预定
     */
    @Data
    public static class HotelReservationInfo{
        @ElementList(entry = "HotelReservation",inline = true, required = false,type = HotelReservation.class)
        private List<HotelReservation> hotelReservations;
    }

    @Data
    public static class HotelReservation{
        @Element(name = "RoomStays")
        private RoomStayInfo roomStayInfo;
        @Element(name = "ResGuests")
        private ReservationGuestInfo reservationGuestInfo;
    }

    @Data
    public static class RoomStayInfo{
        @ElementList(name = "RoomStay",inline = true,type = RoomStay.class,required = false)
        private List<RoomStay> roomStays;
    }

    @Data
    public static class ReservationGuestInfo{
        @ElementList(name = "ResGuest",inline = true,type = ReservationGuest.class,required = false)
        private List<ReservationGuest> reservationGuests;
    }

    /***
     * 每间房间的入住信息
     */
    @Data
    public static class RoomStay{
        @Element(name = "RoomTypes")
        private RoomTypeInfo roomTypeInfo;
        @Element(name = "RatePlans")
        private RatePlanInfo ratePlanInfo;
        @Element(name = "GuestCounts")
        private GuestCountInfo guestCountInfo;
        @Element(name = "TimeSpan")
        private TimeSpan timeSpan;
        @Element(name = "BasicPropertyInfo")
        private BasicPropertyInfo propertyInfo;
    }

    @Data
    public static class ReservationGuest{
        @Element(name = "Profiles")
        private ProfilesInfo profilesInfo;
    }

    @Data
    public static class ProfilesInfo{
        @Element(name = "ProfileInfo")
        private ProfileInfo profileInfo;
    }

    @Data
    public static class ProfileInfo{
        @Element(name = "Profile")
        private Profile profile;
    }

    @Data
    public static class Profile{
        @Attribute(name = "ProfileType")
        private String profileType = "1";
        @Element(name = "Customer")
        private Customer customer;
    }

    /**
     * 预定人信息
     */
    @Data
    public static class Customer{
        @Element(name = "PersonName")
        private PersonName personName;
        @Element(name = "Telephone")
        private TelphoneInfo telphoneInfo;
        @Element(name = "Email")
        private String emailInfo;
        @Element(name = "Address")
        private AddressInfo addressInfo;
    }

    @Data
    public static class TelphoneInfo{
        @Attribute(name = "PhoneNumber")
        private String phoneNumber;
    }

    @Data
    public static class AddressInfo{
        @Element(name = "AddressLine")
        private String addressLine;
        @Element(name = "PostalCode")
        private String postalCode;
        @Element(name = "CountryName")
        private String countryName;
    }

    @Data
    public static class RoomTypeInfo{
        @Element(name = "RoomType")
        private RoomType roomType;
    }

    @Data
    public static class RoomType{
        @Attribute(name = "NumberOfUnits")
        private String count;
    }

    @Data
    public static class RatePlanInfo{
        @Element(name = "RatePlan")
        private RatePlan ratePlan;
    }

    @Data
    public static class RatePlan{
        @Attribute(name = "RatePlanCode")
        private String ratePlanCode;
    }

    @Data
    public static class GuestCountInfo{
        @ElementList(name = "Guest",inline = true,required = false,type = GuestInfo.class)
        private List<GuestInfo> guestInfos;
    }

    @Data
    public static class GuestInfo extends PersonName{
        @Attribute(name = "RoomNumber")
        private String roomNumber;   //房间编号
        @Attribute(name = "AgeQualifyingCode")
        private String ageQualifyingCode;   //年龄类型编号 10: Adult　 8: Child
    }

    @Data
    public static class PersonName{
        @Element(name = "NamePrefix")
        private String namePrefix;
        @Element(name = "GivenName")
        private String givenName;  //名，等同于firstname
        @Element(name = "SurName")
        private String surName;    //姓，等同于lastname
    }

    @Data
    public static class TimeSpan{
        @Attribute(name = "Start")
        private String start;
        @Attribute(name = "End")
        private String end;
    }

    @Data
    public static class BasicPropertyInfo{
        @Attribute(name = "HotelCode")
        private String hotelCode;
    }
}
