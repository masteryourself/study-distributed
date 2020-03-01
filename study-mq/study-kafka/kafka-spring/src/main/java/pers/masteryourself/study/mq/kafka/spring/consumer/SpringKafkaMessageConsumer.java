package pers.masteryourself.study.mq.kafka.spring.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>description : SpringKafkaMessageConsumer
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/26 12:51
 */
public class SpringKafkaMessageConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-kafka-consumer.xml");
        applicationContext.start();
    }

}
