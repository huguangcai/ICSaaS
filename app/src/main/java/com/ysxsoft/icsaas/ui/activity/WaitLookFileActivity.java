package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;

import androidx.annotation.Nullable;

/**
 * Create By 胡
 * on 2020/3/11 0011
 */
public class WaitLookFileActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("待查看文件");
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_wait_look_file_layout;
    }
}
