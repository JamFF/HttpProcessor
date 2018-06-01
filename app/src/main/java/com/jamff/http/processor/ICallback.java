package com.jamff.http.processor;

/**
 * 描述：回调接口
 * 作者：JamFF
 * 创建时间：2018/5/30 11:28
 */
public interface ICallback {

    void onSuccess(String result);

    void onFailure(String error);
}
