package com.ysxsoft.icsaas.ui.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.adapter.RBaseAdapter;
import com.ysxsoft.icsaas.common_base.adapter.RViewHolder;
import com.ysxsoft.icsaas.common_base.utils.DisplayUtils;
import com.ysxsoft.icsaas.common_base.view.ABSDialog;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Create By 胡
 * on 2020/3/5 0005
 */
public class SelectPayDialog extends ABSDialog {

    private int ClickPostion;

    public SelectPayDialog(@NonNull Context context) {
        super(context, R.style.NormalDialogStyle);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width=WindowManager.LayoutParams.MATCH_PARENT;
        params.height= DisplayUtils.getDisplayHeight(getContext())*1/2;
        getWindow().setAttributes(params);
        getWindow().setGravity(Gravity.BOTTOM);
    }

    public SelectPayDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void initView() {
        ArrayList<String> datas = new ArrayList<>();
        datas.add("一次性付清");
        datas.add("月付");
        datas.add("季付");
        datas.add("半年付");
        datas.add("年付");
        TextView tvCancle = getViewById(R.id.tvCancle);
        RecyclerView recyclerView = getViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RBaseAdapter<String> adapter=new RBaseAdapter<String>(getContext(),R.layout.dialog_item_select_pay,datas) {
            @Override
            protected void fillItem(RViewHolder holder, String item, int position) {
                TextView tvContent = holder.getView(R.id.tvContent);
                CheckBox cb = holder.getView(R.id.cb);
                tvContent.setText(item);
                if (ClickPostion==position){
                    cb.setChecked(true);
                }else {
                    cb.setChecked(false);
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
                ClickPostion=position;
                adapter.notifyDataSetChanged();
            }
        });

        recyclerView.setAdapter(adapter);

        tvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.dialog_select_pay;
    }

    public void setPosiont(int i) {
        ClickPostion=i;
    }
}
