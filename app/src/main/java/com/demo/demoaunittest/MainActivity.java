
package com.demo.demoaunittest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static String EXTRA_MESSAGE = "message";
    public static String action = "com.demo.demoaunittest.MainActivity";
    private TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.main_text) ;
        Intent intent = getIntent() ;
        String title = intent.getStringExtra(EXTRA_MESSAGE);
        if(!TextUtils.isEmpty(title)){
            textView.setText(title);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: ");
                Intent intent = new Intent(action);
                intent.addCategory("Main");
                startActivity(intent);
            }
        });
    }
}
