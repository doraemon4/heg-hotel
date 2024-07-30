package com.heg.hotel.helper;

import com.alibaba.fastjson.JSON;
import com.heg.hotel.helper.request.Kinki.RatePlanAllotEnvelope;
import com.heg.hotel.helper.response.Kinki.RatePlanAllotRespEnvelope;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.simpleframework.xml.core.Persister;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

/**
 * @Description: KOBS系统对接
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/28 22:43
 */
@Slf4j
@Component
@DependsOn(value = "springUtil")
public class KinkiHelper {
    private Persister persister = new Persister();
    private static KinkiApiService apiService = KinkiRetrofitServiceManager.getInstance().create(KinkiApiService.class);

    public void getRatePlan(RatePlanAllotEnvelope envelope) {
        Call<ResponseBody> call = apiService.getRatePlan(envelope);
        //异步请求
        /*call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                log.info("onResponse: {}", response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                log.info("onFailure: {}", throwable.getMessage());
            }
        });*/
        //同步请求
        try {
            Response<ResponseBody> response = call.execute();
            if(response.isSuccessful()) {
                String result = response.body().string();
                RatePlanAllotRespEnvelope ratePlanAllotRespEnvelope = persister.read(RatePlanAllotRespEnvelope.class,result);
                log.info("result:{},json序列化信息:{}",result, JSON.toJSON(ratePlanAllotRespEnvelope));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
