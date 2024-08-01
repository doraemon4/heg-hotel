package com.heg.hotel.helper;

import com.alibaba.fastjson.JSON;
import com.heg.hotel.helper.request.Kinki.*;
import com.heg.hotel.helper.response.Kinki.*;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.simpleframework.xml.core.Persister;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.util.Objects;
import java.util.stream.Collectors;

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

    public void getRatePlan(HotelRatePlanEnvelope envelope){
        Call<ResponseBody> call = apiService.getRatePlan(envelope);
        try {
            Response<ResponseBody> response = call.execute();
            if(response.isSuccessful()) {
                String result = response.body().string();
                HotelRatePlanRespEnvelope hotelRatePlanRespEnvelope = persister.read(HotelRatePlanRespEnvelope.class,result);
                log.info("result:{},json序列化信息:{}",result, JSON.toJSON(hotelRatePlanRespEnvelope));
                if(!Objects.isNull(hotelRatePlanRespEnvelope)){
                    ErrorInfo errorInfo = hotelRatePlanRespEnvelope.getBody()
                            .getHotelRatePlanResp().getErrorInfo();
                    if(!Objects.isNull(errorInfo)){
                        String errorMessage = errorInfo.getErrorMessages().stream().map(ErrorInfo.ErrorMessage::getMessage)
                                .collect(Collectors.joining(";"));
                    }else{
                        //TODO
                    }

                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void getHotelAvail(HotelAvailEnvelope envelope){
        Call<ResponseBody> call = apiService.getHotelAvail(envelope);
        try {
            Response<ResponseBody> response = call.execute();
            if (response.isSuccessful()) {
                String result = response.body().string();
                HotelAvailRespEnvelope hotelAvailRespEnvelope = persister.read(HotelAvailRespEnvelope.class,result);
                log.info("get hotel avail result:{},json序列化信息:{}",result, JSON.toJSON(hotelAvailRespEnvelope));
                if(!Objects.isNull(hotelAvailRespEnvelope)){
                    ErrorInfo errorInfo = hotelAvailRespEnvelope.getBody()
                            .getHotelAvailResp().getErrorInfo();
                    if(!Objects.isNull(errorInfo)){
                        String errorMessage = errorInfo.getErrorMessages().stream().map(ErrorInfo.ErrorMessage::getMessage)
                                .collect(Collectors.joining(";"));
                    }else{
                        //TODO
                    }

                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    public void getRatePlanAllot(RatePlanAllotEnvelope envelope) {
        Call<ResponseBody> call = apiService.getRatePlanAllot(envelope);
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
                if(!Objects.isNull(ratePlanAllotRespEnvelope)){
                    ErrorInfo errorInfo = ratePlanAllotRespEnvelope.getBody()
                            .getRatePlanAllotResp().getErrorInfo();
                    if(!Objects.isNull(errorInfo)){
                        String errorMessage = errorInfo.getErrorMessages().stream().map(ErrorInfo.ErrorMessage::getMessage)
                                .collect(Collectors.joining(";"));
                    }else{
                        //TODO
                    }

                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void reserveHotel(HotelReservationEnvelope envelope){
        Call<ResponseBody> call = apiService.reserveHotel(envelope);
        try {
            Response<ResponseBody> response = call.execute();
            if(response.isSuccessful()) {
                String result = response.body().string();
                HotelReservationRespEnvelope hotelReservationRespEnvelop =
                        persister.read(HotelReservationRespEnvelope.class,result);
                log.info("result:{},json序列化信息:{}",result, JSON.toJSON(hotelReservationRespEnvelop));
                if(!Objects.isNull(hotelReservationRespEnvelop)){
                    ErrorInfo errorInfo = hotelReservationRespEnvelop.getBody()
                            .getReservationResp().getErrorInfo();
                    if(!Objects.isNull(errorInfo)){
                        String errorMessage = errorInfo.getErrorMessages().stream().map(ErrorInfo.ErrorMessage::getMessage)
                                .collect(Collectors.joining(";"));
                    }else{
                        //TODO
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void confirmReserve(ConfirmReservationEnvelope envelope){
        Call<ResponseBody> call = apiService.confirmReservation(envelope);
        try {
            Response<ResponseBody> response = call.execute();
            if(response.isSuccessful()) {
                String result = response.body().string();
                ConfirmReservationRespEnvelope confirmReservationRespEnvelope =
                        persister.read(ConfirmReservationRespEnvelope.class,result);
                log.info("result:{},json序列化信息:{}",result, JSON.toJSON(confirmReservationRespEnvelope));
                if(!Objects.isNull(confirmReservationRespEnvelope)){
                    ErrorInfo errorInfo = confirmReservationRespEnvelope.getBody()
                            .getConfirmResResp().getErrorInfo();
                    if(!Objects.isNull(errorInfo)){
                        String errorMessage = errorInfo.getErrorMessages().stream().map(ErrorInfo.ErrorMessage::getMessage)
                                .collect(Collectors.joining(";"));
                    }else{
                        //TODO
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void cancel(CancelEnvelope envelope){
        Call<ResponseBody> call = apiService.cancel(envelope);
        try {
            Response<ResponseBody> response = call.execute();
            if(response.isSuccessful()) {
                String result = response.body().string();
                CancelRespEnvelope cancelRespEnvelop = persister.read(CancelRespEnvelope.class,result);
                log.info("result:{},json序列化信息:{}",result, JSON.toJSON(cancelRespEnvelop));
                if(!Objects.isNull(cancelRespEnvelop)){
                    ErrorInfo errorInfo = cancelRespEnvelop.getBody().getCancelResp().getErrorInfo();
                    if(!Objects.isNull(errorInfo)){
                        String errorMessage = errorInfo.getErrorMessages().stream().map(ErrorInfo.ErrorMessage::getMessage)
                                .collect(Collectors.joining(";"));
                    }else{
                        //TODO
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
