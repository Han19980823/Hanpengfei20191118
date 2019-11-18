package week1.dianshangjinjie.bw.com.demo1;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.demo1.base.BaseActicity;

public class MainActivity extends BaseActicity {


    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

}
