package com.smart.bean.p2pinvest1101.abs;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart.bean.p2pinvest1101.util.P2PLogger;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {

    public final String TAG = this.getClass().getSimpleName();
    protected View mRootView;

    protected Context mContext;
    protected Activity mActivity;

    public BaseFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        P2PLogger.logInfo(TAG,TAG);
        if (mRootView == null) {
            P2PLogger.logInfo("dddddddddddddddddddddd");
            mRootView = initView(inflater, container, savedInstanceState);
            P2PLogger.logInfo("22222222222");
            initItemView(mRootView);
        }
        return mRootView;
    }

    protected abstract void initItemView(View rootView);

    protected abstract View initView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        bindData();
    }

    protected abstract void initData();

    protected abstract void bindData();

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    protected void skipToActivity(Class<?> cls){
        startActivity(new Intent(getActivity(),cls));
    }
}
