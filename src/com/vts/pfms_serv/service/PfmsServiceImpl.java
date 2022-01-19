package com.vts.pfms_serv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vts.pfms_serv.dao.PfmsServiceDao;
import com.vts.pfms_serv.model.DemandDetails;
import com.vts.pfms_serv.model.ProjectFinancialDetails;
import com.vts.pfms_serv.model.ProjectSanctionDetails;

@Service
public class PfmsServiceImpl implements PfmsService{
	
	@Autowired
	PfmsServiceDao dao;
	
	public List<ProjectSanctionDetails> getProjectSanctionDetails(int inType, String employeeNo) throws Exception{
		List<ProjectSanctionDetails> psList=new ArrayList<ProjectSanctionDetails>();
		List<Object[]> sanctionDetailsList=dao.getProjectSanctionDetails(inType,employeeNo);
		if(sanctionDetailsList !=null && sanctionDetailsList.size()>0) {
		for(Object[] obj:sanctionDetailsList) {
			ProjectSanctionDetails psModel=new ProjectSanctionDetails();
			psModel.setSno(Integer.parseInt(obj[0].toString()));
			psModel.setProjectCode(obj[1].toString());
			psModel.setProjectName(obj[2].toString());
			//psModel.setBudgetHeadDescription(obj[3].toString());
			psModel.setSancAmt(Double.parseDouble(obj[3].toString()));
			psModel.setExpAmt(Double.parseDouble(obj[4].toString()));
			psModel.setOsComAmt(Double.parseDouble(obj[5].toString()));
			psModel.setDipl(Double.parseDouble(obj[6].toString()));
			psModel.setBalAmt(Double.parseDouble(obj[7].toString()));
			psModel.setProjectid(Integer.parseInt(obj[8].toString()));
			psModel.setAsOnDate(obj[9].toString());
			psList.add(psModel);
		}
		}
		return psList;
	}

	@Override
	public List<ProjectFinancialDetails> getFinancialDetails(String projectId, String rupees) throws Exception {
		List<ProjectFinancialDetails> fList= new ArrayList<ProjectFinancialDetails>();
		List<Object[]> data = dao.getgetFinancialDetails(projectId,rupees);
		if(data!=null&& data.size()>0) {
			for(Object[] obj: data) {
				ProjectFinancialDetails pfd=new ProjectFinancialDetails();
				pfd.setBudgetHeadDescription(obj[0].toString());
				pfd.setTotalSanction( Double.parseDouble(obj[1].toString()));
				pfd.setReSanction(Double.parseDouble(obj[2].toString()));
				pfd.setFeSanction(Double.parseDouble(obj[3].toString()));
				pfd.setReExpenditure(Double.parseDouble(obj[4].toString()));
				pfd.setFeExpenditure(Double.parseDouble(obj[5].toString()));
				pfd.setReOutCommitment(Double.parseDouble(obj[6].toString()));
				pfd.setFeOutCommitment(Double.parseDouble(obj[7].toString()));
				pfd.setReDipl(Double.parseDouble(obj[8].toString()));
				pfd.setFeDipl(Double.parseDouble(obj[9].toString()));
				pfd.setReBalance(Double.parseDouble(obj[10].toString()));
				pfd.setFeBalance(Double.parseDouble(obj[11].toString()));
				pfd.setBudgetHeadId(Integer.parseInt(obj[12].toString()));
				pfd.setProjectId(Long.parseLong(obj[13].toString()));
				fList.add(pfd);
			}
		}
		
		return fList;
	}

	@Override
	public List<DemandDetails> getDemandsDetails(String projectId) throws Exception {
		List<DemandDetails> dDList=new ArrayList<>();
		List<Object[]> data = dao.getDemandsDetails(projectId);
		if(data!=null) {
			for(Object[] obj:data) {
				DemandDetails dd= new DemandDetails();
	            dd.setProjectId(Long.parseLong(obj[0].toString()));
	            dd.setDemandNo(obj[1].toString());
	            dd.setDemandDate(obj[2].toString());
	            dd.setItemFor(obj[3].toString());
	            dd.setEstimatedCost(Double.parseDouble(obj[4].toString()));
	            dDList.add(dd);
			}
		}
		return dDList;
	}
	
	
	
	@Override
	public List<ProjectFinancialDetails> getFinanceDataBriefing(String projectId,String rupeevalue,String shareid)throws Exception
	{
		
		List<ProjectFinancialDetails> fList= new ArrayList<ProjectFinancialDetails>();
		List<Object[]> data = dao.getFinanceDataBriefing(projectId, rupeevalue, shareid);
		if(data!=null&& data.size()>0) {
			for(Object[] obj: data) {
				ProjectFinancialDetails pfd=new ProjectFinancialDetails();
				pfd.setBudgetHeadDescription(obj[0].toString());
				pfd.setTotalSanction( Double.parseDouble(obj[1].toString()));
				pfd.setReSanction(Double.parseDouble(obj[2].toString()));
				pfd.setFeSanction(Double.parseDouble(obj[3].toString()));
				pfd.setReExpenditure(Double.parseDouble(obj[4].toString()));
				pfd.setFeExpenditure(Double.parseDouble(obj[5].toString()));
				pfd.setReOutCommitment(Double.parseDouble(obj[6].toString()));
				pfd.setFeOutCommitment(Double.parseDouble(obj[7].toString()));
				pfd.setReDipl(Double.parseDouble(obj[8].toString()));
				pfd.setFeDipl(Double.parseDouble(obj[9].toString()));
				pfd.setReBalance(Double.parseDouble(obj[10].toString()));
				pfd.setFeBalance(Double.parseDouble(obj[11].toString()));
				pfd.setBudgetHeadId(Integer.parseInt(obj[12].toString()));
				pfd.setProjectId(Long.parseLong(obj[13].toString()));
				fList.add(pfd);
			}
		}
		
		return fList;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
