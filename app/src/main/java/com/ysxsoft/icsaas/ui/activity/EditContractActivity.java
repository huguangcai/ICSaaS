package com.ysxsoft.icsaas.ui.activity;

import android.opengl.ETC1;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.ysxsoft.icsaas.MainActivity;
import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.common_base.utils.TimerUtils;

import java.sql.Time;
import java.util.Date;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/7 0007
 */
public class EditContractActivity extends BaseActivity implements View.OnClickListener {

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
        tvDate.setOnClickListener(this);
        title_tv_r.setOnClickListener(this);
        tvServiceStartDate.setOnClickListener(this);
        tvServiceEndDate.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_contract_layout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvDate:
                //时间选择器
                TimePickerView pvTime = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tvDate.setText(TimerUtils.FormarDateTimeStr(TimerUtils.AppTime.Year_Mouth_Day,date));
                    }
                }).build();
                pvTime.show();
                break;
            case R.id.tvServiceStartDate:
                TimePickerView pvTime1 = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tvServiceStartDate.setText(TimerUtils.FormarDateTimeStr(TimerUtils.AppTime.Year_Mouth_Day,date));
                    }
                }).build();
                pvTime1.show();
                break;
            case R.id.tvServiceEndDate:
                TimePickerView pvTime2 = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tvServiceEndDate.setText(TimerUtils.FormarDateTimeStr(TimerUtils.AppTime.Year_Mouth_Day,date));
                    }
                }).build();
                pvTime2.show();
                break;
            case R.id.title_tv_r:
                showToast("保存");
                break;
        }
    }
}
