package com.example.john.mvp.model;

import com.example.john.mvp.bean.User;

/**
 * Created by john on 2016/7/7.
 */
public class UserModel implements IUserModel {
    @Override
    public void login(final String username, final String password, final OnLoginListener listener) {
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("luochao".equals(username) && "123".equals(password)) {
                    User user = new User(username, password);
                    listener.LoginSuccess(user);
                } else {
                    listener.LoginFailed();
                }
            }
        }.start();
    }
}
