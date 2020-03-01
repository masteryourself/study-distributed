package pers.masteryourself.study.mq.kafka.api.partition;

/**
 * <p>description : CalPartition
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/25 21:15
 */
public class CalPartition {

    public static void main(String[] args) {
        // 25
        System.out.println(Math.abs("KafkaMessageConsumer".hashCode()) % 50);
    }

}
