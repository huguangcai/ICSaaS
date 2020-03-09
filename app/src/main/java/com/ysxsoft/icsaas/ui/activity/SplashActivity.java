package com.ysxsoft.icsaas.ui.activity;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.ysxsoft.icsaas.MainActivity;
import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.common_base.utils.SpUtils;

/**
 * Create By 胡
 * on 2020/3/4 0004
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(SpUtils.getSp(mContext,"uid"))) {
                    //未登录 跳转到登录页面
//                    toActivity(LoginActivity.class);
                    toActivity(MainActivity.class);
                } else {
                    //已登录 跳转到主页
                    toActivity(MainActivity.class);
                }
                finish();
            }
        }, 3000);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }
}
