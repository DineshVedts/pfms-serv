package com.vts.pfms_serv.model;

import java.sql.Date;

public class DemandDetails {

	private Long ProjectId;
	private String DemandNo;
	private String DemandDate;
	private String ItemFor;
	private Double EstimatedCost;
	
	public Long getProjectId() {
		return ProjectId;
	}
	public void setProjectId(Long projectId) {
		ProjectId = projectId;
	}
	public String getDemandNo() {
		return DemandNo;
	}
	public void setDemandNo(String demandNo) {
		DemandNo = demandNo;
	}
	public String getDemandDate() {
		return DemandDate;
	}
	public void setDemandDate(String demandDate) {
		DemandDate = demandDate;
	}
	public String getItemFor() {
		return ItemFor;
	}
	public void setItemFor(String itemFor) {
		ItemFor = itemFor;
	}
	public Double getEstimatedCost() {
		return EstimatedCost;
	}
	public void setEstimatedCost(Double estimatedCost) {
		EstimatedCost = estimatedCost;
	}

}
