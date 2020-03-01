package pers.masteryourself.study.mq.activemq.api.topic.persistence.provider;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * <p>description : PersistenceTopicProducer
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/10 14:24
 */
public class PersistenceTopicProducer {

    public static void main(String[] args) throws Exception {
        //创建一个 JMS connection factory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.89.210:61616");
        //通过 connection factory 来创建 JMS connection
        Connection connection = connectionFactory.createConnection();
        //启动 JMS connection
        connection.start();
        //通过 connection 创建 JMS session
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        //创建 JMS destination
        Destination destination = session.createTopic("persistence-topic");
        //创建 JMS producer，并设置 destination
        MessageProducer producer = session.createProducer(destination);
        // 设置持久化消息模式
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        //创建 JMS consumer，或者是注册一个 JMS message listener
        TextMessage message = session.createTextMessage("hello,activemq");
        //发送 JMS message
        producer.send(message);
        //提交事务
        session.commit();
        //关闭所有的 JMS 资源（connection，session，producer等）
        producer.close();
        session.close();
        connection.close();
    }

}
