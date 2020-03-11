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

import java.util.Date;

import androidx.annotation.Nullable;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/9 0009
 */
public class EditPayBackMoneyActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tvAcount)
    TextView tvAcount;
    @BindView(R.id.payMoney)
    EditText payMoney;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.tvOk)
    TextView tvOk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("编辑还款计划");
    }

    @Override
    protected void setListener() {
        tvAcount.setOnClickListener(this);
        tvDate.setOnClickListener(this);
        tvOk.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_pay_back_money_layout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvAcount:
                break;
            case R.id.tvDate:
                TimePickerView pvTime = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tvDate.setText(TimerUtils.FormarDateTimeStr(TimerUtils.AppTime.Year_Mouth_Day,date));
                    }
                }).build();
                pvTime.show();
                break;
            case R.id.tvOk:
                break;
        }
    }
}
