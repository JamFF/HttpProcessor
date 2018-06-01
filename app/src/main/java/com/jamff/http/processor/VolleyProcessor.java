package com.jamff.http.processor;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jamff.http.MainActivity;

import java.util.Map;

/**
 * 描述：Volley
 * 作者：JamFF
 * 创建时间：2018/5/31 12:30
 */
public class VolleyProcessor implements IHttpProcessor {

    private RequestQueue mQueue;

    public VolleyProcessor(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(MainActivity.TAG, "Volley post onResponse");
                callback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(MainActivity.TAG, "Volley post onError");
                callback.onFailure(error.toString());
            }
        });

        mQueue.add(request);
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(MainActivity.TAG, "Volley get onResponse");
                callback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(MainActivity.TAG, "Volley get onError");
                callback.onFailure(error.toString());
            }
        });

        mQueue.add(request);
    }
}
