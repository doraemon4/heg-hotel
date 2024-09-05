package com.heg.hotel.helper;

import com.expediagroup.sdk.core.model.Response;
import com.expediagroup.sdk.core.model.paging.ResponsePaginator;
import com.expediagroup.sdk.rapid.client.RapidClient;
import com.expediagroup.sdk.rapid.models.*;
import com.expediagroup.sdk.rapid.operations.*;
import com.google.common.collect.Lists;
import com.heg.hotel.config.ExpediaConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * @author jack
 */
@Slf4j
@Component
public class ExpediaHelper {
    @Resource
    private ExpediaConfig expediaConfig;

    private RapidClient rapidClient;

    @PostConstruct
    public void init(){
        rapidClient = RapidClient
                .builder()
                .endpoint(expediaConfig.getUrl())
                .key(expediaConfig.getApiKey())
                .secret(expediaConfig.getSecret())
                .requestTimeout(10000)
                .build();
    }

    public List<List<Region>> getRegions(){
        GetRegionsOperationParams regionsOperationParams = GetRegionsOperationParams
                .builder()
                .language("en-US")
                .include(Collections.singletonList("details"))
                .customerSessionId("123455656565")
                .limit(BigDecimal.valueOf(10))
                .supplySource("expedia")
                .countryCode(Arrays.asList("US"))
                .ancestorId("602962")
                .build();
        GetRegionsOperation getRegionsOperation = new GetRegionsOperation(regionsOperationParams);
        List<List<Region>> pages = new ArrayList<>();

        rapidClient.getPaginator(getRegionsOperation).forEachRemaining(page -> pages.add(page.getData()));
        System.out.println("分页数据:"+pages);


       /* ResponsePaginator<List<Region>> responsePaginator = rapidClient.getPaginator(new GetRegionsOperation(
                regionsOperationParams));
        log.info("Paginator total results count: {}", responsePaginator.getPaginationTotalResults());

        responsePaginator.forEachRemaining(page -> {
            pages.add(page.getData());
        });*/
        return pages;
    }

    /**
     * get hotel-room-rate
     * @return
     */
    public ResponsePaginator<Map<String,PropertyContent>> getPropertyContent(String countryCode){
        GetPropertyContentOperationParams params = GetPropertyContentOperationParams.builder()
                .language("en-US")
                .supplySource("expedia")
                .countryCode(Arrays.asList(countryCode))
                //.propertyRatingMin(ratingMin)
                //.propertyRatingMax(ratingMax)
                .build();
        GetPropertyContentOperation operation = new GetPropertyContentOperation(params);

        /*Response<Map<String, PropertyContent>> response = rapidClient.execute(operation);
        System.out.println(response);
        System.out.println("不分页查询的记录数："+response.getData().size());
        System.out.println("============================================================================");*/
        ResponsePaginator<Map<String,PropertyContent>> responsePaginator = rapidClient.getPaginator(operation);
        System.out.println("总记录数:"+responsePaginator.getPaginationTotalResults());

        return responsePaginator;
    }

    /**
     * download file
     * */
    public Response<Link> getPropertyFile(){
        GetPropertyContentFileOperationParams params = GetPropertyContentFileOperationParams.builder()
                .language("en-US")
                .supplySource("expedia")
                .build();
        GetPropertyContentFileOperation operation = new GetPropertyContentFileOperation(params);
        return rapidClient.execute(operation);
    }

    /**
     * get guest reviews
     * Property Guest Reviews are only available if your account is configured for access and all launch requirements have been followed.
     * @return
     */
    public Response<GuestReviews> getGuestReviews(){
        GetPropertyGuestReviewsOperationParams params = GetPropertyGuestReviewsOperationParams.builder()
                .language("en-US")
                .propertyId("12345")
                .build();
        GetPropertyGuestReviewsOperation operation = new GetPropertyGuestReviewsOperation(params);
        return rapidClient.execute(operation);
    }
    public Response<List<Property>> getSingleRoomPropertiesAvailability(){
        GetAvailabilityOperationParams params = GetAvailabilityOperationParams.builder()
                .customerIp("192.168.1.1")
                .checkin(LocalDate.now().plusDays(14).toString())
                .checkout(LocalDate.now().plusDays(15).toString())
                .currency("USD")
                .countryCode("US")
                .language("en-US")
                .occupancy(Arrays.asList("2"))
                .propertyId(Arrays.asList("1337"))
                .salesChannel("website")
                .salesEnvironment("hotel_only")
                .ratePlanCount(BigDecimal.ONE)
                .build();

        GetAvailabilityOperation operation = new GetAvailabilityOperation(params);

        return rapidClient.execute(operation);
    }
}
