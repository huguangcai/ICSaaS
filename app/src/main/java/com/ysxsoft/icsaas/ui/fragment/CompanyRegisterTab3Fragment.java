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
import com.ysxsoft.icsaas.ui.activity.SupplementaryContractActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/5 0005
 */
public class CompanyRegisterTab3Fragment extends BaseFragment implements OnRefreshLoadMoreListener {
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

        RBaseAdapter<String> adapter = new RBaseAdapter<String>(getActivity(), R.layout.activit_company_register_item, list) {
            @Override
            protected void fillItem(RViewHolder holder, String item, int position) {
                TextView tv1 = holder.getView(R.id.tv1);
                TextView tv2 = holder.getView(R.id.tv2);
                TextView tvName = holder.getView(R.id.tvName);
                TextView tvCompanyName = holder.getView(R.id.tvCompanyName);
                TextView tvTime = holder.getView(R.id.tvTime);
                TextView tvNamePhone = holder.getView(R.id.tvNamePhone);
                if (position <= 1) {
                    tv2.setVisibility(View.VISIBLE);
                    tvCompanyName.setVisibility(View.INVISIBLE);
                } else {
                    tv2.setVisibility(View.INVISIBLE);
                    tvCompanyName.setVisibility(View.VISIBLE);
                }
            }
            @Override
            protected int getViewType(String item, int position) {
                return 0;
            }
        };
        adapter.setOnItemClickListener(new RBaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RViewHolder holder, View view, int position) {
                toActivity(SupplementaryContractActivity.class);
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
