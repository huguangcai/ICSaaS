package com.ysxsoft.icsaas.ui.activity;

import android.opengl.ETC1;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/7 0007
 */
public class EditContractActivity extends BaseActivity {

    @BindView(R.id.etCompanyName)
    EditText etCompanyName;
    @BindView(R.id.et1Phone)
    EditText et1Phone;
    @BindView(R.id.etContractMoney)
    EditText etContractMoney;
    @BindView(R.id.etAcount)
    EditText etAcount;
    @BindView(R.id.et2Phone)
    EditText et2Phone;
    @BindView(R.id.etMoney)
    EditText etMoney;
    @BindView(R.id.etMark)
    EditText etMark;

    @BindView(R.id.title_tv_r)
    TextView title_tv_r;
    @BindView(R.id.tvPartyAName)
    TextView tvPartyAName;
    @BindView(R.id.tvPartyBName)
    TextView tvPartyBName;
    @BindView(R.id.tvStaffName)
    TextView tvStaffName;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.tvServiceStartDate)
    TextView tvServiceStartDate;
    @BindView(R.id.tvServiceEndDate)
    TextView tvServiceEndDate;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("编辑合同");
        title_tv_r.setText("保存");
    }

    @Override
    protected void setListener() {
        title_tv_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("保存");
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_contract_layout;
    }
}
