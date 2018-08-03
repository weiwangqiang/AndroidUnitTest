package com.demo.demoaunittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.demo.demoaunittest.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter<>(this, R.layout.item_list);
        recyclerView.setAdapter(adapter);
        List<String> list = new ArrayList<>();
        for(int i =0 ;i < 50 ;i++){
            list.add("第"+(1+i)+"列");
        }
        adapter.setData(list);
    }
}
