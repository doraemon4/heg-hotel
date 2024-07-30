package com.heg.hotel.helper;

import com.heg.hotel.config.KinkiConfig;
import com.heg.hotel.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 近畿平台对接
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/23 13:28
 */
@Slf4j
public class KinkiRetrofitServiceManager {
    private Retrofit retrofit;
    private Long DEFAULT_TIMEOUT = 10L;
    private static Strategy strategy = new AnnotationStrategy();
    private static Serializer serializer = new Persister(strategy);

    private KinkiRetrofitServiceManager() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        builder.addInterceptor(chain -> {
            Request original = chain.request();

            Request.Builder requestBuilder = original.newBuilder()
                    .header("Content-Type", "text/xml;charset=UTF-8")   // 对于SOAP 1.1， 如果是soap1.2 应是Content-Type: application/soap+xml; charset=utf-8
                    .method(original.method(), original.body());

            Request request = requestBuilder.build();
            return chain.proceed(request);
        });

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                //.baseUrl("https://localhost:8080")
                .baseUrl(SpringUtil.getBean(KinkiConfig.class).getProductUrl())
                .build();

    }

    private static class SingletonHolder {
        private static final KinkiRetrofitServiceManager INSTANCE = new KinkiRetrofitServiceManager();
    }

    //获取单例
    public static KinkiRetrofitServiceManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }
}
