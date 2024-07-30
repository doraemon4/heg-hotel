package com.heg.hotel.helper;

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
}
