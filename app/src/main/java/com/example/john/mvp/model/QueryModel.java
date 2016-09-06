package com.example.john.mvp.model;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.john.mvp.bean.Queryer;
import com.example.john.mvp.volley.VolleyManager;

/**
 * Created by john on 2016/8/4.
 */
public class QueryModel implements IQueryModel{
    private String URL = "http://apis.juhe.cn/idcard/index?dtype=json&key=55c28c474fb1e6e9736b394b235b9ae9&cardno=431024199001172713";
    @Override
    public void queryer(final OnQueryerListener listener) {
        VolleyManager.newInstance().GsonGetRequest("a", URL, Queryer.class, new Response.Listener<Queryer>() {
            @Override
            public void onResponse(Queryer response) {
                listener.QueryerSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
