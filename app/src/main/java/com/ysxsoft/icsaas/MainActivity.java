package com.ysxsoft.icsaas;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import butterknife.BindView;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ysxsoft.icsaas.common_base.base.ActivityPageManager;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.common_base.base.BaseFragment;
import com.ysxsoft.icsaas.common_base.base.FragmentAdapter;
import com.ysxsoft.icsaas.common_base.utils.KeyBoardUtils;
import com.ysxsoft.icsaas.common_base.widget.NoScrollViewPager;
import com.ysxsoft.icsaas.ui.fragment.Tab1Fragment;
import com.ysxsoft.icsaas.ui.fragment.Tab2Fragment;
import com.ysxsoft.icsaas.ui.fragment.Tab3Fragment;
import com.ysxsoft.icsaas.ui.fragment.Tab4Fragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    NoScrollViewPager viewPager;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    private ArrayList<BaseFragment> mFragmentList = new ArrayList<>();

    @Override
    protected void setListener() {
    }

    @Override
    protected void initData() {
        radioGroup.getChildAt(0).setSelected(true);
        mFragmentList.add(new Tab1Fragment());
        mFragmentList.add(new Tab2Fragment());
        mFragmentList.add(new Tab3Fragment());
        mFragmentList.add(new Tab4Fragment());
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragmentList);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setOffscreenPageLimit(mFragmentList.size());

        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            final int finalI = i;
            radioGroup.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeFragment(finalI);
                }
            });
        }
//        mFragmentList.add(tab1Fragment);
//        mFragmentList.add(tab2Fragment);
//        mFragmentList.add(tab3Fragment);
//        mFragmentList.add(tab4Fragment);
//        MyViewPagerAdapter fragmentAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(fragmentAdapter);
//        viewPager.setOffscreenPageLimit(mFragmentList.size());
//
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.rb1:
//                        viewPager.setCurrentItem(0);
//                        break;
//                    case R.id.rb2:
//                        viewPager.setCurrentItem(1);
//                        break;
//                    case R.id.rb3:
//                        viewPager.setCurrentItem(2);
//                        break;
//                    case R.id.rb4:
//                        viewPager.setCurrentItem(3);
//                        break;
//                }
//            }
//        });
//        radioGroup.check(R.id.rb1);
//        viewPager.setCurrentItem(0);
    }
    public void changeFragment(int tarIndex) {
        viewPager.setCurrentItem(tarIndex);
        for (int i = 0; i < mFragmentList.size(); i++) {
            radioGroup.getChildAt(i).setSelected(i == tarIndex);
        }
    }

    public class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private long time = -1;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - time > 2000) {
            showToast("再次点击退出应用");
            time = System.currentTimeMillis();
        } else {
            ActivityPageManager.getInstance().exit(this);
            super.onBackPressed();
        }
    }
}
