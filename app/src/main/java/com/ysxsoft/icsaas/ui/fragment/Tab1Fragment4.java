package com.ysxsoft.icsaas.ui.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseFragment;
import com.ysxsoft.icsaas.ui.activity.CompanyRegisterActivity;

import butterknife.BindView;
import q.rorbin.badgeview.QBadgeView;

/**
 * Create By 胡
 * on 2020/3/4 0004
 */
public class Tab1Fragment4 extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.fl1)
    FrameLayout fl1;
    @BindView(R.id.fl2)
    FrameLayout fl2;
    @BindView(R.id.fl3)
    FrameLayout fl3;
    @BindView(R.id.fl4)
    FrameLayout fl4;
    @BindView(R.id.fl5)
    FrameLayout fl5;
    @BindView(R.id.fl6)
    FrameLayout fl6;
    @BindView(R.id.fl7)
    FrameLayout fl7;
    @BindView(R.id.fl8)
    FrameLayout fl8;
    @BindView(R.id.fl9)
    FrameLayout fl9;
    @BindView(R.id.tvPoint1)
    TextView tvPoint1;
    @BindView(R.id.tvPoint2)
    TextView tvPoint2;
    @BindView(R.id.tvPoint3)
    TextView tvPoint3;
    @BindView(R.id.tvPoint4)
    TextView tvPoint4;
    @BindView(R.id.tvPoint5)
    TextView tvPoint5;
    @BindView(R.id.tvPoint6)
    TextView tvPoint6;
    @BindView(R.id.tvPoint7)
    TextView tvPoint7;
    @BindView(R.id.tvPoint8)
    TextView tvPoint8;
    @BindView(R.id.tvPoint9)
    TextView tvPoint9;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tab1_tab4;
    }

    @Override
    protected void initData() {
        new QBadgeView(getActivity())
                .setBadgeBackgroundColor(Color.WHITE)
                .setBadgeTextColor(Color.parseColor("#C31A1A"))
                .stroke(Color.parseColor("#C31A1A"), 1.0f, true)
                .setBadgePadding(5.0f, true)
                .bindTarget(tvPoint1)
                .setBadgeNumber(100);

        new QBadgeView(getActivity())
                .setBadgeBackgroundColor(Color.WHITE)
                .setBadgeTextColor(Color.parseColor("#C31A1A"))
                .stroke(Color.parseColor("#C31A1A"), 1.0f, true)
                .setBadgePadding(5.0f, true)
                .bindTarget(tvPoint2)
                .setBadgeNumber(9);
//        new QBadgeView(getActivity())
//                .setBadgeBackgroundColor(Color.WHITE)
//                .setBadgeTextColor(Color.parseColor("#C31A1A"))
//                .stroke(Color.parseColor("#C31A1A"), 1.0f, true)
//                .setBadgePadding(5.0f, true)
//                .bindTarget(tvPoint3)
//                .setBadgeNumber(9);
        new QBadgeView(getActivity())
                .setBadgeBackgroundColor(Color.WHITE)
                .setBadgeTextColor(Color.parseColor("#C31A1A"))
                .stroke(Color.parseColor("#C31A1A"), 1.0f, true)
                .setBadgePadding(5.0f, true)
                .bindTarget(tvPoint4)
                .setBadgeNumber(9);
        new QBadgeView(getActivity())
                .setBadgeBackgroundColor(Color.WHITE)
                .setBadgeTextColor(Color.parseColor("#C31A1A"))
                .stroke(Color.parseColor("#C31A1A"), 1.0f, true)
                .setBadgePadding(5.0f, true)
                .bindTarget(tvPoint5)
                .setBadgeNumber(9);
//        new QBadgeView(getActivity())
//                .setBadgeBackgroundColor(Color.WHITE)
//                .setBadgeTextColor(Color.parseColor("#C31A1A"))
//                .stroke(Color.parseColor("#C31A1A"), 1.0f, true)
//                .setBadgePadding(5.0f, true)
//                .bindTarget(tvPoint6)
//                .setBadgeNumber(9);
//        new QBadgeView(getActivity())
//                .setBadgeBackgroundColor(Color.WHITE)
//                .setBadgeTextColor(Color.parseColor("#C31A1A"))
//                .stroke(Color.parseColor("#C31A1A"), 1.0f, true)
//                .setBadgePadding(5.0f, true)
//                .bindTarget(tvPoint7)
//                .setBadgeNumber(9);
//        new QBadgeView(getActivity())
//                .setBadgeBackgroundColor(Color.WHITE)
//                .setBadgeTextColor(Color.parseColor("#C31A1A"))
//                .stroke(Color.parseColor("#C31A1A"), 1.0f, true)
//                .setBadgePadding(5.0f, true)
//                .bindTarget(tvPoint8)
//                .setBadgeNumber(9);
//        new QBadgeView(getActivity())
//                .setBadgeBackgroundColor(Color.WHITE)
//                .setBadgeTextColor(Color.parseColor("#C31A1A"))
//                .stroke(Color.parseColor("#C31A1A"), 1.0f, true)
//                .setBadgePadding(5.0f, true)
//                .bindTarget(tvPoint9)
//                .setBadgeNumber(9);

    }

    @Override
    protected void setListener() {
        fl1.setOnClickListener(this);
        fl2.setOnClickListener(this);
        fl3.setOnClickListener(this);
        fl4.setOnClickListener(this);
        fl5.setOnClickListener(this);
        fl6.setOnClickListener(this);
        fl7.setOnClickListener(this);
        fl8.setOnClickListener(this);
        fl9.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl1:
                toActivity(CompanyRegisterActivity.class);
                break;
            case R.id.fl2:
                break;
            case R.id.fl3:
                break;
            case R.id.fl4:
                break;
            case R.id.fl5:
                break;
            case R.id.fl6:
                break;
            case R.id.fl7:
                break;
            case R.id.fl8:
                break;
            case R.id.fl9:
                break;
        }
    }
}
