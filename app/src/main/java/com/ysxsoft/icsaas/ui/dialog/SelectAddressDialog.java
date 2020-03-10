package com.ysxsoft.icsaas.ui.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.adapter.RBaseAdapter;
import com.ysxsoft.icsaas.common_base.adapter.RViewHolder;
import com.ysxsoft.icsaas.common_base.utils.DisplayUtils;
import com.ysxsoft.icsaas.common_base.view.ABSDialog;
import com.ysxsoft.icsaas.common_base.view.OnClickDialogListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Create By 胡
 * on 2020/3/10 0010
 */
public class SelectAddressDialog extends ABSDialog {
    private static OnClickDialogListener onDialogListener;
    private Context context;

    int clickPostion=-1;

    public SelectAddressDialog(@NonNull Context context) {
//        super(context, R.style.NormalDialogStyle);
        super(context, R.style.BottomInBottomOutDialogStyle);
        this.context = context;
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width=WindowManager.LayoutParams.MATCH_PARENT;
        params.height= DisplayUtils.getDisplayHeight(context)*1/2;
        getWindow().setAttributes(params);
        getWindow().setGravity(Gravity.BOTTOM);
    }

    @Override
    protected void initView() {
        EditText et1 = getViewById(R.id.et1);
        RecyclerView recyclerView = getViewById(R.id.recyclerView);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list.add(i+"");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        RBaseAdapter<String > adapter=new RBaseAdapter<String>(getContext(),R.layout.item_dialog_select_address_layout,list) {
            @Override
            protected void fillItem(RViewHolder holder, String item, int position) {
                TextView tvContent = holder.getView(R.id.tvContent);
                TextView tvPhone = holder.getView(R.id.tvPhone);
                TextView tvAddress = holder.getView(R.id.tvAddress);
                CheckBox checkbox = holder.getView(R.id.checkbox);
                checkbox.setClickable(false);
                checkbox.setChecked(clickPostion==position?true:false);
            }

            @Override
            protected int getViewType(String item, int position) {
                return 0;
            }
        };
        adapter.setOnItemClickListener(new RBaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RViewHolder holder, View view, int position) {
                clickPostion=position;
                adapter.notifyDataSetChanged();

            }
        });
        recyclerView.setAdapter(adapter);


        TextView tvAddress = getViewById(R.id.tvAddress);
        TextView tvCancle = getViewById(R.id.tvCancle);
        TextView tvOk = getViewById(R.id.tvOk);
        tvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("添加地址");
            }
        });

        tvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (onDialogListener!=null){
                    onDialogListener.onSure();
                }
            }
        });
    }

    public static  void setOnDialogListener(OnClickDialogListener onDialogListener){
        SelectAddressDialog.onDialogListener = onDialogListener;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.dialog_select_address_layout;
    }
}
