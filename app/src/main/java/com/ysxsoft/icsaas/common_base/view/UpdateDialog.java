package com.ysxsoft.icsaas.common_base.view;

import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;


import com.ysxsoft.icsaas.R;

import androidx.annotation.NonNull;

/**
 * Create By 胡
 * on 2020/3/3 0003
 */
public class UpdateDialog extends ABSDialog {
    private Context mContext;
    private String txt="正在加载";

    public UpdateDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    public UpdateDialog(@NonNull Context context, int themeResId) {
        super(context, R.style.CenterDialogStyle);
        this.mContext = context;
    }

    @Override
    protected void initView() {
        TextView content = getViewById(R.id.content);
        content.setText(txt);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.updata_dialog;
    }

    public void setText(String text) {
        this.txt = text;
    }

    public void showDialog() {
        try {
            if (!isShowing()) {
                show();
                WindowManager.LayoutParams lp = getWindow().getAttributes();
//                lp.width = DisplayUtils.dp2px(mContext, 100);
//                lp.height = DisplayUtils.dp2px(mContext, 100);
                lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                getWindow().setAttributes(lp);
                getWindow().setGravity(Gravity.CENTER);
            } else {
                dismiss();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
