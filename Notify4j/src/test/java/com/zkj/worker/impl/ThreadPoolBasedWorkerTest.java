package com.zkj.worker.impl;

import com.zkj.notification.component.NotificationModuleBox;
import com.zkj.notification.component.impl.GitlabIssueCreator;
import com.zkj.notification.component.impl.NotificationModuleBoxHardCodedImpl;
import com.zkj.notification.model.Message;
import com.zkj.notification.worker.impl.ThreadPoolBasedWorker;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/8/14
 */
public class ThreadPoolBasedWorkerTest {
    private ThreadPoolBasedWorker threadPoolBasedWorker;

    @Before
    public void init(){
        threadPoolBasedWorker = new ThreadPoolBasedWorker();
        threadPoolBasedWorker.setWorkQueueMaxSize(3);
        threadPoolBasedWorker.init();

        NotificationModuleBoxHardCodedImpl notificationModuleBox = new NotificationModuleBoxHardCodedImpl();
        GitlabIssueCreator gitlabIssueCreator = new GitlabIssueCreator();
        gitlabIssueCreator.setPrivateToken("65tWgzoSzdvFAXrUrucy");
        gitlabIssueCreator.setProjectId("7237845");
        gitlabIssueCreator.setApiUrl("https://gitlab.com/api/v4");

        notificationModuleBox.setGitlabIssueCreator(gitlabIssueCreator);

        threadPoolBasedWorker.setNotificationModuleBox(notificationModuleBox);
    }

    @Test
    public void submitNotificationTaskTest() throws InterruptedException {
        Message message = Message.build()
                .header("ServerWarning:"+"test")
                .body("error detail: this is a test issue, it's normal actually");
        for (int i=0;i<10;i++) {
            Thread.currentThread().sleep(500);
            System.out.println("提交第"+i+"个工作任务");
            threadPoolBasedWorker.submitNotificationTask(message);
        }
        System.out.println("function main is over");
        try {
            Thread.currentThread().sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
