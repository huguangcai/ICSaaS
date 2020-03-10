package com.ysxsoft.icsaas.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseFragment;
import com.ysxsoft.icsaas.ui.activity.ContractManageActivity;
import com.ysxsoft.icsaas.ui.activity.ContractWarningActivity;
import com.ysxsoft.icsaas.ui.activity.FileCirculationActivity;
import com.ysxsoft.icsaas.ui.activity.OrderActivity;
import com.ysxsoft.icsaas.ui.activity.OrderWarningActivity;

import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/4 0004
 */
public class Tab2Fragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.title_left)
    TextView title_left;
    @BindView(R.id.title_iv_r)
    ImageView title_iv_r;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.tv6)
    TextView tv6;
    @BindView(R.id.tv7)
    TextView tv7;
    @BindView(R.id.tv8)
    TextView tv8;
    @BindView(R.id.tv9)
    TextView tv9;
    @BindView(R.id.tv10)
    TextView tv10;
    @BindView(R.id.tv11)
    TextView tv11;
    @BindView(R.id.tv12)
    TextView tv12;
    @BindView(R.id.tv13)
    TextView tv13;
    @BindView(R.id.tv14)
    TextView tv14;
    @BindView(R.id.tv15)
    TextView tv15;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tab2;
    }

    @Override
    protected void initData() {
        title_left.setText("第一销售");
        title_iv_r.setBackgroundResource(R.mipmap.icon_pzt);

    }

    @Override
    protected void setListener() {
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tv7.setOnClickListener(this);
        tv8.setOnClickListener(this);
        tv9.setOnClickListener(this);
        tv10.setOnClickListener(this);
        tv11.setOnClickListener(this);
        tv12.setOnClickListener(this);
        tv13.setOnClickListener(this);
        tv14.setOnClickListener(this);
        tv15.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                toActivity(FileCirculationActivity.class);
                break;
            case R.id.tv2:
                break;
            case R.id.tv3:
                break;
            case R.id.tv4:
                break;
            case R.id.tv5:
                break;
            case R.id.tv6:
                break;
            case R.id.tv7:
                break;
            case R.id.tv8:
                toActivity(ContractManageActivity.class);
                break;
            case R.id.tv9:
                toActivity(ContractWarningActivity.class);
                break;
            case R.id.tv10:
                toActivity(OrderActivity.class);
                break;
            case R.id.tv11:
                toActivity(OrderWarningActivity.class);
                break;
            case R.id.tv12:
                break;
            case R.id.tv13:
                break;
            case R.id.tv14:
                break;
            case R.id.tv15:
                break;
        }
    }
}
