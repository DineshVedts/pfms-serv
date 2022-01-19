package com.vts.pfms_serv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class PfmsServiceDaoImpl implements PfmsServiceDao {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Object[]> getProjectSanctionDetails(int inType, String employeeNo) throws Exception {
		Query query=null;
			String sanctionDetailsQuery="CALL Pfms_Dashboard_Finance('"+inType+"','"+employeeNo+"')";
			query = manager.createNativeQuery(sanctionDetailsQuery);
			List<Object[]> soDetails =query.getResultList() ;
		return soDetails;
	}
	
	private static final String financialDetailsQuery="CALL sp_RptHOACrossIFA(:projectId,:rupees)";
	@Override
	public List<Object[]> getgetFinancialDetails(String projectId, String rupees)throws Exception{
		Query query= manager.createNativeQuery(financialDetailsQuery);
		query.setParameter("projectId", projectId);
		query.setParameter("rupees", rupees);	
		return query.getResultList();
	}
	
	
	private static final String DEMANDDEATAILS="SELECT ProjectId, DemandNo, DemandDate, ItemFor, EstimatedCost FROM tblbooking WHERE ProjectId=:projectid";
	@Override
	public List<Object[]> getDemandsDetails(String projectId)throws Exception{
		Query query= manager.createNativeQuery(DEMANDDEATAILS);
		query.setParameter("projectid", projectId);
		
		JdbcTemplate temp;
		
		return query.getResultList();
	}
	
	
	
	@Override
	public List<Object[]> getFinanceDataBriefing(String projectId,String rupeevalue,String shareid)throws Exception
	{
		Query query= manager.createNativeQuery("CALL sp_RptHOACross(:projectid , :rupeevalue  , :shareid ); ");
		query.setParameter("projectid", projectId);
		query.setParameter("rupeevalue", rupeevalue);
		query.setParameter("shareid", shareid);
		
		return (List<Object[]> )query.getResultList();
	}
	
	
	
}
