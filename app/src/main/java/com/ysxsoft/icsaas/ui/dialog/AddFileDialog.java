package com.ysxsoft.icsaas.ui.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.utils.DisplayUtils;
import com.ysxsoft.icsaas.common_base.view.ABSDialog;

import androidx.annotation.NonNull;

/**
 * Create By 胡
 * on 2020/3/10 0010
 */
public class AddFileDialog extends ABSDialog {

    private OnDialogListener onDialogListener;

    public AddFileDialog(@NonNull Context context) {
        super(context, R.style.NormalDialogStyle);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width=WindowManager.LayoutParams.MATCH_PARENT;
        params.height= WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
        getWindow().setGravity(Gravity.BOTTOM);
    }

    @Override
    protected void initView() {
        TextView tv1 = getViewById(R.id.tv1);
        TextView tv2 = getViewById(R.id.tv2);
        TextView tvCancle = getViewById(R.id.tvCancle);
        tvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (onDialogListener != null) {
                    onDialogListener.apply();
                }
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (onDialogListener != null) {
                    onDialogListener.send();
                }
            }
        });
    }


    public interface OnDialogListener {
        void apply();

        void send();
    }

    public void setOnDialogListener(OnDialogListener onDialogListener) {

        this.onDialogListener = onDialogListener;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.dialog_add_file_layout;
    }
}
