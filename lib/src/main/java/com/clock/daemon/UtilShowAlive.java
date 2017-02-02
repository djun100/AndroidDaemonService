package com.clock.daemon;

import com.cy.app.Log;

/**
 * Created by Administrator on 2016/11/2.
 */

public class UtilShowAlive {
    public static void show(final String fromClass){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(60*60*1000);//60分钟打印一次
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.writeW(fromClass+" alive");
                }
            }
        }).start();
    }
}
