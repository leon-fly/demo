package com.zkj.notification;

import com.zkj.notification.model.Message;
import com.zkj.notification.worker.NotificationWorker;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/8/15
 */
public class Notifier {
    private NotificationWorker notificationWorker;

    public void notify(Message msg){
        notificationWorker.submitNotificationTask(msg);
    }

    public NotificationWorker getNotificationWorker() {
        return notificationWorker;
    }

    public void setNotificationWorker(NotificationWorker notificationWorker) {
        this.notificationWorker = notificationWorker;
    }
}
