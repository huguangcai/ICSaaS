package com.ysxsoft.icsaas.common_base.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.utils.DisplayUtils;
import com.ysxsoft.icsaas.common_base.utils.SpUtils;
import com.ysxsoft.icsaas.common_base.utils.StatusBarUtil;
import com.ysxsoft.icsaas.common_base.utils.ToastUtils;
import com.ysxsoft.icsaas.common_base.view.LoadingDialog;
import com.ysxsoft.icsaas.ui.activity.LoginActivity;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Create By 胡
 * on 2020/3/3 0003
 */
public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext;
    private Unbinder mUnbinder;
    private LoadingDialog loadingDialog;
    private boolean isShowing = false;
    protected View mRootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        DisplayUtils.setCustomDensity(this, getApplication());
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        StatusBarUtil.setTranslucentStatus(this, true);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        mRootView = View.inflate(this, getLayoutId(), null);
        ActivityPageManager.getInstance().addActivity(this);
        //设置状态栏透明
        View view = findViewById(R.id.topView);
        if (view != null) {
            view.setLayoutParams(new LinearLayout.LayoutParams(DisplayUtils.getDisplayWidth(this), DisplayUtils.getStatusBarHeight(this)));
        }
        initData();
        setListener();
    }

    /**
     * 显示并关闭界面
     */
    public void setBackVisibily() {
        View img_back = findViewById(R.id.img_back);
        img_back.setVisibility(View.VISIBLE);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title){
        TextView tv_title = findViewById(R.id.title_content);
        tv_title.setText(title);
    }

    protected abstract void setListener();

    protected abstract void initData();

    public abstract int getLayoutId();

    /**
     * 弹出Toast信息
     */
    public void showToast(String msg) {
        ToastUtils.shortToast(msg);
    }

    protected void showToast(int resId) {
        showToast(getResources().getString(resId));
    }

    public View createEmptyView() {
        return createEmptyView(R.layout.empty_view);
    }

    public View createEmptyView(String emptyText) {
        return createEmptyView(R.layout.empty_view, emptyText);
    }

    public View createEmptyView(@LayoutRes int resource) {
        return createEmptyView(resource, "");
    }

    public View createEmptyView(@LayoutRes int resource, String emptyText) {
        View view = View.inflate(this, resource, null);
        TextView tv = view.findViewById(R.id.empty_view_tv);
        if (tv != null) {
            if (!TextUtils.isEmpty(emptyText)) {
                tv.setText(emptyText);
            }
        }
        return view;
    }

    /**
     * 显示dialog
     */
    public void showLoadingDialog() {
        if (isShowing) {
            return;
        }
        if (loadingDialog != null) {
        } else {
            loadingDialog = new LoadingDialog(mContext);
            loadingDialog.setText("正在加载...");
        }
        loadingDialog.showDialog();
        isShowing = true;
    }

    public void showLoadingDialog(String tips) {
        if (isShowing) {
            return;
        }
        if (loadingDialog != null) {
            loadingDialog.setText(tips == null ? "" : tips);
        } else {
            loadingDialog = new LoadingDialog(this);
            loadingDialog.setText(tips == null ? "" : tips);
        }
        loadingDialog.showDialog();
        isShowing = true;
    }

    /**
     * 隐藏dialog
     */
    public void hideLoadingDialog() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
        loadingDialog = null;
        isShowing = false;
    }

    public void toActivity(Class<?> cls) {
        Intent intent = new Intent(mContext, cls);
        startActivity(intent);
    }

    public void goToLogin() {
        SpUtils.deleteSp(mContext);
        ActivityPageManager.getInstance().removeActivity(this);
        toActivity(LoginActivity.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        ActivityPageManager.getInstance().removeActivity(this);
    }
}
