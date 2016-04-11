package com.xiefei.viewpagerdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final String Tag = "MainActivity";
    Bitmap[] bitmaps;
    private LoopViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bitmaps = new Bitmap[]{BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher),BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher)
        ,BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher),BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher),BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher)};
        ImagePagerAdapter pagerAdapter = new ImagePagerAdapter() {
            @Override
            public Bitmap getItem(int position) {
                return bitmaps[position];
            }

            @Override
            public int getCount() {
                return bitmaps.length;
            }
        };
        viewPager = (LoopViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new LoopViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(Tag,"currentPosition->"+position+""+viewPager.getChildAt(viewPager.getChildCount()-1).getLeft());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
