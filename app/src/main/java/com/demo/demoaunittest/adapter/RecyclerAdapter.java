package com.demo.demoaunittest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.demoaunittest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * class description here
 *
 * @author wangqiang
 * @since 2018-05-12
 */
public class RecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<T> data = new ArrayList<>();
    private Context context ;
    private int layout;

    public RecyclerAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;
    }

    public void setData(List<T> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context)
                .inflate(layout,null,false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Holder holder1 = (Holder) holder;
        holder1.textView.setText(data.get(position).toString());
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,data.get(position).toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    private class Holder extends RecyclerView.ViewHolder{
        TextView textView ;
        public Holder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_list_text);
        }
    }
}
