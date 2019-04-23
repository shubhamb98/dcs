package pubsub;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class StockPublisher {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
// JMS messages are sent and received using a Session. We will
// create here a non-transactional session object. If you want
// to use transactions you should set the first parameter to 'true'
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("stocks");
		MessageProducer producer = session.createProducer(topic);
// We will send a small text message saying 'Hello'
		TextMessage message = session.createTextMessage();
		message.setText("ID:1, Company Name:TCS, Price:$10, Stocks:1000, Seller ID:1234");
// Here we are sending the message!
		producer.send(message);
		System.out.println("Sent message '" + message.getText() + "'");
		connection.close();
	}
}
