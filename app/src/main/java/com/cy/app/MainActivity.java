package com.cy.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.UtilAliveService;
import com.cy.communication.UtilThread;


public class MainActivity extends Activity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();
    /**
     * 黑色唤醒广播的action
     */
    private final static String BLACK_WAKE_ACTION = "com.wake.black";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_gray).setOnClickListener(this);
        findViewById(R.id.btn_black).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.btn_gray) {//利用系统漏洞，灰色保活手段（API < 18 和 API >= 18 两种情况）
            UtilThread.toast("以受保护方式启动MyService");
            UtilAliveService.startAliveService(this, MyService.class);

        } else if (viewId == R.id.btn_black) { //拉帮结派，黑色保活手段，利用广播唤醒队友
            Intent blackIntent = new Intent();
            blackIntent.setAction(BLACK_WAKE_ACTION);
            sendBroadcast(blackIntent);

            /*AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            PendingIntent operation = PendingIntent.getBroadcast(this, 123, blackIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.set(AlarmManager.RTC, System.currentTimeMillis(), operation);*/

        }
    }
}
