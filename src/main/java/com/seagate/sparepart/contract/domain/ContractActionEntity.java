package com.seagate.sparepart.contract.domain;

import java.sql.Date;

public class ContractActionEntity {

	int actionId;
	String actionType;
	String editDatetime;
	int contractId;
	int modifierGid;
	String modifierName;
	String category;
	String brand;
	String vendor;
	String type;
	String description;
	String po;
	String poLink;
	float priceRMB;
	Date startDate;
	Date endDate;
	int contractPeriod;
	String installmentPayTerms;
	String paymentCycle;
	Date paymentStartDay;
	String serviceLevel;
	String contractStatus;
	int qtyOfInstallments;
	String costCenter;
	String ownerName;
	String ownerExt;
	
	public int getActionId() {
		return actionId;
	}
	public void setActionId(int actionId) {
		this.actionId = actionId;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getEditDatetime() {
		return editDatetime;
	}
	public void setEditDatetime(String editDatetime) {
		this.editDatetime = editDatetime;
	}
	public int getContractId() {
		return contractId;
	}
	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
	public int getModifierGid() {
		return modifierGid;
	}
	public void setModifierGid(int modifierGid) {
		this.modifierGid = modifierGid;
	}
	public String getModifierName() {
		return modifierName;
	}
	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPo() {
		return po;
	}
	public void setPo(String po) {
		this.po = po;
	}
	public String getPoLink() {
		return poLink;
	}
	public void setPoLink(String poLink) {
		this.poLink = poLink;
	}
	public float getPriceRMB() {
		return priceRMB;
	}
	public void setPriceRMB(float priceRMB) {
		this.priceRMB = priceRMB;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(int contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public String getInstallmentPayTerms() {
		return installmentPayTerms;
	}
	public void setInstallmentPayTerms(String installmentPayTerms) {
		this.installmentPayTerms = installmentPayTerms;
	}
	public String getPaymentCycle() {
		return paymentCycle;
	}
	public void setPaymentCycle(String paymentCycle) {
		this.paymentCycle = paymentCycle;
	}
	public Date getPaymentStartDay() {
		return paymentStartDay;
	}
	public void setPaymentStartDay(Date paymentStartDay) {
		this.paymentStartDay = paymentStartDay;
	}
	public String getServiceLevel() {
		return serviceLevel;
	}
	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public int getQtyOfInstallments() {
		return qtyOfInstallments;
	}
	public void setQtyOfInstallments(int qtyOfInstallments) {
		this.qtyOfInstallments = qtyOfInstallments;
	}
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerExt() {
		return ownerExt;
	}
	public void setOwnerExt(String ownerExt) {
		this.ownerExt = ownerExt;
	}
	
	
	
}
