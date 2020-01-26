package pers.masteryourself.study.mq.activemq.api.topic.temporary.consumer;

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
public class TemporaryTopicConsumer {

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
        Destination destination = session.createTopic("temporary-topic");
        MessageConsumer consumer = session.createConsumer(destination);
        TextMessage message = (TextMessage) consumer.receive();
        //提交事务
        session.commit();
        System.out.println("接收到消息" + message.getText());
        //关闭所有的 JMS 资源（connection，session，consumer 等）
        consumer.close();
        session.close();
        connection.close();
    }

}
