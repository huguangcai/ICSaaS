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
 * on 2020/3/4 0004
 */
public class Tab1RightInRightOutDialog extends ABSDialog {

    private OnDialogListener onDialogListener;

    public Tab1RightInRightOutDialog(@NonNull Context context) {
        super(context, R.style.RightInRightOutDialogStyle);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = DisplayUtils.getDisplayWidth(context) * 2 / 3;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);
        getWindow().setGravity(Gravity.RIGHT);

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
        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onDialogListener != null) {
                    onDialogListener.onClick();
                }
            }
        });

        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            datas.add("公司注册" + i);
        }
        TagFlowLayout flowLayout1 = getViewById(R.id.flowLayout1);
        TagFlowLayout flowLayout2 = getViewById(R.id.flowLayout2);
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

        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            data.add("普通" + i);
        }
        flowLayout2.setAdapter(new TagAdapter<String>(data) {
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

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.dialog_tab1_riro;
    }
}
