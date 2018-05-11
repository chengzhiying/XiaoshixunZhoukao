package com.example.lenovo.xiaoshixunzhoukao.data;

import com.example.lenovo.xiaoshixunzhoukao.data.bean.Bean;
import com.example.lenovo.xiaoshixunzhoukao.data.bean.Entry;

/**
 * Created by Lenovo on 2018/5/11.
 */

public interface Model {
    void setOnDataChangeListener(OnDataChangedListener listener);

    interface OnDataChangedListener {
        void onShowData(Bean bean);
    }
    void setOnDataChangeListener2(OnDataChangedListener2 listener2);

    interface OnDataChangedListener2 {
        void onShowData(Entry entry);
    }
}
