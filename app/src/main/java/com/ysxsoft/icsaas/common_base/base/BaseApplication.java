package com.ysxsoft.icsaas.common_base.base;

import android.app.Application;
import android.content.Context;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.utils.ToastUtils;
import com.ysxsoft.icsaas.common_base.view.refresh.SmartRefreshHeader;

import androidx.multidex.MultiDex;

/**
 * Create By 胡
 * on 2020/3/3 0003
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.init(this);
    }

    static {//static 代码段可以防止内存泄露
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.themeColor, android.R.color.transparent);//全局设置主题颜色
                return new SmartRefreshHeader(context);
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
//                return new ClassicsFooter(context).setDrawableSize(20);
                return new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Translate);
            }
        });

    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
