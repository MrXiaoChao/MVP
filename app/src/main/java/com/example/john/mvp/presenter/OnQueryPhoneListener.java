package com.example.john.mvp.presenter;

import com.example.john.mvp.bean.QueryPhoneInfo;

/**
 * Created by john on 2016/9/9.
 */
public interface OnQueryPhoneListener {
    //定义一些获取数据时的状态的方法
    void OnSuccess(QueryPhoneInfo queryPhoneInfo);
    void OnFailed();
}
