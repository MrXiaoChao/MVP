package com.example.john.mvp.presenter;

import android.os.Handler;

import com.example.john.mvp.bean.User;
import com.example.john.mvp.model.IUserModel;
import com.example.john.mvp.model.OnLoginListener;
import com.example.john.mvp.model.UserModel;
import com.example.john.mvp.view.IUserLoginView;

/**
 * Created by john on 2016/7/7.
 */
public class UserLoginPresenter implements OnLoginListener {
    private IUserModel userModel;
    private IUserLoginView userLoginView;
    private Handler mhandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userModel = new UserModel();
    }

    public void login() {
        userLoginView.showLoading();
        userModel.login(userLoginView.getUserName(), userLoginView.getPassword(), this);
    }


    public void clear() {
        userLoginView.clearPassword();
        userLoginView.clearUserName();
    }

    @Override
    public void LoginSuccess(final User user) {
        mhandler.post(new Runnable() {
            @Override
            public void run(){
                userLoginView.toMainActivity(user);
                userLoginView.hideLoading();
            }
        });
    }

    @Override
    public void LoginFailed() {
        mhandler.post(new Runnable() {
            @Override
            public void run() {
                userLoginView.showFailedError();
                userLoginView.hideLoading();
            }
        });
    }
}
