package com.iqmsoft.jms.handlers;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.*;




@Component
public class Producer {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    public void send(String msg) {
        Connection connection = null;
        try {
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(brokerUrl);
            connection = factory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("TESTTOPIC");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            Message message = session.createTextMessage(msg);
            producer.send(message);
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}
