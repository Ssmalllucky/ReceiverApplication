package com.qwer.receiverapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;

import com.qwer.receiverapplication.ReceiverActivity;

public class ReceivedAppReceiver extends BroadcastReceiver {

    public static final String TAG = "Receiver";
    public static final String RECEIVER_ACTION = "demo.action.RECEIVED_SWITCH_VALUE";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "Broadcast received");
        if (intent == null) {
            return;
        }

        String action = intent.getAction();
        if (!TextUtils.isEmpty(action) && RECEIVER_ACTION.equals(action)) {

            int switchValue = intent.getIntExtra("key_switch_status", 0);
            if (switchValue != 1 && switchValue != 0) {
                Log.e(TAG, "Invalid action value");
                return;
            }

            Settings.System.putInt(context.getContentResolver(),"key_switch_status",switchValue);
        }
    }
}
