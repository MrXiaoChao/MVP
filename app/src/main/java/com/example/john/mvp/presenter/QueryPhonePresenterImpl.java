package com.example.john.mvp.presenter;

import com.example.john.mvp.bean.QueryPhoneInfo;
import com.example.john.mvp.model.QueryPhoneModel;
import com.example.john.mvp.model.QueryPhoneModelImpl;
import com.example.john.mvp.view.view.QueryPhoneView;

/**
 * Created by john on 2016/9/9.
 */
public class QueryPhonePresenterImpl implements QueryPhonePresenter, OnQueryPhoneListener {
    private QueryPhoneView mqueryPhoneView;
    private QueryPhoneModel queryPhoneModel;

    public QueryPhonePresenterImpl(QueryPhoneView queryPhoneView) {
        this.mqueryPhoneView = queryPhoneView;
        queryPhoneModel = new QueryPhoneModelImpl();
    }

    @Override
    public void getData() {
        mqueryPhoneView.showLoading();
        queryPhoneModel.getData(this,mqueryPhoneView.getPhoneNub());
    }

    @Override
    public void onDestroy() {
        this.mqueryPhoneView=null;
    }

    @Override
    public void OnSuccess(QueryPhoneInfo queryPhoneInfo) {
        mqueryPhoneView.setPhoneInfo(queryPhoneInfo);
        mqueryPhoneView.hideLoading();
    }

    @Override
    public void OnFailed() {
        mqueryPhoneView.hideLoading();
        mqueryPhoneView.showError();
    }
}
