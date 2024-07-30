package com.heg.hotel.helper;

import com.heg.hotel.helper.request.Kinki.CancelEnvelop;
import com.heg.hotel.helper.request.Kinki.ConfirmReservationEnvelop;
import com.heg.hotel.helper.request.Kinki.HotelReservationEnvelop;
import com.heg.hotel.helper.request.Kinki.RatePlanAllotEnvelope;
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
    @Headers({
            "Content-Type:text/xml;charset=utf-8",
            "SOAPAction:http://gv.knt.co.jp/RatePlanAllotRQ"
    })
    @POST("KOBSReservation.asmx")
    Call<ResponseBody> getRatePlan(@Body RatePlanAllotEnvelope envelope);

    /**
     * 预定酒店
     * @param envelop
     * @return
     */
    @POST("kobs/KobsReservation.asmx")
    Call<ResponseBody> reserveHotel(@Body HotelReservationEnvelop envelop);

    /**
     * 检查酒店是否预订成功(由于网络问题可能预定失败)
     * @param envelop
     * @return
     */
    @POST("kobs/KobsReservation.asmx")
    Call<ResponseBody> confirmReservation(@Body ConfirmReservationEnvelop envelop);

    /**
     * 预定取消
     * @param envelop
     * @return
     */
    @POST("kobs/KobsReservation.asmx")
    Call<ResponseBody> cancel(@Body CancelEnvelop envelop);
}
