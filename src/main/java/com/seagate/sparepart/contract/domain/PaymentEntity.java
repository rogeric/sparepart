package com.seagate.sparepart.contract.domain;

import java.sql.Date;

public class PaymentEntity {

	int paymentId;
	int contractId;
	Date paymentDate;
	Date rtDate;
	float installmentPriceRMB;
	String paymentStatus;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getContractId() {
		return contractId;
	}
	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Date getRtDate() {
		return rtDate;
	}
	public void setRtDate(Date rtDate) {
		this.rtDate = rtDate;
	}
	public float getInstallmentPriceRMB() {
		return installmentPriceRMB;
	}
	public void setInstallmentPriceRMB(float installmentPriceRMB) {
		this.installmentPriceRMB = installmentPriceRMB;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
}
