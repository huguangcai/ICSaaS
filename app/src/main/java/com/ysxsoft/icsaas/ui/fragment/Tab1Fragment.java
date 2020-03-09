package com.ysxsoft.icsaas.ui.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseFragment;
import com.ysxsoft.icsaas.common_base.base.ViewPagerFragmentAdapter;
import com.ysxsoft.icsaas.common_base.utils.DeviceUtils;
import com.ysxsoft.icsaas.common_base.utils.DisplayUtils;
import com.ysxsoft.icsaas.common_base.utils.KeyBoardUtils;
import com.ysxsoft.icsaas.common_base.utils.TimerUtils;
import com.ysxsoft.icsaas.ui.activity.NewAddWaitDoActivity;
import com.ysxsoft.icsaas.ui.dialog.Tab1RightInRightOutDialog;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/4 0004
 */
public class Tab1Fragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.title_left)
    TextView title_left;
    @BindView(R.id.title_content)
    TextView title_content;
    @BindView(R.id.title_iv_r)
    ImageView title_iv_r;


    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    public void onResume() {
        super.onResume();
        title_iv_r.setBackgroundResource(R.mipmap.icon_add_circle);
        title_left.setText("工作台");
        title_content.setText(TimerUtils.StringData() + " " + TimerUtils.getWeek(TimerUtils.StringData()));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tab1;
    }

    @Override
    protected void initData() {
        KeyBoardUtils.hideInputMethod(getActivity());
        tabLayout.removeAllTabs();
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new Tab1Fragment1());
        fragmentList.add(new Tab1Fragment2());
        fragmentList.add(new Tab1Fragment3());
        fragmentList.add(new Tab1Fragment4());
        List<String> titles = new ArrayList<>();
        titles.add("代办(10)");
        titles.add("办理中(6)");
        titles.add("已完成(6)");
        titles.add("业务总览");
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
        viewPager.setAdapter(new ViewPagerFragmentAdapter(getChildFragmentManager(), fragmentList, titles));
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
    protected void setListener() {
        tv1.setOnClickListener(this);
        title_iv_r.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                tv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tab1RightInRightOutDialog dialog = new Tab1RightInRightOutDialog(mContext);
                        dialog.show();
                    }
                });
                break;
            case R.id.title_iv_r:
                toActivity(NewAddWaitDoActivity.class);
                break;
        }
    }
}
