package com.clock.daemon.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.clock.daemon.UtilShowAlive;
import com.cy.app.Log;

/**
 * 普通的后台Service进程
 *
 * @author clock
 * @since 2016-04-12
 */
public class BackgroundService extends Service {

    private final static String TAG = BackgroundService.class.getSimpleName();

    @Override
    public void onCreate() {
        Log.writeW( "onCreate");
        UtilShowAlive.show("process bg:"+getClass().getName());
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        Log.writeW( "onDestroy");
        super.onDestroy();
    }
}
