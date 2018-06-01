package com.jamff.http.processor.retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * 描述：
 * 作者：JamFF
 * 创建时间：2018/6/1 11:46
 */
public interface ApiService {

    @GET
    Call<String> getWeather(@Url String key);

    @GET("weather/index")
    Call<String> getWeather2(@QueryMap Map<String, Object> params);

    @POST
    Call<String> postWeather(@Url String key, @QueryMap Map<String, Object> params);

    @POST("weather/index")
    Call<String> postWeather2(@QueryMap Map<String, Object> params);
}
