package com.smart.bean.p2pinvest1101.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.abs.BaseFragment;
import com.smart.bean.p2pinvest1101.avtivity.WebActivity;

/**
 * auther   : bean
 * on       : 2017/11/1
 * QQ       : 596928539
 * github   : https://github.com/Xbean1024
 * function :
 */

public class HomepageFragment extends BaseFragment {

    TextView mHomeTextBtn;

    @Override
    protected void initItemView(View rootView) {
        mHomeTextBtn = rootView.findViewById(R.id.home_text_btn);
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindData() {
        mHomeTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.startActivity(new Intent(mActivity, WebActivity.class));
            }
        });
    }


}
