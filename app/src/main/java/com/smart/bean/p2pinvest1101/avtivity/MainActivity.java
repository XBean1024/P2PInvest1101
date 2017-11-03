package com.smart.bean.p2pinvest1101.avtivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.smart.bean.p2pinvest1101.R;
import com.smart.bean.p2pinvest1101.abs.BaseFragmentActivity;
import com.smart.bean.p2pinvest1101.fragment.home.HomepageFragment;
import com.smart.bean.p2pinvest1101.fragment.means.MeansFragment;
import com.smart.bean.p2pinvest1101.fragment.news.NewsFragment;
import com.smart.bean.p2pinvest1101.fragment.mine.MineFragment;
import com.smart.bean.p2pinvest1101.fragment.tool.ToolFragment;
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
    private long mFirstClickBackKeyTime;

    @Override
    protected void bindData() {

    }

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
                    case R.id.means_page:
                        mPositon = 1;
                        P2PLogger.logInfo(TAG, "投资");
                        break;
                    case R.id.news_page:
                        mPositon = 2;
                        P2PLogger.logInfo(TAG, "我的");
                        break;
                    case R.id.more_page:
                        mPositon = 3;
                        P2PLogger.logInfo(TAG, "更多");
                        break;
                    case R.id.tool_page:
                        mPositon = 4;
                        P2PLogger.logInfo(TAG, "工具");
                        break;
                    default:
                        mPositon = 0;
                }
                showFragment();
            }
        });
    }

    @Override
    protected void initTitle() {

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
        mFragmentList.add(new MeansFragment());
        mFragmentList.add(new NewsFragment());
        mFragmentList.add(new MineFragment());
        mFragmentList.add(new ToolFragment());
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        long deltTime = System.currentTimeMillis() - mFirstClickBackKeyTime;
        mFirstClickBackKeyTime = System.currentTimeMillis();
        if (keyCode == KeyEvent.KEYCODE_BACK && deltTime < 2000) {
            return super.onKeyUp(keyCode, event);
        } else {
            Toast.makeText(mActivity, "点击两次退出！", Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
