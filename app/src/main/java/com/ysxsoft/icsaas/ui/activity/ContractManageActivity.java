package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;
import android.view.View;
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
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.common_base.utils.SpUtils;
import com.ysxsoft.icsaas.config.Urls;
import com.ysxsoft.icsaas.ui.dialog.ContractManageDialog;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/6 0006
 */
public class ContractManageActivity extends BaseActivity implements OnRefreshLoadMoreListener, View.OnClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.title_tv_r)
    TextView title_tv_r;

    int page = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("合同管理");
    }

    @Override
    protected void setListener() {
        title_tv_r.setOnClickListener(this);
        tv1.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        RBaseAdapter<String> adapter = new RBaseAdapter<String>(mContext, R.layout.item_activity_contract_layout, list) {
            @Override
            protected void fillItem(RViewHolder holder, String item, int position) {
                TextView tvCompanyName = holder.getView(R.id.tvCompanyName);
                TextView tvMoney1 = holder.getView(R.id.tvMoney1);
                TextView tvMoney2 = holder.getView(R.id.tvMoney2);
                TextView tvManager = holder.getView(R.id.tvManager);
                TextView tvTime = holder.getView(R.id.tvTime);
//                tvCompanyName.setText("");
//                tvMoney1.setText("应收金额：");
//                tvMoney2.setText("剩余金额：");
//                tvManager.setText("客户经理：");
//                tvTime.setText("签订时间：");
            }

            @Override
            protected int getViewType(String item, int position) {
                return 0;
            }
        };
        adapter.setOnItemClickListener(new RBaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RViewHolder holder, View view, int position) {
                toActivity(ContractDetailActivity.class);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_contract_layout;
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_tv_r:
                toActivity(CreateContractActivity.class);
                break;
            case R.id.tv1:
                ContractManageDialog dialog = new ContractManageDialog(mContext);
                dialog.show();
                break;
        }
    }
}
