package com.example.sharedprefences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1,tv2,tv3,tv4;
    private EditText et1 , et2;
    private Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textview_1);
        tv2 = (TextView) findViewById(R.id.textview_2);
        tv3 = (TextView) findViewById(R.id.textview_3);
        tv4 = (TextView) findViewById(R.id.textview_4);
        et1 = (EditText) findViewById(R.id.edittext_1);
        et2 = (EditText) findViewById(R.id.edittext_2);
        btn1 = (Button) findViewById(R.id.button_1);
        btn2 = (Button) findViewById(R.id.button_2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("1",MODE_WORLD_WRITEABLE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("2",et1.getText().toString());
                editor.putString("3",et2.getText().toString());
                editor.commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("1",MODE_WORLD_WRITEABLE);
                String a = preferences.getString("2","");
                String b = preferences.getString("3","");
                tv3.setText(tv1.getText()+a);
                tv4.setText(tv2.getText()+b);
            }
        });
    }
}
