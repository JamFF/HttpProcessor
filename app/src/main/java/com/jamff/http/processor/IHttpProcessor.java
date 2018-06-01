package com.jamff.http.processor;

import java.util.Map;

/**
 * 描述：网络抽象层接口
 * 作者：JamFF
 * 创建时间：2018/5/30 11:26
 */
public interface IHttpProcessor {

    /**
     * post请求
     */
    void post(String url, Map<String, Object> params, ICallback callback);

    /**
     * get请求
     */
    void get(String url, Map<String, Object> params, ICallback callback);
}
