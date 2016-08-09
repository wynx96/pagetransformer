# pagetransformer
一个ViewPager动画切换库,提供了三种动画切换
package com.lyb.viewpagertransformerdemo;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.Map;

public abstract class PageBaseActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ViewPager viewPager;
    private int[] imageIds = new int[]{R.mipmap.guide_image1, R.mipmap.guide_image2, R.mipmap.guide_image3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initView();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);

        viewPager.setPageTransformer(true, getPageTransformer());
    }

    protected abstract ViewPager.PageTransformer getPageTransformer();

    private PagerAdapter pagerAdapter = new PagerAdapter() {
        private Map<Integer, View> viewMap = new HashMap<>();

        public View getView(int id) {
            View view = viewMap.get(id);
            if (view == null) {
                ImageView imageView = new ImageView(PageBaseActivity.this);
                view = imageView;
                viewMap.put(id, view);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(PageBaseActivity.this).fromResource().load(id).into(imageView);
            }
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = getView(imageIds[position]);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return imageIds.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    };
}
