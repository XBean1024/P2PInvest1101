package com.smart.bean.p2pinvest1101.util;

public class DensityUtil {
  
    /** 
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素) 
     */  
    public static int dip2px(float dpValue) {
        final float scale = Util.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);  
    }  
  
    /** 
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp 
     */  
    public static int px2dip(float pxValue) {
        final float scale = Util.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);  
    }  
}  