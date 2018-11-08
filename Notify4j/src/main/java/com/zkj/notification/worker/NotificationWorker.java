package com.zkj.notification.worker;

import com.zkj.notification.model.Message;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/8/14
 */
public interface NotificationWorker {
    /**
     * 提交信息通知任务
     * @param message
     * @return
     */
    boolean submitNotificationTask(Message message);
}
