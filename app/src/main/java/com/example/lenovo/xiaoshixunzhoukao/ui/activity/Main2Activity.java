package com.example.lenovo.xiaoshixunzhoukao.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.lenovo.xiaoshixunzhoukao.R;
import com.example.lenovo.xiaoshixunzhoukao.data.bean.Entry;
import com.example.lenovo.xiaoshixunzhoukao.presenter.contract.IContract;
import com.example.lenovo.xiaoshixunzhoukao.presenter.impl.TwoPresenterImpl;
import com.example.lenovo.xiaoshixunzhoukao.ui.adapter.RecyclerAdapter1;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity implements IContract.IView2<IContract.IPresenter2> {
    IContract.IPresenter2 presenter2;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<Entry.ResultBean.DataBean> data;
    private RecyclerAdapter1 recyclerAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        new TwoPresenterImpl(this);
        presenter2.login();
    }


    @Override
    public void setPresenter(IContract.IPresenter2 iPresenter2) {
        presenter2 = iPresenter2;
    }

    @Override
    public void loading() {

    }

    @Override
    public void showData(Entry entry) {
        data = entry.getResult().getData();
        Log.e("-----",data.toString());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                recyclerAdapter1 = new RecyclerAdapter1(R.layout.adapter3, data);
                recycler.setAdapter(recyclerAdapter1);
            }
        });
        recyclerAdapter1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void completed() {

    }
}
