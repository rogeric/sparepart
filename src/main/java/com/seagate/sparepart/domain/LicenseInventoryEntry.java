package com.seagate.sparepart.domain;

public class LicenseInventoryEntry {

	private int invId;
	private String licenseName;
	private String licenseKey;
	private String licenseType;
	private int totalQuantity;
	private int spareQuantity;
	private int invStatus;
	
	
	public int getInvId() {
		return invId;
	}
	public void setInvId(int invId) {
		this.invId = invId;
	}
	public String getLicenseName() {
		return licenseName;
	}
	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}
	public String getLicenseKey() {
		return licenseKey;
	}
	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
	public String getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public int getSpareQuantity() {
		return spareQuantity;
	}
	public void setSpareQuantity(int spareQuantity) {
		this.spareQuantity = spareQuantity;
	}
	public int getInvStatus() {
		return invStatus;
	}
	public void setInvStatus(int invStatus) {
		this.invStatus = invStatus;
	}
	
}
