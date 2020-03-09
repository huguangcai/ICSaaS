package com.ysxsoft.icsaas.ui.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.utils.DisplayUtils;
import com.ysxsoft.icsaas.common_base.view.ABSDialog;
import com.ysxsoft.icsaas.common_base.widget.flowlayout.FlowLayout;
import com.ysxsoft.icsaas.common_base.widget.flowlayout.TagAdapter;
import com.ysxsoft.icsaas.common_base.widget.flowlayout.TagFlowLayout;

import java.util.ArrayList;

import androidx.annotation.NonNull;

/**
 * Create By 胡
 * on 2020/3/9 0009
 */
public class ContractWarningDialog extends ABSDialog {

    private Context context;

    public ContractWarningDialog(@NonNull Context context) {
        super(context, R.style.RightInRightOutDialogStyle);
        this.context = context;
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = DisplayUtils.getDisplayWidth(context) * 2 / 3;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);
        getWindow().setGravity(Gravity.RIGHT);
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
        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            datas.add("合同管理" + i);
        }
        TagFlowLayout flowLayout1 = getViewById(R.id.flowLayout1);
        flowLayout1.setAdapter(new TagAdapter<String>(datas) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.flow_item_layout, flowLayout1, false);
                TextView tv = view.findViewById(R.id.tv_flow);
                tv.setText(o);
                return view;
            }
        });
        flowLayout1.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                return true;
            }
        });
        TextView tvSignStartDate = getViewById(R.id.tvSignStartDate);
        TextView tvSignEndDate = getViewById(R.id.tvSignEndDate);
        TextView tvDQStarTime = getViewById(R.id.tvDQStarTime);
        TextView tvDQEndTime = getViewById(R.id.tvDQEndTime);
        TextView tv1Type = getViewById(R.id.tv1Type);
        TextView tv2Type = getViewById(R.id.tv2Type);
        TextView tv3Money = getViewById(R.id.tv3Money);
        TextView tv4Money = getViewById(R.id.tv4Money);


        TextView tvManager = getViewById(R.id.tvManager);
        TextView tvWorker = getViewById(R.id.tvWorker);
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
        return R.layout.dialog_contract_warning_layout;
    }
}
