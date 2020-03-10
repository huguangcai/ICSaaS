package com.ysxsoft.icsaas.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.adapter.RBaseAdapter;
import com.ysxsoft.icsaas.common_base.adapter.RViewHolder;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.common_base.base.FragmentAdapter;
import com.ysxsoft.icsaas.common_base.base.ViewPagerFragmentAdapter;
import com.ysxsoft.icsaas.common_base.widget.NoScrollViewPager;
import com.ysxsoft.icsaas.ui.dialog.AddFileDialog;
import com.ysxsoft.icsaas.ui.fragment.FileCirculationFragment1;
import com.ysxsoft.icsaas.ui.fragment.FileCirculationFragment2;
import com.ysxsoft.icsaas.ui.fragment.FileCirculationFragment3;
import com.ysxsoft.icsaas.ui.fragment.FileCirculationFragment4;
import com.ysxsoft.icsaas.ui.fragment.FileCirculationFragment5;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import q.rorbin.badgeview.QBadgeView;

/**
 * Create By 胡
 * on 2020/3/10 0010
 */
public class FileCirculationActivity extends BaseActivity {

    @BindView(R.id.title_iv_r)
    ImageView title_iv_r;
    @BindView(R.id.viewPager)
    NoScrollViewPager viewPager;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.recyclerView1)
    RecyclerView recyclerView1;

    int clickPostion = 0;
    private List<Fragment> mFragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("文件流转");
        title_iv_r.setBackgroundResource(R.mipmap.icon_add);
    }

    @Override
    protected void setListener() {
        title_iv_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddFileDialog dialog = new AddFileDialog(mContext);
                dialog.setOnDialogListener(new AddFileDialog.OnDialogListener() {
                    @Override
                    public void apply() {
                        toActivity(FileApplyActivity.class);
                    }

                    @Override
                    public void send() {
                        toActivity(FileSendActivity.class);
                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    protected void initData() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new FileCirculationFragment1());
        mFragmentList.add(new FileCirculationFragment2());
        mFragmentList.add(new FileCirculationFragment3());
        mFragmentList.add(new FileCirculationFragment4());
        mFragmentList.add(new FileCirculationFragment5());

        MyViewPagerAdapter fragmentAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setOffscreenPageLimit(mFragmentList.size());
        List<String> titles = new ArrayList<>();
        titles.add("已申请");
        titles.add("待查看");
        titles.add("已寄出");
        titles.add("待确认");
        titles.add("已确认");

        ArrayList<String> datas = new ArrayList<>();
        datas.add("20");
        datas.add("16");
        datas.add("8");
        datas.add("10");
        datas.add("6");
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        RBaseAdapter<String> adapter = new RBaseAdapter<String>(mContext, R.layout.item_activity_file_circulation_layout, datas) {
            @Override
            protected void fillItem(RViewHolder holder, String item, int position) {
                TextView tvPoint = holder.getView(R.id.tvPoint);
                new QBadgeView(mContext)
                        .setBadgeBackgroundColor(Color.WHITE)
                        .setBadgeTextColor(Color.parseColor("#C31A1A"))
                        .stroke(Color.parseColor("#C31A1A"), 1.0f, true)
                        .setBadgePadding(5.0f, true)
                        .bindTarget(tvPoint)
                        .setBadgeNumber(Integer.parseInt(item));
            }

            @Override
            protected int getViewType(String item, int position) {
                return 0;
            }
        };
        recyclerView.setAdapter(adapter);


        LinearLayoutManager manager1 = new LinearLayoutManager(mContext);
        manager1.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView1.setLayoutManager(manager1);
        RBaseAdapter<String> adapter1 = new RBaseAdapter<String>(mContext, R.layout.item_tab_activity_file_circulation_layout, titles) {
            @Override
            protected void fillItem(RViewHolder holder, String item, int position) {
                View line = holder.getView(R.id.line);
                TextView tvContent = holder.getView(R.id.tvContent);
                tvContent.setText(item);
                line.setVisibility(clickPostion == position ? View.VISIBLE : View.INVISIBLE);
            }

            @Override
            protected int getViewType(String item, int position) {
                return 0;
            }
        };
        adapter1.setOnItemClickListener(new RBaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RViewHolder holder, View view, int position) {
                clickPostion = position;
                adapter1.notifyDataSetChanged();
                viewPager.setCurrentItem(position);
            }
        });
        recyclerView1.setAdapter(adapter1);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_file_circulation_layout;
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
}
