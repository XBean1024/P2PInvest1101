package com.smart.bean.p2pinvest1101.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.main.abs.BaseFragmentActivity;
import com.smart.bean.p2pinvest1101.main.fragment.HomepageFragment;
import com.smart.bean.p2pinvest1101.main.fragment.InvestFragment;
import com.smart.bean.p2pinvest1101.main.fragment.MineFragment;
import com.smart.bean.p2pinvest1101.main.fragment.MoreFragment;
import com.smart.bean.p2pinvest1101.util.P2PLogger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseFragmentActivity {

    @BindView(R.id.main_container)
    FrameLayout mMainContainer;
    @BindView(R.id.main_bottom_rg)
    RadioGroup mMainBottomRg;

    private List<Fragment> mFragmentList;
    private FragmentManager mFragmentManager;
    private int mPositon;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        ((RadioButton) (mMainBottomRg.getChildAt(0))).setChecked(true);
        mMainBottomRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.home_page:
                        mPositon = 0;
                        break;
                    case R.id.invest_page:
                        mPositon = 1;
                        P2PLogger.logInfo(TAG, "投资");
                        break;
                    case R.id.mine_page:
                        mPositon = 2;
                        P2PLogger.logInfo(TAG, "我的");
                        break;
                    case R.id.more_page:
                        mPositon = 3;
                        P2PLogger.logInfo(TAG, "更多");
                        break;
                    default:
                        mPositon = 0;
                }
                showFragment();
            }
        });
    }

    private void showFragment() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        for (int i = 0; i < mFragmentList.size(); i++) {
            if (i == mPositon) {
                if (!mFragmentList.get(mPositon).isAdded()) {
                    fragmentTransaction.add(R.id.main_container, mFragmentList.get(mPositon));
                } else {
                    fragmentTransaction.show(mFragmentList.get(mPositon));
                }
            } else {
                if (mFragmentList.get(i).isAdded()) {
                    fragmentTransaction.hide(mFragmentList.get(i));
                }
            }
        }
        fragmentTransaction.commit();
    }

    @Override
    protected void initData() {
        initFragment();
        defaultFragment();
    }

    /**
     * 设置默认的fragment
     */
    private void defaultFragment() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_container, mFragmentList.get(0));
        fragmentTransaction.commit();
    }

    private void initFragment() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomepageFragment());
        mFragmentList.add(new InvestFragment());
        mFragmentList.add(new MineFragment());
        mFragmentList.add(new MoreFragment());
    }
}
