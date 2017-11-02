package com.smart.bean.p2pinvest1101.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.callback.OnTitleBarClickedListener;
import com.smart.bean.p2pinvest1101.util.P2PLogger;

/**
 * auther   : bean
 * on       : 2017/11/2
 * QQ       : 596928539
 * github   : https://github.com/Xbean1024
 * function : 自定义标题栏
 */

public class TitleBar extends LinearLayout implements View.OnClickListener {
    public void setTitleBarClickedListener(String titleText, Integer leftImgRes, Integer rightImgRes, OnTitleBarClickedListener titleBarClickedListener) {
        mTitleBarClickedListener = titleBarClickedListener;
        mTitleText = titleText;
        mRightImgRes = rightImgRes;
        mLeftImgRes = leftImgRes;
        initTitleBar();
    }


    private ImageView mTitleBarLeftImg, mTitleBarRightImg;
    private Integer mLeftImgRes, mRightImgRes;

    private TextView mTitleBarText;
    private String mTitleText;
    private OnTitleBarClickedListener mTitleBarClickedListener;

    public TitleBar(Context context) {
        super(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTitleBarLeftImg = findViewById(R.id.title_bar_left_btn);
        mTitleBarRightImg = findViewById(R.id.title_bar_right_btn);
        mTitleBarText = findViewById(R.id.title_bar_text);
        mTitleBarLeftImg.setOnClickListener(this);
        mTitleBarRightImg.setOnClickListener(this);
    }

    private void initTitleBar() {
        if (null != mLeftImgRes) {
            mTitleBarLeftImg.setImageResource(mLeftImgRes);
        }
        if (null != mRightImgRes) {
            mTitleBarRightImg.setImageResource(mRightImgRes);
        }
        if (null != mTitleText) {
            mTitleBarText.setText(mTitleText);
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_bar_left_btn:
                mTitleBarClickedListener.onLeftBtnClicked();
                break;
            case R.id.title_bar_right_btn:
                P2PLogger.logInfo("sss","sssssssssssssss");
                mTitleBarClickedListener.onRightBtnClicked();
                break;
        }
    }
}
