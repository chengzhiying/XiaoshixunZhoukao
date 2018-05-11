package com.example.lenovo.xiaoshixunzhoukao.presenter.contract;

import com.example.lenovo.xiaoshixunzhoukao.data.bean.Bean;
import com.example.lenovo.xiaoshixunzhoukao.data.bean.Entry;
import com.example.lenovo.xiaoshixunzhoukao.presenter.BasePresenter;
import com.example.lenovo.xiaoshixunzhoukao.ui.BaseView;

/**
 * Created by Lenovo on 2018/5/11.
 */

public interface IContract {
    interface IPresenter extends BasePresenter {
        void login();
    }
    interface IView<IPresenter> extends BaseView<IPresenter> {
        void loading();
        void showData(Bean bean);
        void completed();
    }

    interface IPresenter2 extends BasePresenter {
        void login();
    }
    interface IView2<IPresenter2> extends BaseView<IPresenter2> {
        void loading();
        void showData(Entry entry);
        void completed();
    }
}
