package com.example.intentbundleactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1 , tv2 , tv3 , tv4;
    private EditText et1 , et2;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textview_1);
        tv2 = (TextView) findViewById(R.id.textview_2);
        et1 = (EditText) findViewById(R.id.edittext_1);
        et2 = (EditText) findViewById(R.id.edittext_2);
        btn = (Button) findViewById(R.id.button_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("1",et1.getText().toString());
                bundle.putString("2",et2.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle b = data.getExtras();
        et1.setText(b.getString("1"));
        et2.setText(b.getString("2"));
    }
}
