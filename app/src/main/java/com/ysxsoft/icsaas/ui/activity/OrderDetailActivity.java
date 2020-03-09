package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.adapter.RBaseAdapter;
import com.ysxsoft.icsaas.common_base.adapter.RViewHolder;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/9 0009
 */
public class OrderDetailActivity extends BaseActivity {

    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.tv6)
    TextView tv6;
    @BindView(R.id.tv7)
    TextView tv7;
    @BindView(R.id.tv8)
    TextView tv8;
    @BindView(R.id.tv9)
    TextView tv9;
    @BindView(R.id.tv10)
    TextView tv10;
    @BindView(R.id.tv11)
    TextView tv11;
    @BindView(R.id.tv12)
    TextView tv12;
    @BindView(R.id.tv13)
    TextView tv13;
    @BindView(R.id.tv14)
    TextView tv14;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("订单详情");
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            datas.add(String.valueOf(i));
        }
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        RBaseAdapter<String> adapter = new RBaseAdapter<String>(mContext, R.layout.item_activity_order_detail_layout, datas) {
            @Override
            protected void fillItem(RViewHolder holder, String item, int position) {
                TextView tv1 = holder.getView(R.id.tv1);
                TextView tv2 = holder.getView(R.id.tv2);
                TextView tvAdd = holder.getView(R.id.tvAdd);
                TextView tv3 = holder.getView(R.id.tv3);
                TextView tvDate = holder.getView(R.id.tvDate);
                TextView tvMoney = holder.getView(R.id.tvMoney);
                TextView tvWaitMoney = holder.getView(R.id.tvWaitMoney);
                TextView tvMoney1 = holder.getView(R.id.tvMoney1);
                TextView tvEdit = holder.getView(R.id.tvEdit);

                if (position % 2 == 0) {
                    tv2.setText("(已还清)");
                    tvAdd.setVisibility(View.GONE);
                } else {
                    tv2.setText("(已逾期)");
                    tvWaitMoney.setTextColor(getResources().getColor(R.color.color_c31a1a));
                    tvMoney1.setTextColor(getResources().getColor(R.color.color_c31a1a));
                    tvAdd.setVisibility(View.VISIBLE);
                }

//                tv3.setText("还款期数：");
//                tvDate.setText("还款日期：");
//                tvMoney.setText("应付金额(元)：");
//                tvWaitMoney.setText("待付金额(元)：");
//                tvMoney1.setText("滞纳金(元)：");
                tvEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toActivity(EditPayBackMoneyActivity.class);
                    }
                });
            }

            @Override
            protected int getViewType(String item, int position) {
                return 0;
            }
        };
        recyclerView.setAdapter(adapter);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_detail_layout;
    }
}
