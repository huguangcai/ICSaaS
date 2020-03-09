package com.ysxsoft.icsaas.common_base.base;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Create By 胡
 * on 2020/3/4 0004
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mList;
    private String[] mTitles;

    public FragmentAdapter(FragmentManager fm, List<BaseFragment> list, String[] titles) {
        super(fm);
        mList = list;
        mTitles = titles;
    }

    public FragmentAdapter(FragmentManager fm, List<BaseFragment> list) {
        this(fm, list, null);
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (null == mTitles) {
            return super.getPageTitle(position);
        } else {
            return mTitles[position];
        }
    }
}
