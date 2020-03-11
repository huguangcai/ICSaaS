package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.common_base.utils.TimerUtils;
import com.ysxsoft.icsaas.common_base.widget.switchbutton.SwitchButton;

import java.util.Date;

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
        switch (v.getId()) {
            case R.id.tvServiceStartDate:
                //时间选择器
                TimePickerView pvTime = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tvServiceStartDate.setText(TimerUtils.FormarDateTimeStr(TimerUtils.AppTime.Year_Mouth_Day,date));
                    }
                }).build();
                pvTime.show();
                break;
            case R.id.tvServiceEndDate:
                TimePickerView pvTime1 = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tvServiceEndDate.setText(TimerUtils.FormarDateTimeStr(TimerUtils.AppTime.Year_Mouth_Day,date));
                    }
                }).build();
                pvTime1.show();
                break;
            case R.id.tvOk:
                break;
        }
    }
}
