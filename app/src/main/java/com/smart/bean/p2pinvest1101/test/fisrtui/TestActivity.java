package com.smart.bean.p2pinvest1101.test.fisrtui;

import android.widget.GridView;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.abs.BaseFragmentActivity;
import com.smart.bean.p2pinvest1101.test.util.PhoneInfo;
import com.smart.bean.p2pinvest1101.util.P2PLogger;
import com.smart.holder.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TestActivity extends BaseFragmentActivity implements ViewHolderItemClickedCallback {


    @BindView(R.id.grid_view_test)
    GridView mGridViewTest;

    private List<TestBean> mBeanList;
    @Override
    protected void bindData() {
        mGridViewTest.setAdapter(new CommonAdapter<>(this,mBeanList,R.layout.test_layout_item,new HolderHelper(this)));
    }

    /**
     * 设置主布局
     *
     * @return 布局id
     */
    @Override
    protected int initLayout() {
        return R.layout.activity_test;
    }

    /**
     * 初始化view
     */
    @Override
    protected void initView() {

    }
    final String[] names = new String[]{
            "获取手机号",
    };
    /**
     * 初始化标题栏控件，如果有的话
     */
    @Override
    protected void initTitle() {

    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        mBeanList = new ArrayList<>();
        TestBean testBean1 = new TestBean();
        testBean1.setName("获取手机号");
        mBeanList.add(testBean1);
        for (int i = 0; i < 20; i++) {
            TestBean testBean = new TestBean();
            testBean.setName("测试"+i);
            mBeanList.add(testBean);
        }
    }

    @Override
    public void onItemClicked(String itemName) {
        if (itemName == "获取手机号") {
            P2PLogger.logInfo(TAG,PhoneInfo.getPhoneInfo());
        }
    }
}
