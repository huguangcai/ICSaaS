package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.common_base.utils.TimerUtils;
import com.ysxsoft.icsaas.common_base.widget.switchbutton.SwitchButton;
import com.ysxsoft.icsaas.ui.dialog.SelectPayDialog;

import java.util.Date;

import androidx.annotation.Nullable;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/5 0005
 */
public class SupplementaryContractActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_content)
    TextView title_content;
    @BindView(R.id.title_tv_r)
    TextView title_tv_r;
    @BindView(R.id.etCompanyName)
    EditText etCompanyName;
    @BindView(R.id.etManagerName)
    EditText etManagerName;
    @BindView(R.id.etMoney)
    EditText etMoney;
    @BindView(R.id.etOffLineMoney)
    EditText etOffLineMoney;
    @BindView(R.id.etMark)
    EditText etMark;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.tv6)
    TextView tv6;
    @BindView(R.id.radio_group)
    RadioGroup radio_group;
    @BindView(R.id.switchButton)
    SwitchButton switchButton;
    @BindView(R.id.tvUpload)
    TextView tvUpload;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("补录合同");

        for (int i = 0; i < radio_group.getChildCount(); i++) {
            int finalI = i;
            radio_group.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showToast("点击了==" + finalI);
                }
            });
        }
    }

    @Override
    protected void setListener() {
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tvUpload.setOnClickListener(this);
        title_tv_r.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_supplementary_contract_layout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_tv_r:
                showToast("提价");
                break;
            case R.id.tv1:
                //时间选择器
                TimePickerView pvTime = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tv1.setText(TimerUtils.FormarDateTimeStr(TimerUtils.AppTime.Year_Mouth_Day,date));
                    }
                }).build();
                pvTime.show();
                break;
            case R.id.tv2:
                TimePickerView pvTime1 = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tv2.setText(TimerUtils.FormarDateTimeStr(TimerUtils.AppTime.Year_Mouth_Day,date));
                    }
                }).build();
                pvTime1.show();
                break;
            case R.id.tv3:
                TimePickerView pvTime2 = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tv3.setText(TimerUtils.FormarDateTimeStr(TimerUtils.AppTime.Year_Mouth_Day,date));
                    }
                }).build();
                pvTime2.show();
                break;
            case R.id.tv5:
                SelectPayDialog payDialog = new SelectPayDialog(mContext);
                payDialog.setPosiont(2);
                payDialog.show();
                break;
            case R.id.tv6:
                break;
            case R.id.tvUpload:
                break;
        }
    }
}
