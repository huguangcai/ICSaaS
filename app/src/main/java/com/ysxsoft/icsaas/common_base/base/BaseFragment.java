package com.ysxsoft.icsaas.common_base.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.utils.DisplayUtils;
import com.ysxsoft.icsaas.common_base.utils.SpUtils;
import com.ysxsoft.icsaas.common_base.utils.ToastUtils;
import com.ysxsoft.icsaas.common_base.view.LoadingDialog;
import com.ysxsoft.icsaas.ui.activity.LoginActivity;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Create By 胡
 * on 2020/3/3 0003
 */
public abstract class BaseFragment extends Fragment {
    protected String TAG = this.getClass().getSimpleName();
    protected Context mContext;
    private Unbinder mUnbinder;
    protected View mRootView;
    private LoadingDialog loadingDialog;
    private boolean isShowing = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getContext();
        mRootView = LayoutInflater.from(mContext).inflate(getLayoutId(), null);
        mUnbinder = ButterKnife.bind(this, mRootView);
        initStatusBar();
        initData();
        setListener();
        return mRootView;
    }

    protected abstract int getLayoutId();


    protected abstract void initData();

    protected abstract void setListener();

    /**
     * 跳转界面
     * @param cls
     */
    public void toActivity(Class<?> cls) {
        Intent intent = new Intent(getContext(), cls);
        startActivity(intent);
    }

    /**
     * 跳转到登录
     */
    public void goToLogin() {
        SpUtils.deleteSp(mContext);
        ActivityPageManager.getInstance().removeActivity(getActivity());
        toActivity(LoginActivity.class);
    }

    public void showLoadingDialog() {
        if (isShowing) {
            return;
        }
        if (loadingDialog != null) {
        } else {
            loadingDialog = new LoadingDialog(getActivity());
            loadingDialog.setText("请稍后");
            loadingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {

                }
            });
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
            loadingDialog = new LoadingDialog(getActivity());
            loadingDialog.setText(tips == null ? "" : tips);
            loadingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {

                }
            });
        }
        loadingDialog.showDialog();
        isShowing = true;
    }

    public void hideLoadingDialog() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
        loadingDialog = null;
        isShowing = false;
    }

    public View createEmptyView() {
        return createEmptyView(R.layout.empty_view);
    }

    public View createEmptyView(String emptyText) {
        return createEmptyView(R.layout.empty_view,emptyText);
    }

    public View createEmptyView(@LayoutRes int resource) {
        return createEmptyView(resource,"");
    }


    public View createEmptyView(@LayoutRes int resource,String emptyText) {
        View view = View.inflate(getContext(), resource, null);
        TextView tv = view.findViewById(R.id.empty_view_tv);
        if (tv != null) {
            if (!TextUtils.isEmpty(emptyText)){
                tv.setText(emptyText);
            }
        }
        return view;
    }

    protected void showToast(int resId) {
        showToast(getResources().getString(resId));
    }

    public void showToast(String msg) {
        ToastUtils.shortToast(msg);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    public void initStatusBar() {
        View topView = mRootView.findViewById(R.id.topView);
        if (topView != null) {
            int barHeight = DisplayUtils.getStatusBarHeight(getActivity());
            ViewGroup.LayoutParams params = topView.getLayoutParams();
            params.height = barHeight;
            topView.setLayoutParams(params);
        }
    }

}
