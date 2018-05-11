package com.example.lenovo.xiaoshixunzhoukao.presenter.impl;

import com.example.lenovo.xiaoshixunzhoukao.data.Model;
import com.example.lenovo.xiaoshixunzhoukao.data.bean.Bean;
import com.example.lenovo.xiaoshixunzhoukao.data.model.ModelImpl;
import com.example.lenovo.xiaoshixunzhoukao.presenter.contract.IContract;

/**
 * Created by Lenovo on 2018/5/11.
 */

public class PresenterImpl implements IContract.IPresenter {
    IContract.IView iView;
    private final Model model;

    public PresenterImpl(IContract.IView iView) {
        this.iView=iView;
        iView.setPresenter(this);
        model = new ModelImpl();

    }

    @Override
    public void login() {
        iView.loading();
            model.setOnDataChangeListener(new Model.OnDataChangedListener() {
                @Override
                public void onShowData(Bean bean) {
                    iView.showData(bean);
                    iView.completed();

                }
            });
    }
}
