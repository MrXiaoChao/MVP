package com.example.john.mvp.model;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.john.mvp.bean.QueryPhoneInfo;
import com.example.john.mvp.presenter.OnQueryPhoneListener;
import com.example.john.mvp.volley.VolleyManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by john on 2016/9/9.
 * QueryPhoneModel实现类
 */
public class QueryPhoneModelImpl implements QueryPhoneModel {
    //具体是怎么去取数据的实现
    private String URL = "http://apis.juhe.cn/mobile/get?";

    @Override
    public void getData(final OnQueryPhoneListener listener, String nub) {
        Map<String, String> params = new HashMap<>();
        params.put("phone", nub);
        params.put("dtype", "");
        params.put("key", "46066e52ff348681e2e3b22669c0cd89");
        VolleyManager.newInstance().GsonPostRequest("a", params, URL, QueryPhoneInfo.class, new Response.Listener<QueryPhoneInfo>() {
            @Override
            public void onResponse(QueryPhoneInfo response) {
                if (response.getResult() == null) {
                    listener.OnFailed();
                } else {
                    listener.OnSuccess(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.OnFailed();
            }
        });
    }
}
