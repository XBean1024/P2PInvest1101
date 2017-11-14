package com.smart.bean.p2pinvest1101.fragment.tool.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.abs.BaseFragment;
import com.smart.bean.p2pinvest1101.fragment.tool.bean.ToolBean;
import com.smart.bean.p2pinvest1101.fragment.tool.canvas.activity.RulerActivity;
import com.smart.bean.p2pinvest1101.fragment.tool.canvas.activity.ScaleViewActivity;
import com.smart.bean.p2pinvest1101.fragment.tool.canvas.activity.WatchActivity;
import com.smart.bean.p2pinvest1101.fragment.tool.canvas.view.ScaleView;
import com.smart.bean.p2pinvest1101.fragment.tool.music.MusicActivity;
import com.smart.bean.p2pinvest1101.util.Util;
import com.smart.holder.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToolFragment extends BaseFragment implements OnViewHolderItemClickedListener {


    GridView mGridViewTest;
    private List<ToolBean> mBeanList;
    private String mToolItems[];
    public ToolFragment() {
        // Required empty public constructor
    }


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tool, container,false);
    }

    @Override
    protected void initItemView(View rootView) {
        mGridViewTest = rootView.findViewById(R.id.grid_view_test);

    }
    @Override
    protected void initData() {
        mBeanList = new ArrayList<>();
         mToolItems = Util.getStringArray(R.array.tool_item);
        int len = mToolItems.length;
        for (String anArray : mToolItems) {
            ToolBean testBean = new ToolBean();
            testBean.setName(anArray);
            mBeanList.add(testBean);
        }
    }

    @Override
    protected void bindData() {
        mGridViewTest.setAdapter(new CommonAdapter<>(mActivity,mBeanList,R.layout.item_grid_tool,new HolderHelper(this)));
    }

    @Override
    public void onItemClicked(String itemName) {
        if (itemName == mToolItems[0]) {//music
            skipToActivity(MusicActivity.class);
        }
        else if (itemName == mToolItems[1]) {//尺子
            skipToActivity(RulerActivity.class);
        }
        else if (itemName == mToolItems[2]) {//表盘
            skipToActivity(WatchActivity.class);
        }
        else if (itemName == mToolItems[3]) {//缩放
            skipToActivity(ScaleViewActivity.class);
        }
    }

}
