package com.vts.pfms_serv.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vts.pfms_serv.model.DemandDetails;
import com.vts.pfms_serv.model.ProjectFinancialDetails;
import com.vts.pfms_serv.model.ProjectSanctionDetails;
import com.vts.pfms_serv.service.PfmsService;


@RestController
public class PfmsServiceController {
	@Autowired
	PfmsService service;
	
	@RequestMapping(method = RequestMethod.POST, value="pfms-chart-service")
	public String getDetailsOfSupplyOrder(HttpServletRequest req) throws Exception {
		String inType=req.getParameter("inType");
		int loginType=0;
		if("Z".equalsIgnoreCase(inType)) {
			loginType=8;
		}else if("Y".equalsIgnoreCase(inType)) {
			loginType=8;
		}else if("P".equalsIgnoreCase(inType)) {
			loginType=7;
		}else if("A".equalsIgnoreCase(inType)) {
			loginType=1;
		}else {
			loginType=1;
		}
		
		String employeeNo=req.getParameter("employeeNo");
		List<ProjectSanctionDetails> projectDetails=service.getProjectSanctionDetails(loginType,employeeNo);
		Gson gson = new Gson();
		String jsonCartList = gson.toJson(projectDetails);
		return jsonCartList;
	}
	
	
	
	
	@RequestMapping(value="newDemandsDetails",method=RequestMethod.POST)
	public String DemandsDetails(HttpServletRequest req) throws Exception{
		
		String projectId=req.getParameter("projectId");
		List<DemandDetails> demandDetails =service.getDemandsDetails(projectId);
		Gson gson = new Gson();
		String jsonDemandDetailsList = gson.toJson(demandDetails);
		return jsonDemandDetailsList;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="financialStatus")
	public String financialStatus(HttpServletRequest req) throws Exception{
		String projectId=req.getParameter("projectId");
		String rupees=req.getParameter("rupess");
          
		List<ProjectFinancialDetails>  financialDetails =service.getFinancialDetails(projectId,rupees);
		Gson gson = new Gson();
		String jsonFinancialDetailsList = gson.toJson(financialDetails);
		return jsonFinancialDetailsList;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="financialStatusBriefing")
	public String financialStatusBriefing(HttpServletRequest req) throws Exception{
		String projectId=req.getParameter("projectId");
		String rupees=req.getParameter("rupess");
		List<ProjectFinancialDetails> FinanceData = service.getFinanceDataBriefing(projectId, rupees, "0");
		Gson gson = new Gson();
		String jsonFinancialDetailsList = gson.toJson(FinanceData);
		return jsonFinancialDetailsList;
	}
	
	
	
	
	
}
