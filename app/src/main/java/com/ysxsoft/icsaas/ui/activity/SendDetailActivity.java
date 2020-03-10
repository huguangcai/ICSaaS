package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.adapter.RBaseAdapter;
import com.ysxsoft.icsaas.common_base.adapter.RViewHolder;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/10 0010
 */
public class SendDetailActivity extends BaseActivity {

    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tvOrderNum)
    TextView tvOrderNum;
     @BindView(R.id.tvMark)
    TextView tvMark;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("邮寄详情");
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
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_send_detial_layout;
    }
}
