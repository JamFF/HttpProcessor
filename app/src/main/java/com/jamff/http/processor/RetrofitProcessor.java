package com.jamff.http.processor;

import android.util.Log;

import com.jamff.http.MainActivity;
import com.jamff.http.processor.retrofit.ApiService;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * 描述：Retrofit
 * 作者：JamFF
 * 创建时间：2018/6/1 11:13
 */
public class RetrofitProcessor implements IHttpProcessor {

    private static final String BASE_URL = "http://v.juhe.cn/";
    private ApiService mApiService;

    public RetrofitProcessor() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        mApiService = retrofit.create(ApiService.class);
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        Call<String> call = mApiService.postWeather(url, params);
//        Call<String> call = mApiService.postWeather2(params);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, final Response<String> response) {
                Log.d(MainActivity.TAG, "Retrofit post onResponse");
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        // 响应码在200-300
                        callback.onSuccess(response.body());
                    } else {
                        callback.onSuccess(response.toString());
                    }
                } else {
                    callback.onFailure(response.toString());
                }
            }

            @Override
            public void onFailure(Call<String> call, final Throwable t) {
                // 网络未连接
                Log.e(MainActivity.TAG, "Retrofit post onFailure");
                callback.onFailure(t.toString());
            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        Call<String> call = mApiService.getWeather(url);
//        Call<String> call = mApiService.getWeather2(params);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, final Response<String> response) {
                Log.d(MainActivity.TAG, "Retrofit post onResponse");
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        // 响应码在200-300
                        callback.onSuccess(response.body());
                    } else {
                        callback.onSuccess(response.toString());
                    }
                } else {
                    callback.onFailure(response.toString());
                }
            }

            @Override
            public void onFailure(Call<String> call, final Throwable t) {
                // 网络未连接
                Log.e(MainActivity.TAG, "Retrofit post onFailure");
                callback.onFailure(t.toString());
            }
        });
    }
}
