package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.adapter.RBaseAdapter;
import com.ysxsoft.icsaas.common_base.adapter.RViewHolder;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.common_base.utils.IntentUtils;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/5 0005
 */
public class Tab1DetialActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.title_iv_r)
    ImageView title_iv_r;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.title_content)
    TextView title_content;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tvCompanyName)
    TextView tvCompanyName;
    @BindView(R.id.tv1Name)
    TextView tv1Name;
    @BindView(R.id.tv1Phone)
    TextView tv1Phone;
    @BindView(R.id.tv2Name)
    TextView tv2Name;
    @BindView(R.id.tv2Phone)
    TextView tv2Phone;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvMark)
    TextView tvMark;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        title_iv_r.setVisibility(View.VISIBLE);
        title_iv_r.setBackgroundResource(R.mipmap.icon_complete);
        title_content.setText("代办详情");
    }

    @Override
    protected void setListener() {
        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
        title_iv_r.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            datas.add("步骤" + i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        RBaseAdapter<String> adapter = new RBaseAdapter<String>(mContext, R.layout.activity_item_tab1_detial, datas) {
            @Override
            protected void fillItem(RViewHolder holder, String item, int position) {
                TextView tvStep = holder.getView(R.id.tvStep);
                tvStep.setText(item);
                View viewLine = holder.getView(R.id.viewLine);
                if (datas.size() - 1 == position) {
                    viewLine.setVisibility(View.GONE);
                } else {
                    viewLine.setVisibility(View.VISIBLE);
                }
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
        return R.layout.activity_tab1_detial;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv1:
                IntentUtils.call(mContext, tv1Phone.getText().toString());
                break;
            case R.id.iv2:
                IntentUtils.call(mContext, tv2Phone.getText().toString());
                break;
            case R.id.title_iv_r:

                break;
        }
    }
}
