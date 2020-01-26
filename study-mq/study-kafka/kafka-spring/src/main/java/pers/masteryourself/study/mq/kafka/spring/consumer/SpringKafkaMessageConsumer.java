package pers.masteryourself.study.mq.kafka.spring.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/25 21:15
 */
public class SpringKafkaMessageConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-kafka-consumer.xml");
        applicationContext.start();
    }

}
