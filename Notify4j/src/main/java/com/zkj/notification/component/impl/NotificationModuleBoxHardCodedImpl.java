package com.zkj.notification.component.impl;

import com.zkj.notification.component.NotificationModule;
import com.zkj.notification.component.NotificationModuleBox;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/8/14
 */
public class NotificationModuleBoxHardCodedImpl implements NotificationModuleBox {
    private GitlabIssueCreator gitlabIssueCreator;
    private List<NotificationModule> notificationModulesInUse;

    @Override
    public List<NotificationModule> getNotificationModulesInUse() {
        if(notificationModulesInUse == null){
            synchronized (this){
                if (notificationModulesInUse == null){
                    notificationModulesInUse = new LinkedList<>();
                    notificationModulesInUse.add(gitlabIssueCreator);
                }
            }
        }
        return notificationModulesInUse;
    }

    public void setGitlabIssueCreator(GitlabIssueCreator gitlabIssueCreator) {
        this.gitlabIssueCreator = gitlabIssueCreator;
    }
}
