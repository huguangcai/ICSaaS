package com.ysxsoft.icsaas.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.adapter.CreateContractAdapter;
import com.ysxsoft.icsaas.common_base.adapter.headandfooter.HeaderAndFooterWrapper;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.common_base.utils.LogUtils;
import com.ysxsoft.icsaas.common_base.utils.TimerUtils;

import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create By 胡
 * on 2020/3/6 0006
 */
public class CreateContractActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tvUpload)
    TextView tvUpload;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackVisibily();
        setTitle("创建合同");

    }

    @Override
    protected void setListener() {
        tv1.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                break;
            case R.id.tv2:
                break;
            case R.id.tv3:
                break;
            case R.id.tv4:
                //时间选择器
                TimePickerView pvTime = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tv4.setText(TimerUtils.FormarDateTimeStr(TimerUtils.AppTime.Year_Mouth_Day,date));
                    }
                }).build();
                pvTime.show();
                break;
            case R.id.tvUpload:
                break;
        }
    }
}
