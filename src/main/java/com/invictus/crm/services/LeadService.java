package com.invictus.crm.services;

import java.util.List;

import com.invictus.crm.model.Lead;

public interface LeadService {
	public List<Lead> searchLeadById(String patientId);

	public Lead saveLead(Lead lead);

	public boolean deleteLead(Lead lead);

	public Lead updateLead(Lead lead);
}
