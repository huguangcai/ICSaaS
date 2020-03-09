package com.ysxsoft.icsaas.common_base.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import com.ysxsoft.icsaas.common_base.utils.ToastUtils;

import androidx.annotation.NonNull;

/**
 * Create By 胡
 * on 2020/3/2 0002
 */
public abstract class ABSDialog extends Dialog {
    public Context mContext;

    public ABSDialog(@NonNull Context context){
        super(context, 0);
        mContext=context;
    }


    public ABSDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        setContentView(getLayoutResId());
        initView();
    }


    /**
     * 弹出Toast信息
     */
    public void showToast(String msg) {
        ToastUtils.shortToast(msg);
    }

    protected void showToast(int resId) {
        showToast(getContext().getResources().getString(resId));
    }

    /**
     * 根据Id获取View
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T getViewById(int id) {
        return (T) findViewById(id);
    }

    protected abstract void initView();

    protected abstract int getLayoutResId();
}
