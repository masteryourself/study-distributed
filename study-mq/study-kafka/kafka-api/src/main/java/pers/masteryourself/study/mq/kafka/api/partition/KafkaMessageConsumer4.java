package pers.masteryourself.study.mq.kafka.api.partition;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

/**
 * <p>description : KafkaMessageConsumer4
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/25 21:15
 */
public class KafkaMessageConsumer4 {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "192.168.89.210:9092,192.168.89.220:9092,192.168.89.230:9092");
        // 消费组 ID
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaMessageConsumer");
        // 开启自动确认
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        // 每一秒钟确认一次
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                IntegerDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        // 新的消费者会从该 topic 最早的消息开始消费
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        KafkaConsumer<Integer, String> consumer = new KafkaConsumer<>(properties);
        // 消费指定分区的时候，不需要再订阅
        // consumer.subscribe(Collections.singleton("topic_partition"));
        TopicPartition topicPartition = new TopicPartition("topic_partition", 0);
        // 消费指定的分区
        consumer.assign(Arrays.asList(topicPartition));
        while (true) {
            ConsumerRecords<Integer, String> records = consumer.poll(1000);
            for (ConsumerRecord<Integer, String> record : records) {
                System.out.println("message receive: " + record.value());
            }
        }
    }

}
