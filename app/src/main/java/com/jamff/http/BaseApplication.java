package com.jamff.http;

import android.app.Application;

import com.jamff.http.processor.HttpHelper;
import com.jamff.http.processor.VolleyProcessor;

/**
 * 描述：
 * 作者：JamFF
 * 创建时间：2018/5/31 12:38
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 进行框架选择
        HttpHelper.INSTANCE.init(new VolleyProcessor(this));
//        HttpHelper.INSTANCE.init(new XUtilsProcessor(this));
//        HttpHelper.INSTANCE.init(new OkHttpProcessor());
//        HttpHelper.INSTANCE.init(new RetrofitProcessor());
    }
}
