package com.jamff.http.processor;

import android.app.Application;
import android.util.Log;

import com.jamff.http.MainActivity;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

/**
 * 描述：XUtils委托类，实现网络抽象层接口
 * 作者：JamFF
 * 创建时间：2018/6/1 9:42
 */
public class XUtilsProcessor implements IHttpProcessor {

    public XUtilsProcessor(Application application) {
        x.Ext.init(application);
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        RequestParams requestParams = new RequestParams(url);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(MainActivity.TAG, "XUtils post onSuccess");
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(MainActivity.TAG, "XUtils post onError");
                callback.onFailure(ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                callback.onFailure(cex.toString());
            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(MainActivity.TAG, "XUtils post onSuccess");
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(MainActivity.TAG, "XUtils get onError");
                callback.onFailure(ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                callback.onFailure(cex.toString());
            }

            @Override
            public void onFinished() {

            }
        });
    }
}
