package com.vts.pfms_serv.dao;

import java.util.List;

public interface PfmsServiceDao {
	public List<Object[]> getProjectSanctionDetails(int inType, String employeeNo) throws Exception;
	public List<Object[]> getgetFinancialDetails(String projectId, String rupees)throws Exception;
	public List<Object[]> getDemandsDetails(String projectId)throws Exception;
	public List<Object[]> getFinanceDataBriefing(String projectId, String rupeevalue, String shareid) throws Exception;
	
}
