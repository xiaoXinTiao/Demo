package com.example.viewpager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp;
    private ImageView iv;
    private int[] imgId = {R.drawable.er,R.drawable.meinv,R.drawable.timg1,R.drawable.yi};
    private List<View> list;
    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.act_vp);
        list = new ArrayList<>();
        list.add(getLayoutInflater().inflate(R.layout.vp_item,null));
        list.add(getLayoutInflater().inflate(R.layout.vp_item,null));
        list.add(getLayoutInflater().inflate(R.layout.vp_item,null));
        list.add(getLayoutInflater().inflate(R.layout.vp_item,null));
        vp.setAdapter(new MyAdapter());
    }
    class MyAdapter extends PagerAdapter{
        // 获取viewpager的长度
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            ImageView img = (ImageView) list.get(position).findViewById(R.id.item_img);
            img.setImageResource(imgId[position]);
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag = false;
    }
}
