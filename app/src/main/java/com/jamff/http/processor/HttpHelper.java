package com.jamff.http.processor;

import android.util.Log;

import com.jamff.http.MainActivity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 描述：代理类，实现网络抽象层接口
 * 作者：JamFF
 * 创建时间：2018/5/30 18:24
 */
public enum HttpHelper implements IHttpProcessor {

    INSTANCE;

    private IHttpProcessor mIHttpProcessor;

    public void init(IHttpProcessor httpProcessor) {
        mIHttpProcessor = httpProcessor;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallback callback) {
        String finalURL = appendParams(url, params);
        mIHttpProcessor.post(finalURL, params, callback);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
        String finalURL = appendParams(url, params);
        mIHttpProcessor.get(finalURL, params, callback);
    }

    private String appendParams(String url, Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return url;
        }
        StringBuilder urlBuilder = new StringBuilder(url);
        if (urlBuilder.indexOf("?") <= 0) {
            urlBuilder.append("?");
        } else {
            if (!urlBuilder.toString().endsWith("?")) {
                urlBuilder.append("&");
            }
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (!urlBuilder.toString().endsWith("?") && !urlBuilder.toString().endsWith("&")) {
                urlBuilder.append("&");
            }
            urlBuilder.append(entry.getKey()).append("=").append(encode(entry.getValue().toString()));
        }

        Log.d(MainActivity.TAG, urlBuilder.toString());
        return urlBuilder.toString();
    }

    private String encode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
