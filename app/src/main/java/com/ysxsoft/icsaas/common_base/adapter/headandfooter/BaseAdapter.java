package com.ysxsoft.icsaas.common_base.adapter.headandfooter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Create By 胡
 * on 2020/3/6 0006
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    private int layoutId;
    private List<T> mData;
    //header footer
    private LinearLayout mHeaderLayout;
    private FrameLayout mEmptyLayout;
    private boolean mIsUseEmpty = true;
    private final int EMPTY_VIEW = 0x011;
    private final int NOMARL_VIEW = 0x012;

    public BaseAdapter(@Nullable int layoutId, List<T> mData) {
        this.layoutId = layoutId;
        this.mData = mData;

    }

    public BaseAdapter(@Nullable int layoutId) {
        this.layoutId = layoutId;
    }

    public BaseAdapter(List<T> mData) {
        this.mData = mData;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View mView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        BaseViewHolder baseViewHolder = BaseViewHolder.creatBaseViewHolder(mView);
//设置监听:
        bindViewClickListener(mView, baseViewHolder);
        baseViewHolder.setAdapter(this);
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        convert(holder, mData.get(position), position);
    }

    protected abstract void convert(BaseViewHolder holder, T t, int position);

    //绑定事件:
    private void bindViewClickListener(View mView, final BaseViewHolder baseViewHolder) {
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(v, baseViewHolder.getAdapterPosition());
                }
            }
        });
        mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (OnItemLogClickListener != null) {
                    OnItemLogClickListener.onItemLongClick(v, baseViewHolder.getAdapterPosition());
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            throw new NullPointerException("mData is not Initialization");
        }
        return mData.size();
    }

    private OnItemClickListener mOnItemClickListener;
    private OnItemLogClickListener OnItemLogClickListener;

    public void setOnItemLogClickListener(BaseAdapter.OnItemLogClickListener onItemLogClickListener) {
        OnItemLogClickListener = onItemLogClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLogClickListener {
        boolean onItemLongClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    private OnItemChildClickListener mOnItemChildClickListener;

    public void setmOnItemChildClickListener(OnItemChildClickListener mOnItemChildClickListener) {
        this.mOnItemChildClickListener = mOnItemChildClickListener;
    }

    public OnItemChildClickListener getmOnItemChildClickListener() {
        return mOnItemChildClickListener;
    }

    public interface OnItemChildClickListener<T> {

        void onItemChildClick(BaseAdapter<T> adapter, View view, int position);
    }


}
