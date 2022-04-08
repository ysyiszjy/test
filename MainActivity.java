package com.example.sevenactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.os.Bundle;

import com.example.sevenactivity.broadcast.BatteryLevelReceiver;
import com.example.sevenactivity.broadcast.NetworkChangeReceiver;
import com.example.sevenactivity.broadcast.PowerConnectionReceiver;

public class MainActivity extends AppCompatActivity {
    private PowerConnectionReceiver powerConnectionReceiver;
    private BatteryLevelReceiver batteryLevelReceiver;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        powerConnectionReceiver = new PowerConnectionReceiver();
        batteryLevelReceiver = new BatteryLevelReceiver();
        networkChangeReceiver = new NetworkChangeReceiver();

        IntentFilter filter = new IntentFilter();
        IntentFilter filter2 = new IntentFilter();
        filter2.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(powerConnectionReceiver, filter);
        registerReceiver(batteryLevelReceiver, filter);
        registerReceiver(networkChangeReceiver, filter2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(powerConnectionReceiver);
        unregisterReceiver(batteryLevelReceiver);
        unregisterReceiver(networkChangeReceiver);
    }
}