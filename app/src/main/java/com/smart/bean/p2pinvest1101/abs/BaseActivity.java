package com.smart.bean.p2pinvest1101.abs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.smart.bean.p2pinvest1101.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
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
