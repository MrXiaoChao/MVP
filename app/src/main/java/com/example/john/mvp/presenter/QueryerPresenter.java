package com.example.john.mvp.presenter;

import com.example.john.mvp.bean.Queryer;
import com.example.john.mvp.model.IQueryModel;
import com.example.john.mvp.model.OnQueryerListener;
import com.example.john.mvp.model.QueryModel;
import com.example.john.mvp.view.IQueryerSFZ;

/**
 * Created by john on 2016/8/4.
 */
public class QueryerPresenter implements OnQueryerListener {
    private IQueryModel queryModel;
    private IQueryerSFZ queryerSFZ;

    public QueryerPresenter(IQueryerSFZ iQueryerSFZ) {
        this.queryerSFZ = iQueryerSFZ;
        this.queryModel=new QueryModel();
    }

    @Override
    public void QueryerSuccess(Queryer queryer) {
        queryerSFZ.showMessage(queryer);
    }
    public void queryer(){
        queryModel.queryer(this);
    }
}
