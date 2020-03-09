package com.ysxsoft.icsaas.common_base.adapter.headandfooter;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Create By 胡
 * on 2020/3/6 0006
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mSparseArray;
    private View mConVertView;
    private BaseAdapter adapter;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mSparseArray = new SparseArray<>();
        mConVertView = itemView;
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mSparseArray.get(viewId);
        if (view == null) {
            view = mConVertView.findViewById(viewId);
            mSparseArray.put(viewId, view);
        }
        return (T) view;
    }

    public BaseViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public BaseViewHolder setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    /**
     * 关于事件的
     */
    public BaseViewHolder setOnClickListener(int viewId) {
        View view = getView(viewId);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.getmOnItemChildClickListener().onItemChildClick(adapter, v, getAdapterPosition());
            }
        });
        return this;
    }

    public BaseViewHolder setOnTouchListener(int viewId) {
        View view = getView(viewId);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        return this;
    }

    public BaseViewHolder setOnLongClickListener(int viewId) {
        View view = getView(viewId);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
        return this;
    }

    public static BaseViewHolder creatBaseViewHolder(View view) {
        return new BaseViewHolder(view);
    }

    public <T> void setAdapter(BaseAdapter adapter) {
        this.adapter = adapter;
    }


}
