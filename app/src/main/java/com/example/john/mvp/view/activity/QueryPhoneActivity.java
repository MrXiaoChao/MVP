package com.example.john.mvp.view.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.john.mvp.R;
import com.example.john.mvp.bean.QueryPhoneInfo;
import com.example.john.mvp.presenter.QueryPhonePresenter;
import com.example.john.mvp.presenter.QueryPhonePresenterImpl;
import com.example.john.mvp.view.view.QueryPhoneView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by john on 2016/9/9.
 */
public class QueryPhoneActivity extends Activity implements QueryPhoneView {
    @BindView(R.id.et_queryphone)
    EditText etQueryphone;
    @BindView(R.id.tv_province)
    TextView tvProvince;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.tv_card)
    TextView tvCard;

    public QueryPhonePresenter queryPhonePresenter;
    @BindView(R.id.btn_query)
    Button btnQuery;
    @BindView(R.id.btn_SFZ)
    Button btnSFZ;

    private String nub;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queryphone);
        ButterKnife.bind(this);
        initview();
    }

    private void initview() {
        queryPhonePresenter = new QueryPhonePresenterImpl(this);
        dialog = new ProgressDialog(QueryPhoneActivity.this);
        dialog.setMessage("正在加载中...");
    }


    @Override
    public void setPhoneInfo(QueryPhoneInfo info) {
        if (info != null && info.getError_code() == 0) {
            tvProvince.setText(info.getResult().getProvince());
            tvArea.setText(info.getResult().getCity());
            tvCard.setText(info.getResult().getCard());
            tvCompany.setText(info.getResult().getCompany());
        }
    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void hideLoading() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }


    @Override
    public void showError() {
        Toast.makeText(QueryPhoneActivity.this, "出错了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getPhoneNub() {
        return nub = etQueryphone.getText().toString().trim();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        queryPhonePresenter.onDestroy();
    }


    @OnClick({R.id.btn_query, R.id.btn_SFZ})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_query:
                queryPhonePresenter.getData();
                break;

        }
    }
}
