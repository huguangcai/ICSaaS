package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;

import androidx.annotation.Nullable;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/10 0010
 */
public class ApplyDetialActivity extends BaseActivity {
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tvMark)
    TextView tvMark;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("申请详情");
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_apply_detial_layout;
    }
}
