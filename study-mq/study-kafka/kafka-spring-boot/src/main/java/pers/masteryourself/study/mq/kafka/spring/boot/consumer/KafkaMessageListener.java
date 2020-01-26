package pers.masteryourself.study.mq.kafka.spring.boot.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/26 12:51
 */
@Component
public class KafkaMessageListener {

    @KafkaListener(topics = {"spring_boot_topic_test"})
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) {
        System.out.println("收到消息了");
        System.out.println(consumerRecord.value());
    }

}
