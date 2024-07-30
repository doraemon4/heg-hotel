package com.heg.hotel.helper.response.Restel;

/**
 * @Description: 酒店详情信息
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/24 18:42
 */

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.List;

@Data
@XStreamAlias(value = "respuesta")
public class QueryHotelDetailResp extends BaseResp{
    @XStreamAlias("parametros")
    private HotelDetailResp hotelDetailResp;

    @Data
    public static class HotelDetailResp{
        @XStreamAlias("hotel")
        private HotelDetailInfo hotelDetailInfo;
        private String id;
    }

    @Data
    public static class HotelDetailInfo{
        @XStreamAlias("pais")
        private String country;

        @XStreamAlias("codigo_hotel")
        private String hotelCode;

        @XStreamAlias("hot_afiliacion")
        private String hotelAffiliation;

        @XStreamAlias("nombre_h")
        private String hotelName;

        @XStreamAlias("direccion")
        private String address;

        @XStreamAlias("codprovincia")
        private String provinceCode;

        @XStreamAlias("provincia")
        private String provinceName;

        @XStreamAlias("codpoblacion")
        private String cityCode;

        @XStreamAlias("poblacion")
        private String cityName;

        @XStreamAlias("cp")
        private String postCode;

        @XStreamAlias("mail")
        private String email;

        @XStreamAlias("web")
        private String hotelWebsite;

        @XStreamAlias("telefono")
        private String phoneNumber;

        @XStreamAlias(value = "fotos")
        private HotelPictureInfo hotelPictureInfo;

        @XStreamAlias("plano")
        private String hotelMap;

        @XStreamAlias("desc_hotel")
        private String description;

        @XStreamAlias("num_habitaciones")
        private Integer roomCount;

        @XStreamAlias("como_llegar")
        private String taxToReachHotel;

        @XStreamAlias("tipo_establecimiento")
        private String hotelCategoryDesc;

        @XStreamAlias("categoria")
        private String hotelCategory;

        @XStreamAlias("checkin")
        private String checkInTime;
        @XStreamAlias("checkout")
        private String checkOutTime;

        @XStreamAlias("edadnindes")
        private Integer childAgeStart;
        @XStreamAlias("edadninhas")
        private Integer childAgeEnd;
        private String currency;

        /**酒店服务*/
        //此处不使用@XStreamImplicit，减少属性深度
        @XStreamAlias("servicios")
        private List<HotelService> hotelServices;

        /**酒店房间服务*/
        @XStreamAlias("servicios_habitacion")
        private List<HotelRoomService> hotelRoomServices;

        /**酒店周边信息*/
        @XStreamAlias("distancias")
        private List<HotelDistance> hotelDistances;

        /**会议室信息*/
        @XStreamAlias("salones")
        private List<MeetingRoom> meetingRooms;

        @XStreamAlias("longitud")
        private String longitude;

        @XStreamAlias("latitud")
        private String latitude;
        @XStreamAlias("city_tax")
        private String taxation;
    }

    @Data
    public static class HotelPictureInfo{
        @XStreamImplicit(itemFieldName = "foto")
        private List<String> imageUrls;
    }

    @Data
    @XStreamAlias("servicio")
    public static class HotelService{
        @XStreamAlias("codigo_servicio")
        private String serviceCode;
        @XStreamAlias("desc_serv")
        private String description;
    }

    @Data
    @XStreamAlias("servicio_habitacion")
    public static class HotelRoomService{
        @XStreamAlias("codigo_servicio_hab")
        private String roomServiceCode;
        @XStreamAlias("descripciones")
        private String description;
    }

    @Data
    @XStreamAlias("distancia")
    public static class HotelDistance{
        /**目的地*/
        @XStreamAlias("lugar")
        private String destination;
        /**距离公里数*/
        @XStreamAlias("kms")
        private String distance;
        /**距离多少米*/
        @XStreamAlias("mts")
        private String meter;

        @XStreamAlias("pie_horas")
        private String hoursOnFoot;
        @XStreamAlias("pie_min")
        private String minutesOnFoot;
        @XStreamAlias("coche_horas")
        private String hoursByCar;
        @XStreamAlias("coche_min")
        private String minutesByCar;
    }

    @Data
    @XStreamAlias("salon")
    public static class MeetingRoom{
        @XStreamAlias("codigo_salon")
        private String meetingRoomCode;
        @XStreamAlias("nombre")
        private String meetingRoomName;
        /**面积大小，平方米*/
        @XStreamAlias("m2")
        private String area;
        /**桌子的数量*/
        @XStreamAlias("teatro")
        private Integer tables;
    }
}
