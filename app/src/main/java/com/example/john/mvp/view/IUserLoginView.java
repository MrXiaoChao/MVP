package com.example.john.mvp.view;

import com.example.john.mvp.bean.User;

/**
 * Created by john on 2016/7/7.
 */
public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();


}
