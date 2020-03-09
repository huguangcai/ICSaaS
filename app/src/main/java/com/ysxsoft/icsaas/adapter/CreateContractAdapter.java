package com.ysxsoft.icsaas.adapter;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.adapter.headandfooter.BaseAdapter;
import com.ysxsoft.icsaas.common_base.adapter.headandfooter.BaseViewHolder;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * Create By 胡
 * on 2020/3/6 0006
 */
public class CreateContractAdapter extends BaseAdapter<String> {

    private OnClickListener onClickListener;
    private List<String> mData;

    public CreateContractAdapter(@Nullable int layoutId, List<String> mData) {
        super(layoutId, mData);
        this.mData = mData;
    }

    @Override
    protected void convert(BaseViewHolder holder, String s, int position) {
        ImageView iv_delete = holder.getView(R.id.iv_delete);
        TextView tvType = holder.getView(R.id.tvType);
        TextView tvEdit = holder.getView(R.id.tvEdit);
        if (position == 0) {
            iv_delete.setVisibility(View.INVISIBLE);
        } else {
            iv_delete.setVisibility(View.VISIBLE);
        }

        tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener!=null){
                    onClickListener.onEdit(position);
                }
            }
        });

        iv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener!=null){
                    onClickListener.onDelete(position);
                }
            }
        });


    }

    public interface  OnClickListener{
        void onDelete(int postion);
        void onEdit(int postion);
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

}
