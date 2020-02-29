import com.leon.demo.message.rabbitmq.RabbitmqApplication;
import com.leon.demo.message.rabbitmq.producers.Producer;
import com.leon.demo.message.rabbitmq.receivers.Receiver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/1/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
public class ProducerTest {
    @Autowired
    private Producer producer;

    @Test
    public void test(){
        System.out.println("send >>>>>>>>>>>>>>>>>");
        producer.send("hello, i am producer~");
        System.out.println("send <<<<<<<<<<<<<<<<");
    }
}
