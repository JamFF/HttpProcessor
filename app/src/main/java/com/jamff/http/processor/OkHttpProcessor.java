package com.jamff.http.processor;

import android.os.Handler;
import android.util.Log;

import com.jamff.http.MainActivity;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 描述：OkHttp
 * 作者：JamFF
 * 创建时间：2018/6/1 10:19
 */
public class OkHttpProcessor implements IHttpProcessor {

    private OkHttpClient mOkHttpClient;
    private Handler mHandler;

    public OkHttpProcessor() {
        mOkHttpClient = new OkHttpClient();
        mHandler = new Handler();
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        RequestBody requestBody = appendBody(params);
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(url).post(requestBody).build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                // 网络未连接
                Log.e(MainActivity.TAG, "OkHttp post onFailure");
                // 子线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Log.d(MainActivity.TAG, "OkHttp post onResponse");
                // 子线程
                final String msg;
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        // 响应码在200-300
                        msg = response.body().string();
                    } else {
                        msg = response.toString();
                    }
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccess(msg);
                        }
                    });
                } else {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailure(response.toString());
                        }
                    });
                }
            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(url).get().build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                // 网络未连接
                Log.e(MainActivity.TAG, "OkHttp get onFailure");
                // 子线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Log.d(MainActivity.TAG, "OkHttp get onResponse");
                // 子线程
                final String msg;
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        // 响应码在200-300
                        msg = response.body().string();
                    } else {
                        msg = response.toString();
                    }
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccess(msg);
                        }
                    });
                } else {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailure(response.toString());
                        }
                    });
                }
            }
        });
    }

    private RequestBody appendBody(Map<String, Object> params) {
        FormBody.Builder body = new FormBody.Builder();
        if (params == null || params.isEmpty()) {
            return body.build();
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            body.add(entry.getKey(), entry.getValue().toString());
        }
        return body.build();
    }
}
