package com.smart.bean.p2pinvest1101.avtivity;

import android.os.Handler;

import com.smart.bean.p2pinvest1101.MainActivity;
import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.abs.BaseFragmentActivity;

public class WelcomeActivity extends BaseFragmentActivity {

    @Override
    protected void bindData() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_welcome;
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initData() {
        skipToMian();
    }

    private void skipToMian() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                skipToActivity(MainActivity.class);
                finish();
            }
        },3000);
    }
}
