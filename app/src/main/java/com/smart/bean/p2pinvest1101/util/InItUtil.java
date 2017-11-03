package com.smart.bean.p2pinvest1101.util;

import android.content.Context;

/**
 * auther   : bean
 * on       : 2017/11/3
 * QQ       : 596928539
 * github   : https://github.com/Xbean1024
 * function :
 */

public class InItUtil {
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }
    public static Context getContext(){
        return mContext;
    }
}
