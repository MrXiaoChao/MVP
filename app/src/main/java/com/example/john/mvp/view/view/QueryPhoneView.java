package com.example.john.mvp.view.view;

import com.example.john.mvp.bean.QueryPhoneInfo;

/**
 * Created by john on 2016/9/9.
 */
public interface QueryPhoneView {
    void setPhoneInfo(QueryPhoneInfo info);

    void showLoading();

    void hideLoading();

    void showError();

    String getPhoneNub();
}
