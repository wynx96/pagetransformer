package com.lyb.viewpagertransformerdemo;

import android.support.v4.view.ViewPager;

import com.lyb.pagetransformer.ZoomOutPageTransformer;

public class ZoomOutActivity extends PageBaseActivity {

    @Override
    protected ViewPager.PageTransformer getPageTransformer() {
        return new ZoomOutPageTransformer();
    }
}
