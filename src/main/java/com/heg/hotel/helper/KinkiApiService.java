package com.heg.hotel.helper;

import com.heg.hotel.helper.request.Kinki.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @Description: 通过soap协议与KOBS系统交互
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/28 19:51
 */
public interface KinkiApiService {
    /**
     * 获取价格计划
     * @param envelope
     * @return
     */
    @Headers({
            "Content-Type:text/xml;charset=utf-8",
            "SOAPAction:http://gv.knt.co.jp/HotelRatePlanRQ"
    })
    @POST("KOBSReservation.asmx")
    Call<ResponseBody> getRatePlan(HotelRatePlanEnvelope envelope);

    /**
     * 获取价格
     * @param envelope
     * @return
     */
    @Headers({
            "Content-Type:text/xml;charset=utf-8",
            "SOAPAction:http://gv.knt.co.jp/HotelAvailRQ"
    })
    @POST("KOBSReservation.asmx")
    Call<ResponseBody> getHotelAvail(HotelAvailEnvelope envelope);

    /**
     * 获取每日房量
     * @param envelope
     * @return
     */
    @Headers({
            "Content-Type:text/xml;charset=utf-8",
            "SOAPAction:http://gv.knt.co.jp/RatePlanAllotRQ"
    })
    @POST("KOBSReservation.asmx")
    Call<ResponseBody> getRatePlanAllot(@Body RatePlanAllotEnvelope envelope);

    /**
     * 预定酒店
     * @param envelop
     * @return
     */
    @Headers({
            "Content-Type:text/xml;charset=utf-8",
            "SOAPAction:http://gv.knt.co.jp/HotelResRQ"
    })
    @POST("kobs/KobsReservation.asmx")
    Call<ResponseBody> reserveHotel(@Body HotelReservationEnvelope envelop);

    /**
     * 检查酒店是否预订成功(由于网络问题可能预定失败)
     * @param envelop
     * @return
     */
    @Headers({
            "Content-Type:text/xml;charset=utf-8",
            "SOAPAction:http://gv.knt.co.jp/HotelResConfirmRQ"
    })
    @POST("kobs/KobsReservation.asmx")
    Call<ResponseBody> confirmReservation(@Body ConfirmReservationEnvelope envelop);

    /**
     * 预定取消
     * @param envelop
     * @return
     */
    @Headers({
            "Content-Type:text/xml;charset=utf-8",
            "SOAPAction:http://gv.knt.co.jp/CancelRQ"
    })
    @POST("kobs/KobsReservation.asmx")
    Call<ResponseBody> cancel(@Body CancelEnvelope envelop);
}
