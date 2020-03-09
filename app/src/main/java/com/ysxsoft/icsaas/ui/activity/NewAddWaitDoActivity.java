package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;

import javax.xml.transform.Templates;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/5 0005
 */
public class NewAddWaitDoActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.title_content)
    TextView title_content;

    @BindView(R.id.tvArea)
    TextView tvArea;
    @BindView(R.id.tvWorkName)
    TextView tvWorkName;
    @BindView(R.id.tvCompany)
    TextView tvCompany;
    @BindView(R.id.tvBussiness)
    TextView tvBussiness;
    @BindView(R.id.radio_group)
    RadioGroup radio_group;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.etContent)
    EditText etContent;
    @BindView(R.id.tvOk)
    TextView tvOk;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        title_content.setText("新增代办");
        for (int i = 0; i < radio_group.getChildCount(); i++) {
            final int finalI = i;
            radio_group.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                showToast("点击了=="+finalI);
                }
            });
        }
    }

    @Override
    protected void setListener() {
        tvArea.setOnClickListener(this);
        tvWorkName.setOnClickListener(this);
        tvCompany.setOnClickListener(this);
        tvBussiness.setOnClickListener(this);
        tvOk.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_new_add_wait_do;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvArea:
                break;
            case R.id.tvWorkName:
                break;
            case R.id.tvBussiness:
                break;
            case R.id.tvOk:
                break;
        }
    }
}
