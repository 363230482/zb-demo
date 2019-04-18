package com.activemq.original.p2p;

import com.activemq.original.Constants;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * 点对点模式下，针对同一个队列的多个消费者，消息几乎是平均的分发的每个消费者
 * 如队列中有50条消息，同时有2个消费者，则每个消费者消息25条消息
 *
 *
 * Created by Administrator on 2018/2/26 0026.
 */
public class AppConsumer {

    public static void main(String[] args) throws Exception {
        // 1.创建ConnectionFactory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(Constants.URL);

        Connection connection = connectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue(Constants.QUEUE_NAME);

        MessageConsumer consumer = session.createConsumer(queue);

        consumer.setMessageListener((message) -> {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接收消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
        });

        /*
        while (true) {
            Message message = consumer.receive(100 * 1000);
            System.out.println("接收消息： " + message);
        }
        */

        // 消息监听是异步的，所以不要在main里面立即关闭
//        connection.close();
    }

}
