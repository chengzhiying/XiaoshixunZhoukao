package com.example.lenovo.xiaoshixunzhoukao.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.xiaoshixunzhoukao.R;
import com.example.lenovo.xiaoshixunzhoukao.data.bean.Bean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Lenovo on 2018/5/11.
 */

public class RecyclerAdapter extends RecyclerView.Adapter {
   private List<Bean.ResultBean.DataBean>list;
    private Context context;
    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;

    public RecyclerAdapter(List<Bean.ResultBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }





    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new One(layoutInflater.inflate(R.layout.adapter, null));
        } else {
            return new Two(layoutInflater.inflate(R.layout.adapter2, null));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof One) {
            ((One) holder).content.setText(list.get(position).getContent());
            Picasso.with(context).load(list.get(position).getUrl1()).into(((One) holder).img);
        }
        if (holder instanceof Two) {
            ((Two) holder).content.setText(list.get(position).getContent());
            Picasso.with(context).load(list.get(position).getUrl2()).into(((Two) holder).img);
            Picasso.with(context).load(list.get(position).getUrl2()).into(((Two) holder).img2);



        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.OnClickListener(list.get(position).toString(), position);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getUrl2() != null && !list.get(position).getUrl2().equals("")) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class One extends RecyclerView.ViewHolder {
        private TextView  content;
        private ImageView img;

        public One(View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.content);
            img = itemView.findViewById(R.id.img);

        }
    }

    class Two extends RecyclerView.ViewHolder {
        private TextView content;
        private ImageView img, img2;

        public Two(View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.content);
            img = itemView.findViewById(R.id.img);
            img2 = itemView.findViewById(R.id.img2);

        }
    }

    public interface OnItemClickListener {
        void OnClickListener(String data, int number);
    }
}
