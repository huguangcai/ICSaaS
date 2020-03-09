package com.ysxsoft.icsaas.common_base.listener;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import com.ysxsoft.icsaas.common_base.utils.LogUtils;

/**
 * Create By 胡
 * on 2020/3/3 0003
 */
public class DevicePhoneListener extends PhoneStateListener{
    private static final String TAG = "PhoneCallListener";
    protected OnCallListener listener;

    @Override
    public void onCallStateChanged(int state, String phoneNumber) {
        super.onCallStateChanged(state, phoneNumber);
        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:// 电话挂断
                LogUtils.e(TAG, "电话挂断...");
                if (listener != null) {
                    listener.onIdle();
                }
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK: // 来电接通 或者 去电，去电接通  但是没法区分
                LogUtils.e(TAG, "正在通话...");
                if (listener != null) {
                    listener.Offhook();
                }
                break;
            case TelephonyManager.CALL_STATE_RINGING: //电话响铃的状态
                LogUtils.e(TAG, "电话响铃");
                if (listener != null) {
                    listener.onCallRinging();
                }
                break;
        }
    }

    public void setOnCallListener(OnCallListener onCallListener) {
        this.listener = onCallListener;
    }

    public interface OnCallListener {
        //挂断
        void onIdle();
        //正在通话
        void Offhook();
        //正在响铃
        void onCallRinging();

    }

}
