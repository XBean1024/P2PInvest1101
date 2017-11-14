package com.smart.bean.p2pinvest1101.fragment.tool.canvas.activity;

import android.util.Log;
import android.widget.TextView;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.abs.BaseFragmentActivity;
import com.smart.bean.p2pinvest1101.fragment.tool.canvas.view.RulerView;

public class RulerActivity extends BaseFragmentActivity implements RulerView.OnRulerValueChangedListener {


    private RulerView mRulerView;
    private TextView mRulerValue;

    @Override
    protected int initStatusBarColor() {
        return R.color.yellow;
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_canvas;
    }

    @Override
    protected void initView() {
        mRulerView = findViewById(R.id.ruler_view);
        mRulerValue = findViewById(R.id.ruler_value);
        mRulerView.setOnValueChangedListener(this);
    }

    @Override
    protected void initTitle() {
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindData() {

    }

    @Override
    public void sendValue(String value) {
        Log.i(TAG, "sendValue: "+value);
        mRulerValue.setText("身高 ："+value);
    }
}
