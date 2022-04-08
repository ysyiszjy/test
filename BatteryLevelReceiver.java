package com.example.sevenactivity.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;

public class BatteryLevelReceiver extends BroadcastReceiver {

    private static final String TAG = "TAG电量状态：";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle batteryStatus = intent.getExtras();
        int level = batteryStatus.getInt(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getInt(BatteryManager.EXTRA_SCALE, -1);

        float batteryPct = level / (float) scale;
        if (batteryPct < 0.2) {
            Log.d(TAG, "当前处于低电量......");
        } else {
            Log.d(TAG, "离开低电量区......");
        }

    }
}