package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.adapter.CreateContractAdapter;
import com.ysxsoft.icsaas.common_base.adapter.headandfooter.HeaderAndFooterWrapper;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.common_base.utils.LogUtils;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/6 0006
 */
public class CreateContractActivity extends BaseActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("创建合同");

    }

    @Override
    protected void setListener() {

    }

    int j;

    @Override
    protected void initData() {

        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            j = i;
            datas.add(String.valueOf(i));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setNestedScrollingEnabled(false);

        CreateContractAdapter adapter = new CreateContractAdapter(R.layout.item_activity_create_contract_layout, datas);
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_activity_create_contract_footer_layout, (ViewGroup) recyclerView.getParent(), false);
        HeaderAndFooterWrapper<String> emptyViewAdapter = new HeaderAndFooterWrapper<String>(adapter);
        emptyViewAdapter.addFootView(view);
        adapter.setOnClickListener(new CreateContractAdapter.OnClickListener() {
            @Override
            public void onDelete(int postion) {
                datas.remove(postion - 1);
                emptyViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onEdit(int postion) {
                showToast("编辑");
                toActivity(ServiceProjectActivity.class);

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datas.add(String.valueOf(j++));
                CreateContractAdapter adapter = new CreateContractAdapter(R.layout.item_activity_create_contract_layout, datas);
                recyclerView.setAdapter(emptyViewAdapter);
                emptyViewAdapter.notifyDataSetChanged();
            }
        });

        recyclerView.setAdapter(emptyViewAdapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_create_contract_layout;
    }
}
