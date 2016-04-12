package com.xiefei.viewpagerdemo;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by xiefei on 2016/4/10.
 */
public abstract class ImagePagerAdapter extends PagerAdapter{
    private final String Tag = "ImagePagerAdapter";
    private ImageView preImageView;
    public ImagePagerAdapter(){
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView;
        if(preImageView == null){
            imageView = new ImageView(container.getContext());
        }else
            imageView = preImageView;
        preImageView = null;
        Log.d(Tag,imageView.toString());
        imageView.setImageBitmap(getItem(position));
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        preImageView = (ImageView) object;
        Log.d(Tag,preImageView.toString());
        container.removeView(preImageView);
    }

    public abstract Bitmap getItem(int position);
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
