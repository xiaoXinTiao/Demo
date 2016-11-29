package com.example.intentbundleactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView tv1, tv2;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1 = (TextView) findViewById(R.id.textview_01);
        tv2 = (TextView) findViewById(R.id.textview_02);
        btn = (Button) findViewById(R.id.button_01 );
        Bundle bundle = getIntent().getExtras();
        tv1 .setText(tv1.getText().toString()+bundle.getString("1"));
        tv2 .setText(tv2.getText().toString()+bundle.getString("2"));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Main2Activity.this.setResult(0,intent);
                Main2Activity.this.finish();
            }
        });
    }
}
