package com.smart.bean.p2pinvest1101.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.abs.BaseFragment;
import com.smart.bean.p2pinvest1101.avtivity.WebActivity;
import com.smart.bean.p2pinvest1101.callback.OnTitleBarClickedListener;

/**
 * auther   : bean
 * on       : 2017/11/1
 * QQ       : 596928539
 * github   : https://github.com/Xbean1024
 * function :
 */

public class HomepageFragment extends BaseFragment {

    @Override
    protected void initItmeView(View rootView) {
        TextView textView = rootView.findViewById(R.id.home_text_btn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.startActivity(new Intent(mActivity, WebActivity.class));
            }
        });
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    protected void bindData() {

    }
}
