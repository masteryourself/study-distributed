package pers.masteryourelf.study.mq.activemq.api.queue.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/10 14:24
 */
public class QueueProducer {

    public static void main(String[] args) throws Exception {
        //创建一个 JMS connection factory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.89.210:61616");
        //通过 connection factory 来创建 JMS connection
        Connection connection = connectionFactory.createConnection();
        //启动 JMS connection
        connection.start();
        //通过 connection 创建 JMS session，第一个参数表示使用事务
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        //创建 JMS destination
        Destination destination = session.createQueue("my-queue");
        //创建 JMS producer，并设置 destination
        MessageProducer producer = session.createProducer(destination);
        //创建 JMS consumer，或者是注册一个 JMS message listener
        TextMessage message = session.createTextMessage("hello,activemq");
        // 添加消息属性
        message.setStringProperty("custom-message","自定义的消息属性");
        //发送 JMS message
        producer.send(message);
        //提交事务，对于 provider 来说，即消息被发送到 activeMQ 上
        session.commit();
        //关闭所有的 JMS 资源（connection，session，producer等）
        producer.close();
        session.close();
        connection.close();
    }

}
