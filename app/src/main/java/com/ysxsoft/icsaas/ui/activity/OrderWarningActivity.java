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
import com.ysxsoft.icsaas.ui.dialog.OrderWarningDialog;

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
public class OrderWarningActivity extends BaseActivity implements OnRefreshLoadMoreListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;
    int page = 1;
    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.tv1)
    TextView tv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("订单预警");
    }

    @Override
    protected void setListener() {
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderWarningDialog dialog = new OrderWarningDialog(mContext);
                dialog.show();
            }
        });
    }

    @Override
    protected void initData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        RBaseAdapter<String> adapter = new RBaseAdapter<String>(mContext, R.layout.item_activity_order_warning_layout, list) {
            @Override
            protected void fillItem(RViewHolder holder, String item, int position) {
                TextView tvCompanyName = holder.getView(R.id.tvCompanyName);
                TextView tv1 = holder.getView(R.id.tv1);
                TextView tv2 = holder.getView(R.id.tv2);
                TextView tvContractType = holder.getView(R.id.tvContractType);
                TextView tvName = holder.getView(R.id.tvName);
                TextView tvManagerName = holder.getView(R.id.tvManagerName);
                TextView tvContractMoney = holder.getView(R.id.tvContractMoney);
                TextView tvPaybackMoney = holder.getView(R.id.tvPaybackMoney);
                TextView tvSignDate = holder.getView(R.id.tvSignDate);
                TextView tvSignEndDate = holder.getView(R.id.tvSignEndDate);

//                tvName.setText("客户姓名：");
//                tvManagerName.setText("客户经理：");
//                tvContractMoney.setText("合同金额：");
//                tvPaybackMoney.setText("收款金额：");
//                tvSignDate.setText("签订时间：");
//                tvSignEndDate.setText("到期时间：");
            }

            @Override
            protected int getViewType(String item, int position) {
                return 0;
            }
        };
        recyclerView.setAdapter(adapter);

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
    public int getLayoutId() {
        return R.layout.activity_order_warning_layout;
    }
}
