package pers.masteryourself.study.mq.activemq.api.topic.persistence.conumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * <p>description : PersistenceTopicConsumer
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/10 14:24
 */
public class PersistenceTopicConsumer {

    public static void main(String[] args) throws Exception {
        //创建一个 JMS connection factory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.89.210:61616");
        //通过 connection factory 来创建 JMS connection
        Connection connection = connectionFactory.createConnection();
        // 设置持久化的 clientID
        connection.setClientID("编号9527");
        //启动 JMS connection
        connection.start();
        //通过 connection 创建 JMS session
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        //创建 JMS destination
        Topic destination = session.createTopic("persistence-topic");
        // 创建持久化订阅者
        TopicSubscriber consumer = session.createDurableSubscriber(destination, "9527");
        Message message = consumer.receive();
        while (message != null) {
            TextMessage textMessage = (TextMessage) message;
            session.commit();
            System.out.println("接收到消息" + textMessage.getText());
            message = consumer.receive();
        }
        //提交事务
        session.commit();
        //关闭所有的 JMS 资源（connection，session，consumer 等）
        consumer.close();
        session.close();
        connection.close();
    }

}
