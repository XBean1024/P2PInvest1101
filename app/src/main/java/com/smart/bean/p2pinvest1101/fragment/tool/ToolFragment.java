package com.smart.bean.p2pinvest1101.fragment.tool;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.abs.BaseFragment;
import com.smart.bean.p2pinvest1101.fragment.tool.bean.ToolBean;
import com.smart.bean.p2pinvest1101.util.PhoneInfo;
import com.smart.bean.p2pinvest1101.util.P2PLogger;
import com.smart.holder.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToolFragment extends BaseFragment implements OnViewHolderItemClickedListener {


    GridView mGridViewTest;
    private List<ToolBean> mBeanList;
    public ToolFragment() {
        // Required empty public constructor
    }
    @Override
    protected void initItemView(View rootView) {
        mGridViewTest = rootView.findViewById(R.id.grid_view_test);
        mBeanList = new ArrayList<>();
        ToolBean testBean1 = new ToolBean();
        testBean1.setName("获取手机号");
        mBeanList.add(testBean1);
        for (int i = 0; i < 200; i++) {
            ToolBean testBean = new ToolBean();
            testBean.setName("测试"+i);
            mBeanList.add(testBean);
        }
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tool, container,false);
    }

    @Override
    protected void bindData() {
        mGridViewTest.setAdapter(new CommonAdapter<>(mActivity,mBeanList,R.layout.item_grid_tool,new HolderHelper(this)));
    }

    @Override
    public void onItemClicked(String itemName) {
        if (itemName == "获取手机号") {
            P2PLogger.logInfo(TAG, PhoneInfo.getPhoneInfo());
        }
    }
    final String[] names = new String[]{
            "获取手机号",
    };
}
