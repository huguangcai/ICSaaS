package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.common_base.base.ViewPagerFragmentAdapter;
import com.ysxsoft.icsaas.ui.dialog.OrdermanagerDialog;
import com.ysxsoft.icsaas.ui.fragment.OrderFragment1;
import com.ysxsoft.icsaas.ui.fragment.OrderFragment2;
import com.ysxsoft.icsaas.ui.fragment.OrderFragment3;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/6 0006
 */
public class OrderActivity extends BaseActivity {

    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("订单管理");
    }

    @Override
    protected void setListener() {
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrdermanagerDialog dialog = new OrdermanagerDialog(mContext);
                dialog.show();
            }
        });
    }

    @Override
    protected void initData() {
        tabLayout.removeAllTabs();
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new OrderFragment1());
        fragmentList.add(new OrderFragment2());
        fragmentList.add(new OrderFragment3());
        List<String> titles = new ArrayList<>();
        titles.add("未交完(10)");
        titles.add("已还清(10)");
        titles.add("全部(20)");
        initViewPage(fragmentList, titles);
        initTabLayout(titles);
    }

    private void initTabLayout(List<String> titles) {
        for (int i = 0; i < titles.size(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(R.layout.view_tab);
            TextView textView = tab.getCustomView().findViewById(R.id.tab);
            textView.setText(titles.get(i));
            if (i == 0) {
                textView.setTextColor(getResources().getColor(R.color.themeColor));
                textView.setTextSize(14);
            } else {
                textView.setTextColor(getResources().getColor(R.color.color_101010));
                textView.setTextSize(14);
            }
        }
        tabLayout.addOnTabSelectedListener(onTabSelectedListener);
    }

    private TabLayout.OnTabSelectedListener onTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab.getCustomView() == null) {
                return;
            }
            TextView tv = tab.getCustomView().findViewById(R.id.tab);
            tv.setTextSize(14);
            tv.setTextColor(getResources().getColor(R.color.themeColor));
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            if (tab.getCustomView() == null) {
                return;
            }
            TextView tv = tab.getCustomView().findViewById(R.id.tab);
            tv.setTextSize(14);
            tv.setTextColor(getResources().getColor(R.color.color_101010));
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };

    private void initViewPage(List<Fragment> fragmentList, List<String> titles) {
        viewPager.setAdapter(new ViewPagerFragmentAdapter(getSupportFragmentManager(), fragmentList, titles));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(fragmentList.size());

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_layout;
    }
}
