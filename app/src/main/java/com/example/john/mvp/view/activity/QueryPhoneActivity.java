package com.example.john.mvp.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.john.mvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by john on 2016/9/8.
 */
public class QueryPhoneActivity extends Activity {
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
    @BindView(R.id.btn_query)
    Button btnQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queryphone);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_query)
    public void onClick() {
    }
}
