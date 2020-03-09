package com.ysxsoft.icsaas.ui.fragment;

import android.view.View;
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
import com.ysxsoft.icsaas.common_base.base.BaseFragment;
import com.ysxsoft.icsaas.common_base.utils.SpUtils;
import com.ysxsoft.icsaas.config.Urls;
import com.ysxsoft.icsaas.ui.activity.OrderDetailActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/9 0009
 */
public class OrderFragment2 extends BaseFragment implements OnRefreshLoadMoreListener {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;
    int page = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tab1_tab2;
    }

    @Override
    protected void initData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        RBaseAdapter<String> adapter = new RBaseAdapter<String>(mContext, R.layout.item_fragment_order_manager_layout, list) {
            @Override
            protected void fillItem(RViewHolder holder, String item, int position) {
                TextView tv1 = holder.getView(R.id.tv1);
                TextView tv2 = holder.getView(R.id.tv2);
                TextView tvType = holder.getView(R.id.tvType);
                TextView tvCompanyName = holder.getView(R.id.tvCompanyName);
                TextView tvTime = holder.getView(R.id.tvTime);
                TextView tvManger = holder.getView(R.id.tvManger);
                TextView tvPayType = holder.getView(R.id.tvPayType);
                TextView tvState = holder.getView(R.id.tvState);
                tvState.setText("已还清");
                tvState.setTextColor(getResources().getColor(R.color.color_444343));
                tv2.setVisibility(position == 0 ? View.VISIBLE : View.INVISIBLE);

            }

            @Override
            protected int getViewType(String item, int position) {
                return 0;
            }
        };
        adapter.setOnItemClickListener(new RBaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RViewHolder holder, View view, int position) {
                toActivity(OrderDetailActivity.class);
            }
        });
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void setListener() {

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
                .params("uid", SpUtils.getSp(getActivity(), "uid"))
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
