package com.example.lenovo.xiaoshixunzhoukao.presenter.impl;

import com.example.lenovo.xiaoshixunzhoukao.data.Model;
import com.example.lenovo.xiaoshixunzhoukao.data.bean.Bean;
import com.example.lenovo.xiaoshixunzhoukao.data.bean.Entry;
import com.example.lenovo.xiaoshixunzhoukao.data.model.ModelImpl;
import com.example.lenovo.xiaoshixunzhoukao.presenter.contract.IContract;
import com.example.lenovo.xiaoshixunzhoukao.ui.activity.Main2Activity;

/**
 * Created by Lenovo on 2018/5/11.
 */

public class TwoPresenterImpl implements IContract.IPresenter2 {
    IContract.IView2 iView2;
    private  ModelImpl model;
    public TwoPresenterImpl(IContract.IView2 iView2) {
        this.iView2=iView2;
        iView2.setPresenter(this);
        model = new ModelImpl();
    }


    @Override
    public void login() {
        model.setOnDataChangeListener2(new Model.OnDataChangedListener2() {
            @Override
            public void onShowData(Entry entry) {
                iView2.showData(entry);
            }
        });
    }
}
