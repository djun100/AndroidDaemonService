package com.cy.app;

import com.clock.daemon.receiver.WakeReceiver;

public class MyService extends WakeReceiver.WakeNotifyService {
    Thread thread;
    long timePeriod=1000*60*30;//30min
    @Override
    public void onCreate() {
        super.onCreate();
        if (thread==null){
            thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        Log.writeW("myservice alive");
                        try {
                            Thread.sleep(timePeriod);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
        }
    }
}
