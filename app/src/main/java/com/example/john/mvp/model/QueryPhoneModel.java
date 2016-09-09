package com.example.john.mvp.model;

import com.example.john.mvp.presenter.OnQueryPhoneListener;

/**
 * Created by john on 2016/9/9.
 */
public interface QueryPhoneModel {
    //定义一个方法去获取数据
    void getData(OnQueryPhoneListener listener,String nub);
}
