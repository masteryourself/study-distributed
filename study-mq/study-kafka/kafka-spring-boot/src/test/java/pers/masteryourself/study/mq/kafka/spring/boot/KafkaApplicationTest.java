package pers.masteryourself.study.mq.kafka.spring.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/26 15:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaApplication.class)
public class KafkaApplicationTest {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @Test
    public void testSpringBootKafkaMessageProducer() throws Exception {
        for (int i = 0; i < 10; i++) {
            kafkaTemplate.send("spring_boot_topic_test", "topic_spring_test: " + i);
            TimeUnit.MILLISECONDS.sleep(200);
        }
    }

}