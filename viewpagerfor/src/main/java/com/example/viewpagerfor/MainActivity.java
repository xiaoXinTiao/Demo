package com.example.viewpagerfor;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private ViewPager vp;
    private ImageView iv;
    int [] resot = {R.drawable.b2,R.drawable.er,R.drawable.si,R.drawable.yi};
    String [] massage = {"帅哥","双方都","是否","饭店上班"};
    private List <View> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.viewpager_1);
        list = new ArrayList<>();
        list.add(getLayoutInflater().inflate(R.layout.layout,null));
        list.add(getLayoutInflater().inflate(R.layout.layout,null));
        list.add(getLayoutInflater().inflate(R.layout.layout,null));
        list.add(getLayoutInflater().inflate(R.layout.layout,null));
        vp.setAdapter( new MyAdapter());

    }

    private class MyAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            iv = (ImageView) list.get(position).findViewById(R.id.imageView_1);
            tv = (TextView) list.get(position).findViewById(R.id.textview_1);
            tv.setText(massage[position]);
            iv.setImageResource(resot[position]);
            return list.get(position);
        }
    }
}
