package com.example.viewpagersan;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp;
    int [] ps = {R.drawable.a,R.drawable.b,R.drawable.e,R.drawable.h};
    private List <View> list;
    private ImageView iv;
    String [] satr = {"多久发货","诛仙","辛苦","客户端"};

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
        public CharSequence getPageTitle(int position) {
            return satr[position];
        }

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
            iv= (ImageView) list.get(position).findViewById(R.id.imageview_1);
            iv.setImageResource(ps[position]);
            return list.get(position);
        }
    }
}
