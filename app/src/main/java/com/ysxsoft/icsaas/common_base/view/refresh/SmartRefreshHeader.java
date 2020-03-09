package com.ysxsoft.icsaas.common_base.view.refresh;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.ysxsoft.icsaas.R;

import androidx.annotation.NonNull;

/**
 * Create By 胡
 * on 2020/3/3 0003
 */
public class SmartRefreshHeader extends LinearLayout implements RefreshHeader {
    public SmartRefreshHeader(Context context) {
        super(context);
        View view = View.inflate(context, R.layout.refresh_header, this);
        ImageView loading = view.findViewById(R.id.loading);
        AnimationDrawable animationDrawable = (AnimationDrawable) loading.getDrawable();
        animationDrawable.start();
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {

    }

    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {

    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }

    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        return 0;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {

    }
}
