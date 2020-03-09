package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.adapter.RBaseAdapter;
import com.ysxsoft.icsaas.common_base.adapter.RViewHolder;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/7 0007
 */
public class ContractDetailActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_tv_r)
    TextView title_tv_r;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.recyclerView1)
    RecyclerView recyclerView1;

    @BindView(R.id.tvCompanyName)
    TextView tvCompanyName;
    @BindView(R.id.tvPartyAName)
    TextView tvPartyAName;
    @BindView(R.id.tv1Phone)
    TextView tv1Phone;
    @BindView(R.id.tv2Phone)
    TextView tv2Phone;
    @BindView(R.id.tvContractMoney)
    TextView tvContractMoney;
    @BindView(R.id.tvAcount)
    TextView tvAcount;
    @BindView(R.id.tvPartyBName)
    TextView tvPartyBName;
    @BindView(R.id.tvMoney)
    TextView tvMoney;
    @BindView(R.id.tvStaffName)
    TextView tvStaffName;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.tvServiceStartDate)
    TextView tvServiceStartDate;
    @BindView(R.id.tvServiceEndDate)
    TextView tvServiceEndDate;
    @BindView(R.id.tvMark)
    TextView tvMark;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("合同详情");
    }

    @Override
    protected void setListener() {
        title_tv_r.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            datas.add(String.valueOf(i));
        }
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        recyclerView.setNestedScrollingEnabled(false);
        RBaseAdapter<String> adapter = new RBaseAdapter<String>(mContext, R.layout.item1_activity_contract_detail_layout, datas) {
            @Override
            protected void fillItem(RViewHolder holder, String item, int position) {
                ImageView iv = holder.getView(R.id.iv);

            }

            @Override
            protected int getViewType(String item, int position) {
                return 0;
            }
        };
        recyclerView.setAdapter(adapter);

        recyclerView1.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView1.setNestedScrollingEnabled(false);
        RBaseAdapter<String> adapter1 = new RBaseAdapter<String>(mContext, R.layout.item2_activity_contract_detail_layout, datas) {
            @Override
            protected void fillItem(RViewHolder holder, String item, int position) {
                TextView tv1 = holder.getView(R.id.tv1);
                TextView tv2 = holder.getView(R.id.tv2);
                TextView tvStaffName = holder.getView(R.id.tvStaffName);
                TextView tvContractMoney = holder.getView(R.id.tvContractMoney);
                TextView tvDate = holder.getView(R.id.tvDate);
                TextView tvDetail = holder.getView(R.id.tvDetail);
//                tv1.setText("业务名称：");
//                tv2.setText("");
//                tvStaffName.setText("办事员：");
//                tvContractMoney.setText("合同金额：");
//                tvDate.setText("");
                tvDetail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toActivity(ServiceProjectActivity.class);
                    }
                });
            }

            @Override
            protected int getViewType(String item, int position) {
                return 0;
            }
        };
        recyclerView1.setAdapter(adapter1);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_contract_detail_layout;
    }

    @Override
    public void onClick(View v) {
        title_tv_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(EditContractActivity.class);
            }
        });
    }
}
