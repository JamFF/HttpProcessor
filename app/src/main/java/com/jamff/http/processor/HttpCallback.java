package com.jamff.http.processor;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 描述：回调接口的实现
 * 作者：JamFF
 * 创建时间：2018/5/30 11:57
 */
public abstract class HttpCallback<Result> implements ICallback {

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        // clz就是用户输入的类型对应的字节码
        Class<?> clz = analysisClassInfo(this);
        Result objResult = (Result) gson.fromJson(result, clz);
        onSuccess(objResult);
    }

    private Class<?> analysisClassInfo(Object object) {
        // getGenericSuperclass获得带有泛型的父类
        // Type是 Java 编程语言中所有类型的公共高级接口
        // 可以得到包含原始类型，参数化类型，数组类型，类型变量和基本类型
        Type type = object.getClass().getGenericSuperclass();
        // ParameterizedType参数化类型，即泛型
        ParameterizedType p = (ParameterizedType) type;
        // getActualTypeArguments获取参数化类型的数组，泛型可能有多个，例如HttpCallback<Result, T, V>
        Type[] params = p.getActualTypeArguments();
        return (Class<?>) params[0];
    }

    public abstract void onSuccess(Result result);
}
