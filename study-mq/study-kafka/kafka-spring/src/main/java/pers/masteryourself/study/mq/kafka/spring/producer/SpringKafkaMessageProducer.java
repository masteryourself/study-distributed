package pers.masteryourself.study.mq.kafka.spring.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/25 21:15
 */
public class SpringKafkaMessageProducer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-kafka-producer.xml");
        KafkaTemplate kafkaTemplate = applicationContext.getBean(KafkaTemplate.class);
        for (int i = 0; i < 10; i++) {
            kafkaTemplate.send("spring_topic_test", "spring_topic_test: " + i);
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }

}
