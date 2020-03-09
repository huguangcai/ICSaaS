package com.ysxsoft.icsaas.ui.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.adapter.RBaseAdapter;
import com.ysxsoft.icsaas.common_base.adapter.RViewHolder;
import com.ysxsoft.icsaas.common_base.utils.DisplayUtils;
import com.ysxsoft.icsaas.common_base.utils.SpUtils;
import com.ysxsoft.icsaas.common_base.view.ABSDialog;
import com.ysxsoft.icsaas.config.Urls;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/9 0009
 */
public class ContractManageManagerDialog extends ABSDialog implements OnRefreshLoadMoreListener {
    int page = 1;
    private SmartRefreshLayout smartRefresh;
    private Context context;
    private int type;

    public ContractManageManagerDialog(@NonNull Context context) {
        super(context, R.style.NormalDialogStyle);
        this.context = context;
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.softInputMode=params.SOFT_INPUT_ADJUST_PAN|params.SOFT_INPUT_STATE_HIDDEN;
        params.width = DisplayUtils.getDisplayWidth(context) * 2 / 3;
        params.height = DisplayUtils.getDisplayHeight(context) * 1 / 2;
        getWindow().setAttributes(params);
        getWindow().setGravity(Gravity.BOTTOM | Gravity.RIGHT);
    }

    @Override
    protected void initView() {
        RecyclerView recyclerView = getViewById(R.id.recyclerView);
        smartRefresh = getViewById(R.id.smartRefresh);
        EditText et1 = getViewById(R.id.et1);
        TextView tvTitleType = getViewById(R.id.tvType);
        TextView tvCancle = getViewById(R.id.tvCancle);
        tvTitleType.setText("客户经理");

        tvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            datas.add(String.valueOf(i));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        RBaseAdapter<String> adapter = new RBaseAdapter<String>(getContext(), R.layout.item_dialog_dialog_contract_manage_manager, datas) {
            @Override
            protected void fillItem(RViewHolder holder, String item, int position) {
                TextView tvName = holder.getView(R.id.tvName);
            }

            @Override
            protected int getViewType(String item, int position) {
                return 0;
            }
        };
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.dialog_dialog_contract_manage_manager;
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        getList();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        getList();
    }

    private void getList() {
        OkGo.<String>get(Urls.BASE_URL).
                tag(this)
                .params("uid", SpUtils.getSp(mContext, "uid"))
                .params("type", "1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (smartRefresh != null) {
                            smartRefresh.finishLoadMore();
                            smartRefresh.finishRefresh();
                        }
                    }
                });
    }


}
