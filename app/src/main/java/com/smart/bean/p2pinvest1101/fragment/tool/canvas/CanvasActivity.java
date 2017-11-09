package com.smart.bean.p2pinvest1101.fragment.tool.canvas;

import android.util.Log;
import android.widget.TextView;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.abs.BaseFragmentActivity;
import com.smart.bean.p2pinvest1101.fragment.tool.canvas.view.RulerView;
import com.smart.bean.p2pinvest1101.util.Util;

public class CanvasActivity extends BaseFragmentActivity implements RulerView.OnRulerValueChangedListener {


    private RulerView mRulerView;
    private TextView mRulerValue;
    @Override
    protected int initLayout() {
        return R.layout.activity_anvas;
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
