package com.ysxsoft.icsaas.ui.dialog;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.configure.PickerOptions;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.utils.DisplayUtils;
import com.ysxsoft.icsaas.common_base.view.ABSDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;

/**
 * Create By 胡
 * on 2020/3/9 0009
 */
public class TimeSelectPickerView {

    private Context context;
    private TimePickerView pvTime;
    private OnSelectedListener listener;

    public void init(Context context) {
        this.context = context;
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        //startDate.set(2013,1,1);
        //endDate.set(2020,1,1);
        //正确设置方式 原因：注意事项有说明
        startDate.set(2000, 0, 1);
        endDate.set(2050, 11,31);

        pvTime = new TimePickerBuilder(context, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                if (listener!=null){
                    listener.onSelected(date);
                }
            }
        }).setLayoutRes(R.layout.picker_date, new CustomListener() {
            @Override
            public void customLayout(View v) {
                TextView tvCancle = v.findViewById(R.id.tvCancle);
                tvCancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pvTime.dismiss();
                    }
                });
                TextView sure = v.findViewById(R.id.sure);
                sure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pvTime.returnData();
                        dismiss();
                    }
                });
            }
        })
                .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确定")//确认按钮文字
                .setContentTextSize(18)//滚轮文字大小
                .setTitleSize(20)//标题文字大小
                .setTitleText("Title")//标题文字
                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(false)//是否循环滚动
                .setTitleColor(Color.BLACK)//标题文字颜色
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor(Color.BLUE)//取消按钮文字颜色
                .setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
                .setBgColor(0xFFFFFF)//滚轮背景颜色 Night mode
                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .setLabel("年", "月", "日", "时", "分", "秒")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(true)//是否显示为对话框样式
                .build();
    }

    public void show(OnSelectedListener listener) {
        this.listener = listener;
        show();
    }

    public interface OnSelectedListener {
        void onSelected(Date date);
    }

    private void dismiss() {
        if (pvTime != null) {
            pvTime.dismiss();
        }
    }

    private void show() {
        dismiss();
        pvTime.show();
    }

//    @Override
//    protected int getLayoutResId() {
//        return R.layout.dialog_time_select_layout;
//    }
}
