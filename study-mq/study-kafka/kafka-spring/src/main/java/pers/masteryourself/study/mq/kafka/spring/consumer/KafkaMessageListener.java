package pers.masteryourself.study.mq.kafka.spring.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/26 12:51
 */
public class KafkaMessageListener implements MessageListener<Integer, String> {

    @Override
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) {
        System.out.println("收到消息了");
        System.out.println(consumerRecord.value());
    }

}
