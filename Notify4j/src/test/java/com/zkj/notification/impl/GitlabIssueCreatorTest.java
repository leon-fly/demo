package com.zkj.notification.impl;

import com.zkj.notification.component.impl.GitlabIssueCreator;
import com.zkj.notification.model.Message;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/8/14
 */

public class GitlabIssueCreatorTest {
    private GitlabIssueCreator gitlabIssueCreator;

    @Before
    public void setGitlabIssueCreator(){
        gitlabIssueCreator = new GitlabIssueCreator();
        gitlabIssueCreator.setPrivateToken("65tWgzoSzdvFAXrUrucy");
        gitlabIssueCreator.setProjectId("7237845");
        gitlabIssueCreator.setApiUrl("https://gitlab.com/api/v4");
    }

    @Test
    public void notifyTest() throws Exception {
        //allen : 2265462  leonwang : 2503633 ziyi : 2397789
//        List<MessageReceiver> receivers = new LinkedList<>();
//        MessageReceiver msgReceiver1 = new MessageReceiver();
//        msgReceiver1.setId("2265462");
//        MessageReceiver msgReceiver2 = new MessageReceiver();
//        msgReceiver2.setId("2503633");
//        MessageReceiver msgReceiver3 = new MessageReceiver();
//        msgReceiver3.setId("2397789");
//        receivers.add(msgReceiver1);
//        receivers.add(msgReceiver3);
//        receivers.add(msgReceiver2);
        Message message = Message.build()
                .header("test")
                .body("error detail: this is a test issue, it's normal actually");

        gitlabIssueCreator.notify(message);
//        gitlabIssueCreator.notify(message, receivers);

    }
}
