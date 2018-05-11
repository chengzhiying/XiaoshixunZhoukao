package com.example.lenovo.xiaoshixunzhoukao.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.lenovo.xiaoshixunzhoukao.R;
import com.example.lenovo.xiaoshixunzhoukao.data.bean.Bean;
import com.example.lenovo.xiaoshixunzhoukao.presenter.contract.IContract;
import com.example.lenovo.xiaoshixunzhoukao.presenter.impl.PresenterImpl;
import com.example.lenovo.xiaoshixunzhoukao.ui.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IContract.IView<IContract.IPresenter> {
    IContract.IPresenter presenter;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<Bean.ResultBean.DataBean>list;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        new PresenterImpl(this);
        presenter.login();
    }

    @Override
    public void setPresenter(IContract.IPresenter iPresenter) {
        presenter = iPresenter;

    }

    @Override
    public void loading() {

    }

    @Override
    public void showData(Bean bean) {
        list = bean.getResult().getData();
        Log.e("dsfrexdcvfdvff", bean.toString());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerAdapter = new RecyclerAdapter(list,MainActivity.this);
                recycler.setAdapter(MainActivity.this.recyclerAdapter);
            }
        });
        recyclerAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void OnClickListener(String data, int number) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void completed() {

    }
}
