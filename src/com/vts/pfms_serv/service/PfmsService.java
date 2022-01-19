package com.vts.pfms_serv.service;

import java.util.List;

import com.vts.pfms_serv.model.DemandDetails;
import com.vts.pfms_serv.model.ProjectFinancialDetails;
import com.vts.pfms_serv.model.ProjectSanctionDetails;

public interface PfmsService {

	public List<ProjectSanctionDetails> getProjectSanctionDetails(int inType, String employeeNo) throws Exception;
	public List<ProjectFinancialDetails> getFinancialDetails(String projectId, String rupees)throws Exception;
	public List<DemandDetails> getDemandsDetails(String projectId)throws Exception;
	public List<ProjectFinancialDetails> getFinanceDataBriefing(String projectId, String rupeevalue, String shareid) throws Exception;
}
