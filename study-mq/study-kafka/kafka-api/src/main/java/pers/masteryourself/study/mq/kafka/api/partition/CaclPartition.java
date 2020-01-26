package pers.masteryourself.study.mq.kafka.api.partition;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/26 22:22
 */
public class CaclPartition {

    public static void main(String[] args) {
        // 25
        System.out.println(Math.abs("KafkaMessageConsumer".hashCode()) % 50);
    }

}
