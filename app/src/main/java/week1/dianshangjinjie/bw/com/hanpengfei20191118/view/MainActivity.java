package week1.dianshangjinjie.bw.com.hanpengfei20191118.view;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.R;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.adapter.MyFragmentAdapter;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.base.BaseActivity;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.fragment.HomeFragment;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.fragment.MyFragment;

public class MainActivity extends BaseActivity {


    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    private List<String> slist = new ArrayList<>();
    private List<Fragment> flist = new ArrayList<>();
    @Override
    protected void initData() {
        slist.add("首页");
        slist.add("我的");
        flist.add(new HomeFragment());
        flist.add(new MyFragment());
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),slist,flist));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.GREEN,Color.RED);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

}
