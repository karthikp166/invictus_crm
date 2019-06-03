package com.invictus.crm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.invictus.crm.model.Lead;
import com.invictus.crm.services.LeadService;


@Controller
public class LeadController {
	private static final Logger logger = LoggerFactory.getLogger(LeadController.class);
	
	@Autowired(required=true)
	private LeadService leadService;
	
	@RequestMapping(value = "/lead", method = RequestMethod.GET)
	public String listLead(Model model) {
		logger.info("listLead");
		model.addAttribute("lead", new Lead());
		String pateintId="";
		model.addAttribute("leads", this.leadService.searchLeadById(pateintId));
		return "lead";
	}


}
