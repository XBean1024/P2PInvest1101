package com.smart.bean.p2pinvest1101.abs;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.callback.OnTitleBarClickedListener;
import com.smart.bean.p2pinvest1101.view.TitleBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragmentActivity extends FragmentActivity {
    public final String TAG = this.getClass().getSimpleName();
    protected Activity mActivity;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        mActivity = this;
        unbinder = ButterKnife.bind(this);
        initTitle();
        initView();
        initData();
        bindData();
    }




    /** 设置主布局
     * @return 布局id
     */
    protected abstract int initLayout();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 初始化标题栏控件，如果有的话
     */
    protected abstract void initTitle();

    /**
     * 初始化数据
     */
    protected abstract void initData();
    protected abstract void bindData();

    protected void skipToActivity(Class<?> cls){
        startActivity(new Intent(this,cls));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
