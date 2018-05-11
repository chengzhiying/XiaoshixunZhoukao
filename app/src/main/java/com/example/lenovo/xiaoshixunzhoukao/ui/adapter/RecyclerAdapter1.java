package com.example.lenovo.xiaoshixunzhoukao.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lenovo.xiaoshixunzhoukao.R;
import com.example.lenovo.xiaoshixunzhoukao.data.bean.Entry;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Lenovo on 2018/5/11.
 */

public class RecyclerAdapter1 extends BaseQuickAdapter<Entry.ResultBean.DataBean,BaseViewHolder> {
    public RecyclerAdapter1(int layoutResId, @Nullable List<Entry.ResultBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Entry.ResultBean.DataBean item) {
        helper.setText(R.id.content, item.getContent());
        Picasso.with(mContext).load(item.getUrl()).into((ImageView) helper.getView(R.id.img));
    }
}
