package com.ysxsoft.icsaas.ui.activity;


import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.common_base.widget.switchbutton.SwitchButton;

import androidx.annotation.Nullable;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/6 0006
 */
public class ServiceProjectActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_tv_r)
    TextView title_tv_r;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.radio_group)
    RadioGroup radio_group;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.etMoney)
    EditText etMoney;
    @BindView(R.id.etOffLineMoney)
    EditText etOffLineMoney;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.tv6)
    TextView tv6;
    @BindView(R.id.tvOk)
    TextView tvOk;
    @BindView(R.id.tvIsAuto)
    TextView tvIsAuto;
    @BindView(R.id.switchButton)
    SwitchButton switchButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("服务项目");
    }

    @Override
    protected void setListener() {
        title_tv_r.setOnClickListener(this);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tvOk.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_service_project_layout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_tv_r:
                tvOk.setVisibility(View.GONE);
                showToast("编辑");
                break;
            case R.id.tv1:
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
            case R.id.tvOk:
                break;
        }
    }
}
