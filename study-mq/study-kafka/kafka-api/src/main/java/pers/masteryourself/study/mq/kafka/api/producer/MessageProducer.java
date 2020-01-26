package pers.masteryourself.study.mq.kafka.api.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/25 21:15
 */
public class MessageProducer {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "192.168.89.210:9092,192.168.89.220:9092,192.168.89.230:9092");
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "MessageProducer");
        // 需要 ISR 中的所有副本确认
        properties.put(ProducerConfig.ACKS_CONFIG, "-1");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                IntegerSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        KafkaProducer<Integer, String> producer = new KafkaProducer<>(properties);
        for (int i = 0; i < 50; i++) {
            String message = "message:" + i;
            System.out.println("message send: " + message);
            producer.send(new ProducerRecord<>("topic_test", message));
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }

}
