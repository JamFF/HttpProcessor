package com.jamff.http;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jamff.http.processor.HttpCallback;
import com.jamff.http.processor.HttpHelper;
import com.jamff.http.processor.OkHttpProcessor;
import com.jamff.http.processor.RetrofitProcessor;
import com.jamff.http.processor.VolleyProcessor;
import com.jamff.http.processor.XUtilsProcessor;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "JamFF";
    private static final String WEATHER_URL = "http://v.juhe.cn/weather/index";
    private static final String RESULT_CODE_OK = "200";
    public static final String CITY_NAME = "cityname";
    public static final String KEY = "key";

    private HashMap<String, Object> params = new HashMap<>();

    private TextView tv_http, tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        findViewById(R.id.bt_get_request).setOnClickListener(this);
        findViewById(R.id.bt_post_request).setOnClickListener(this);
        findViewById(R.id.bt_volley).setOnClickListener(this);
        findViewById(R.id.bt_xutils).setOnClickListener(this);
        findViewById(R.id.bt_okhttp).setOnClickListener(this);
        findViewById(R.id.bt_retrofit).setOnClickListener(this);
        tv_http = findViewById(R.id.tv_http);
        tv_result = findViewById(R.id.tv_result);
    }

    private void initData() {
        params.put(MainActivity.CITY_NAME, "深圳");
        params.put(MainActivity.KEY, "ee625cbd5fbee9be32176f75fd146d6e");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_volley:
                tv_http.setText(R.string.volley);
                HttpHelper.INSTANCE.init(new VolleyProcessor(this));
                break;

            case R.id.bt_xutils:
                tv_http.setText(R.string.xutils);
                HttpHelper.INSTANCE.init(new XUtilsProcessor(this.getApplication()));
                break;

            case R.id.bt_okhttp:
                tv_http.setText(R.string.okhttp);
                HttpHelper.INSTANCE.init(new OkHttpProcessor());
                break;

            case R.id.bt_retrofit:
                tv_http.setText(R.string.retrofit);
                HttpHelper.INSTANCE.init(new RetrofitProcessor());
                break;

            case R.id.bt_get_request:
                HttpHelper.INSTANCE.get(WEATHER_URL, params, new HttpCallback<ResponseBean>() {
                    @Override
                    public void onFailure(String error) {
                        setText("GET_onFailure:\n%s", error);
                    }

                    @Override
                    public void onSuccess(ResponseBean responseBean) {
                        setText("GET_onSuccess: %s\n", responseBean.getReason());
                        printTemperature(responseBean);
                    }
                });
                break;

            case R.id.bt_post_request:
                HttpHelper.INSTANCE.post(WEATHER_URL, params, new HttpCallback<ResponseBean>() {
                    @Override
                    public void onFailure(String error) {
                        setText("POST_onFailure:\n%s", error);
                    }

                    @Override
                    public void onSuccess(ResponseBean responseBean) {
                        setText("POST_onSuccess: %s\n", responseBean.getReason());
                        printTemperature(responseBean);
                    }
                });
                break;
        }
    }

    private void setText(String start, String content) {
        tv_result.setText(String.format(start, content));
    }

    private void printTemperature(ResponseBean bean) {
        if (RESULT_CODE_OK.equals(bean.getResultcode())) {
            tv_result.setText(String.format("%s\ntemperature: %s", tv_result.getText(), bean.getResult().getToday().getTemperature()));
        }
    }
}
