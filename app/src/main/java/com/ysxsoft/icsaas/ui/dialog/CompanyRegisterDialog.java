package com.ysxsoft.icsaas.ui.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.utils.DisplayUtils;
import com.ysxsoft.icsaas.common_base.utils.TimerUtils;
import com.ysxsoft.icsaas.common_base.view.ABSDialog;
import com.ysxsoft.icsaas.common_base.widget.flowlayout.FlowLayout;
import com.ysxsoft.icsaas.common_base.widget.flowlayout.TagAdapter;
import com.ysxsoft.icsaas.common_base.widget.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;

/**
 * Create By 胡
 * on 2020/3/5 0005
 */
public class CompanyRegisterDialog extends ABSDialog {

    private OnDialogListener onDialogListener;
    private Context context;

    public CompanyRegisterDialog(@NonNull Context context) {
        super(context, R.style.RightInRightOutDialogStyle);
        this.context = context;
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = DisplayUtils.getDisplayWidth(context) * 2 / 3;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);
        getWindow().setGravity(Gravity.RIGHT);
    }

    public CompanyRegisterDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }
    public void setOnClickDialogListener(OnDialogListener onDialogListener) {
        this.onDialogListener = onDialogListener;
    }

    interface OnDialogListener {
        void onDismiss();
        void onClick();
    }
    @Override
    protected void initView() {
        getViewById(R.id.tvRepeat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        TextView tvOk = getViewById(R.id.tvOk);
        ArrayList<String> datas = new ArrayList<>();
        datas.add("普通");
        datas.add("紧急");
        datas.add("全部");
        TagFlowLayout flowLayout2 = getViewById(R.id.flowLayout2);
        flowLayout2.setAdapter(new TagAdapter<String>(datas) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.flow_item_layout, flowLayout2, false);
                TextView tv = view.findViewById(R.id.tv_flow);
                tv.setText(o);
                return view;
            }
        });
        flowLayout2.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                return true;
            }
        });
        TextView tvArea = getViewById(R.id.tvArea);
        TextView tvManager = getViewById(R.id.tvManager);
        TextView tvWorker = getViewById(R.id.tvWorker);
        TextView tvStarTime = getViewById(R.id.tvStarTime);
        TextView tvEndTime = getViewById(R.id.tvEndTime);

        tvStarTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeSelectPickerView pickerView = new TimeSelectPickerView();
                pickerView.init(context);
                pickerView.show(new TimeSelectPickerView.OnSelectedListener() {
                    @Override
                    public void onSelected(Date date) {
                        String timeStr = TimerUtils.FormarDateTimeStr(TimerUtils.AppTime.Year_Mouth_Day, date);
                        tvStarTime.setText(timeStr);
                    }
                });
            }
        });
        tvEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeSelectPickerView pickerView = new TimeSelectPickerView();
                pickerView.init(context);
                pickerView.show(new TimeSelectPickerView.OnSelectedListener() {
                    @Override
                    public void onSelected(Date date) {
                        String timeStr = TimerUtils.FormarDateTimeStr(TimerUtils.AppTime.Year_Mouth_Day, date);
                        tvEndTime.setText(timeStr);
                    }
                });
            }
        });

        tvManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContractManageManagerDialog dialog = new ContractManageManagerDialog(context);
                dialog.show();
            }
        });
        tvWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContractManageWorkerDialog dialog = new ContractManageWorkerDialog(context);
                dialog.show();
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.dialog_company_register;
    }
}
