package com.smart.bean.p2pinvest1101.avtivity;

import android.widget.Toast;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.abs.BaseFragmentActivity;
import com.smart.bean.p2pinvest1101.callback.OnTitleBarClickedListener;
import com.smart.bean.p2pinvest1101.view.TitleBar;

/**
 * auther   : bean
 * on       : 2017/11/2
 * QQ       : 596928539
 * github   : https://github.com/Xbean1024
 * function :
 */

public class WebActivity extends BaseFragmentActivity {
    protected TitleBar mTitleBar;
    @Override
    protected void initTitle() {
        mTitleBar = findViewById(R.id.title_bar);
        mTitleBar.setBackgroundResource(R.drawable.title_bg_grey);
        mTitleBar.setTitleBarClickedListener("首页", R.drawable.title_left, R.drawable.setting_icon, new OnTitleBarClickedListener() {
            @Override
            public void onLeftBtnClicked() {
                Toast.makeText(mActivity, "title_left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightBtnClicked() {
                Toast.makeText(mActivity, "title_right", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void bindData() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
