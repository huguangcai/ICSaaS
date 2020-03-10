package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.ui.dialog.DoPeopleDialog;
import com.ysxsoft.icsaas.ui.dialog.SelectAddressDialog;
import com.ysxsoft.icsaas.ui.dialog.SelectMaterialDialog;

import androidx.annotation.Nullable;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/10 0010
 */
public class FileApplyActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.etTitle)
    EditText etTitle;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.etMark)
    EditText etMark;
    @BindView(R.id.tvOk)
    TextView tvOk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("文件流转--申请");

    }

    @Override
    protected void setListener() {
        tv1.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tvOk.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_file_apply_layout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                DoPeopleDialog dialog = new DoPeopleDialog(mContext);
                dialog.show();
                break;
            case R.id.tv3:
                SelectMaterialDialog materialDialog = new SelectMaterialDialog(mContext);
                materialDialog.show();
                break;
            case R.id.tv4:
                SelectAddressDialog addressDialog = new SelectAddressDialog(mContext);
                addressDialog.show();
                break;
            case R.id.tvOk:
                break;
        }
    }
}
