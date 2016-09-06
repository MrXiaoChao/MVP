package com.example.john.mvp.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.john.mvp.R;
import com.example.john.mvp.bean.Queryer;
import com.example.john.mvp.presenter.QueryerPresenter;
import com.example.john.mvp.view.IQueryerSFZ;
import com.example.john.mvp.volley.VolleyManager;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by john on 2016/7/8.
 */
public class QuerySfActivity extends Activity implements IQueryerSFZ {
    @BindView(R.id.et_query)
    EditText etQuery;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_birthday)
    TextView tvBirthday;
    @BindView(R.id.ll_pb)
    LinearLayout llPb;
    @BindView(R.id.btn_query)
    Button btnQuery;
    private String URL = "http://apis.juhe.cn/idcard/index?dtype=json&key=55c28c474fb1e6e9736b394b235b9ae9&cardno=431024199001172713";
    private QueryerPresenter queryerPresenter=new QueryerPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_querysf);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_query)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_query:
                queryerPresenter.queryer();
                break;
        }
    }

    @Override
    public void queryer() {

    }

    @Override
    public void showMessage(Queryer queryer) {
        tvArea.setText(queryer.getResult().getArea());
        tvBirthday.setText(queryer.getResult().getBirthday());
        tvSex.setText(queryer.getResult().getSex());
    }
}