package com;

import android.app.Activity;
import android.content.Intent;

import com.clock.daemon.receiver.WakeReceiver;
import com.clock.daemon.service.GrayService;

/**
 * Created by cy on 2017/2/2.
 */

public class UtilAliveService {

    /**fixme 很可能需要与 WakeGrayInnerService 在同一个进程，暂时为主进程
     * @param activity
     * @param clazz
     */
    public static void startAliveService(Activity activity
            ,Class<? extends WakeReceiver.WakeNotifyService> clazz ){

        WakeReceiver.setServiceToProtect(clazz);
        Intent grayIntent = new Intent(activity, GrayService.class);

        activity.startService(grayIntent);
    }
}
