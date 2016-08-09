package com.lyb.viewpagertransformerdemo;

import android.support.v4.view.ViewPager;

import com.lyb.pagetransformer.DepthPageTransformer;

public class DepthActivity extends PageBaseActivity {

    @Override
    protected ViewPager.PageTransformer getPageTransformer() {
        return new DepthPageTransformer();
    }
}
