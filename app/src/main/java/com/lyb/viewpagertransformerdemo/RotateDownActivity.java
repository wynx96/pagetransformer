package com.lyb.viewpagertransformerdemo;

import android.support.v4.view.ViewPager;

import com.lyb.pagetransformer.RotateDownPageTransformer;

public class RotateDownActivity extends PageBaseActivity {
    @Override
    protected ViewPager.PageTransformer getPageTransformer() {
        return new RotateDownPageTransformer();
    }
}
