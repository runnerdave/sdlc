package test.com.runnerdave.jms.producer.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.runnerdave.jms.producer.controller.ProducerController;
import com.runnerdave.jms.producer.model.Vendor;

public class ProducerControllerTest {

	private Vendor vendor;
	private Model model;
	private ProducerController producerController;
	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring/application-config.xml");
		producerController = (ProducerController) context.getBean("producerController");
		vendor = new Vendor();
		vendor.setAddress("mi casa");
		vendor.setCity("Caracas");
		vendor.setEmail("email@email.com");
		vendor.setFirstName("nombre");
		vendor.setLastName("apellido");
		vendor.setPhoneNumber("666");
		vendor.setState("DF");
		vendor.setVendorName("UPS");
		vendor.setZipCode("1234");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRenderVendorPage() {
		assertEquals("index", producerController.renderVendorPage(vendor, model));
	}

	@Test
	public void testProcessRequest() {
		ModelAndView mv = producerController.processRequest(vendor, model);
		assertEquals("index", mv.getViewName());
	}

}
