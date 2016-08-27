package com.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ActiveMqTest {
	public static void main(String[] args) throws JmsException, JMSException {

		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

		//Connection connection = connectionFactory.createConnection();
		//	System.out.println(connection);
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
	 
		jmsTemplate.setDefaultDestinationName("test");
		jmsTemplate.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
			    
				return session.createTextMessage("hello word!");
			}
		});
		TextMessage textMessage = (TextMessage) jmsTemplate.receive("test");
		System.out.println(textMessage.getText());
	}
}
