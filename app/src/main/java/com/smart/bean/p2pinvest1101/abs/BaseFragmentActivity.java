package com.smart.bean.p2pinvest1101.abs;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.callback.OnTitleBarClickedListener;
import com.smart.bean.p2pinvest1101.view.TitleBar;

import butterknife.ButterKnife;

public abstract class BaseFragmentActivity extends FragmentActivity {
    public final String TAG = this.getClass().getSimpleName();
    protected Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        mActivity = this;
        ButterKnife.bind(this);
        initView();
        initTitle();
        initData();

    }


    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initTitle();

    protected abstract void initData();


}
