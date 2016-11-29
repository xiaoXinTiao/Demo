package com.example.viewpagertow;

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
    private int[] resid = {R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h};
    private List<View> list;
    private String[] stas = {"大毛", "二毛", "三毛", "四毛"};
    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.viewpager_1);
        list = new ArrayList<>();
        list.add(getLayoutInflater().inflate(R.layout.layout, null));
        list.add(getLayoutInflater().inflate(R.layout.layout, null));
        list.add(getLayoutInflater().inflate(R.layout.layout, null));
        list.add(getLayoutInflater().inflate(R.layout.layout, null));
        vp.setAdapter(new MyAdapter());
    }

    //设置标题
    private class MyAdapter extends PagerAdapter {
        @Override
        public CharSequence getPageTitle(int position) {
            return stas[position];
        }

        //获取数据源的长度
        @Override
        public int getCount() {
            return list.size();
        }

        //判断当前视图是否是根据 指定的key 来创建的
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
            //销毁当前子视图
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));

        }
        //将指定视图放进容器

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            ImageView iv = (ImageView) list.get(position).findViewById(R.id.imageView_1);
            iv.setImageResource(resid[position]);
            return list.get(position);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag = false;
    }
}
