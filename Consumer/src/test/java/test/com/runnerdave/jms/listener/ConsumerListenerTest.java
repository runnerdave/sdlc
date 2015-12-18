package test.com.runnerdave.jms.listener;

import static org.junit.Assert.assertNull;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.runnerdave.jms.listener.ConsumerListener;

public class ConsumerListenerTest {

	private ApplicationContext applicationContext;
	private TextMessage message;
	private ConsumerListener listener;
	
	private String json = "{vendorName:\"Microsofttest3\",firstName:\"BobTest\",lastName:\"SmithTest3\",address:\"123 Main test3\",city:\"TulsaTest3\",state:\"OKTest3\",zip:\"71345Test3\",email:\"Bob@microsoft.test3\",phoneNumber:\"test-123-test3\"}";

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("/spring/application-config.xml");
		listener = (ConsumerListener) applicationContext.getBean("consumerListener");
		message = createMock(TextMessage.class);
	}

	@After
	public void tearDown() throws Exception {
		((ConfigurableApplicationContext) applicationContext).close();
	}

	@Test
	public void testOnMessage() throws JMSException {
		expect(message.getText()).andReturn(json);
		replay(message);
		listener.onMessage(message);
		verify(message);
	}

}
