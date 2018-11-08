package com.zkj.notification.component;

import com.zkj.notification.model.Message;
import com.zkj.notification.model.MessageReceiver;

import java.util.List;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/8/13
 */
public interface NotificationModule {
    /**
     * 发送通知
     * @param message  信息内容
     * @throws Exception
     */
    void notify(Message message) throws Exception;

    /**
     * 获取组件名称
     * @return
     */
    String getModuleName();
}
