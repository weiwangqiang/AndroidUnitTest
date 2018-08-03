package com.demo.demoaunittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private ListView listView ;
    private List<HashMap<String ,String>> data = new ArrayList<>();
    public static final String KEY =  "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        listView  =  findViewById(R.id.list_view);
        initDate();
        listView.setAdapter(new SimpleAdapter(this,data,
                R.layout.item_list,
                new String[]{KEY},
                new int[]{R.id.item_list_text}));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SecondActivity.this,data.get(position).get(KEY),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initDate() {
        for(int i =0 ;i < 90 ;i++){
            HashMap<String,String> map = new HashMap<>();
            map.put(KEY,"第"+(1+i)+"列");
            data.add(map);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        String str = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
    }
}
