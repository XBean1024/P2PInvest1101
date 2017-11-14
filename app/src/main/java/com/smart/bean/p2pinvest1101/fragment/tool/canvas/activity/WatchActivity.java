package com.smart.bean.p2pinvest1101.fragment.tool.canvas.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.util.PhoneInfo;
import com.smart.bean.p2pinvest1101.util.ScreenUtil;
import com.smart.bean.p2pinvest1101.util.Util;

public class WatchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        ScreenUtil.setStatusBarColor(this,Util.getColor(R.color.cyan));
    }

    public void skip(View view) {

    }
}
