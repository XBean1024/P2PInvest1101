package com.smart.bean.p2pinvest1101.main.abs;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import butterknife.ButterKnife;

public abstract class BaseFragmentActivity extends FragmentActivity {
    public final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initData();


}
