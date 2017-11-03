package com.smart.bean.p2pinvest1101.app;

import android.app.Application;

import com.smart.bean.p2pinvest1101.util.PhoneInfo;

/**
 * auther   : bean
 * on       : 2017/11/3
 * QQ       : 596928539
 * github   : https://github.com/Xbean1024
 * function :
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PhoneInfo.init(this);
    }
}
