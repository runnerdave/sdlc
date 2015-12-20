package com.runnerdave.jms.producer.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.runnerdave.jms.producer.model.Vendor;

@Controller
public class ProducerController {
	
	private static Logger logger = LogManager.getLogger(ProducerController.class.getName());
	
	@RequestMapping("/")
	public String renderVendorPage(Vendor vendor, Model model) {
		logger.info("REndering index.jsp");
		return "index";
	}
	
	@RequestMapping(value="/vendor", method=RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("vendor") Vendor vendor, Model model) {
		logger.info("Processing vendor object");
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
}
