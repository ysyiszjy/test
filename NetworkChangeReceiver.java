package com.example.sevenactivity.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (isConnected) {
            boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
            Log.d("TAG网络连接状态：", "网络连接成功! ");
            if (isWiFi) {
                Log.d("TAG网络连接类型：", "WIFI连接成功！");
            } else {
                Log.d("TAG网络连接类型", "数据移动连接成功！");
            }
        } else {
            Log.d("TAG网络连接状态：", "断开网络连接！ ");
        }
    }
}