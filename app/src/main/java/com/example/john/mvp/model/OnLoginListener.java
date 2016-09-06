package com.example.john.mvp.model;

import com.example.john.mvp.bean.User;

/**
 * Created by john on 2016/7/7.
 */
public interface OnLoginListener {
    void LoginSuccess(User user);
    void LoginFailed();
}
