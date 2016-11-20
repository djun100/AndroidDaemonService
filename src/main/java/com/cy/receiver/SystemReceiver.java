package com.cy.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.cy.app.Log;

public class SystemReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.writeW(intent.getAction());
    }
}
