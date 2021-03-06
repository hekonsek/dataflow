package reflow.app.timer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.kafka.test.utils.KafkaTestUtils.getSingleRecord;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ReflowAppTimerApplicationTest.class, ReflowAppTimerApplication.class})
public class ReflowAppTimerApplicationTest extends BaseKafkaTest {

    @Test
    public void shouldSendMessageToTopic() {
        getSingleRecord(consumer("vehicle"), "vehicle");
    }

}
