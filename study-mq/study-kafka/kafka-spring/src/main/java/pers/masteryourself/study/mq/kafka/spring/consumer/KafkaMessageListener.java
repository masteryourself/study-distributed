package pers.masteryourself.study.mq.kafka.spring.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/**
 * <p>description : KafkaMessageListener
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/26 12:51
 */
public class KafkaMessageListener implements MessageListener<Integer, String> {

    @Override
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) {
        System.out.println("收到消息了");
        System.out.println(consumerRecord.value());
    }

}
