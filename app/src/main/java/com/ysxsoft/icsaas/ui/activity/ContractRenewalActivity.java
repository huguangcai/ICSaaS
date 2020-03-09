package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.common_base.widget.switchbutton.SwitchButton;

import androidx.annotation.Nullable;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/7 0007
 */
public class ContractRenewalActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.etRenewalMoney)
    EditText etRenewalMoney;
    @BindView(R.id.etContent)
    EditText etContent;
    @BindView(R.id.switchButton)
    SwitchButton switchButton;
    @BindView(R.id.tvServiceStartDate)
    TextView tvServiceStartDate;
    @BindView(R.id.tvServiceEndDate)
    TextView tvServiceEndDate;
    @BindView(R.id.tvOk)
    TextView tvOk;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("合同续期");
    }

    @Override
    protected void setListener() {
        tvOk.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_contract_renewal_layout;
    }

    @Override
    public void onClick(View v) {
        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
