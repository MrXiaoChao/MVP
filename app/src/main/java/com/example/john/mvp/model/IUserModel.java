package com.example.john.mvp.model;

/**
 * Created by john on 2016/7/7.
 */
public interface IUserModel {
     void login(String username,String password,OnLoginListener listener);
}
