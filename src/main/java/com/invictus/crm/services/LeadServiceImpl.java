package com.invictus.crm.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invictus.crm.controller.LeadController;
import com.invictus.crm.dao.LeadDAO;
import com.invictus.crm.model.Lead;

@Service
public class LeadServiceImpl implements LeadService {

	private static final Logger logger = LoggerFactory.getLogger(LeadServiceImpl.class);
	@Autowired(required=true)
	private LeadDAO leadDAO;

	@Override
	public List<Lead> searchLeadById(String patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lead saveLead(Lead lead) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteLead(Lead lead) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Lead updateLead(Lead lead) {
		// TODO Auto-generated method stub
		return null;
	}

}
