package com.macadamian;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

public class BroadcastsActivity extends Activity {
    private BroadcastReceiver _receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String act = intent.getAction();
                if (WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(act)) {
                    show_network_info(intent);
                } else if (AudioManager.RINGER_MODE_CHANGED_ACTION.equals(act)) {
                    show_ringer_mode(intent);
                } else if (Intent.ACTION_TIME_TICK.equals(act)) {
                    show_tick(intent);
                }
            }
        };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.broadcasts);
        register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(_receiver);
    }

    private void register() {
        IntentFilter filt = new IntentFilter();
        filt.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filt.addAction(AudioManager.RINGER_MODE_CHANGED_ACTION);
        filt.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(_receiver, filt);
    }

    private void show_network_info(Intent i) {
        NetworkInfo ni = (NetworkInfo) i.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
        switch (ni.getState()) {
            case DISCONNECTED:
                show("Network DISCONNECTED");
                break;
            case DISCONNECTING:
                show("Network DISCONNECTING");
                break;
            case CONNECTING:
                show("Network CONNECTING");
                break;
            case CONNECTED:
                show("Network CONNECTED");
                break;
        }
    }

    private void show_ringer_mode(Intent i) {
        int mode = i.getIntExtra(AudioManager.EXTRA_RINGER_MODE, AudioManager.RINGER_MODE_NORMAL);
        switch (mode) {
            case AudioManager.RINGER_MODE_NORMAL:
                show("Ringer mode: NORMAL");
                break;
            case AudioManager.RINGER_MODE_SILENT:
                show("Ringer mode: SILENT");
                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                show("Ringer mode: VIBRATE");
                break;
        }
    }

    private void show_tick(Intent i) {
        show("Time has changed");
    }

    private void show(String m) {
        ((TextView) findViewById(R.id.broadcasts_output_messages)).append(m +"\n");
    }
}
