package com.seagate.sparepart.domain;

public class Assignment {

	int asnId;
	int invId;
	String licenseName;
	int hostId;
	String hostname;
	int quantity;
	int applicantGid;
	String applicantName;
	String applyDate;
	int releaserGid;
	String releaserName;
	String releaseDate;
	String opType;
	public int getAsnId() {
		return asnId;
	}
	public void setAsnId(int asnId) {
		this.asnId = asnId;
	}
	public int getInvId() {
		return invId;
	}
	public void setInvId(int invId) {
		this.invId = invId;
	}
	public int getHostId() {
		return hostId;
	}
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getApplicantGid() {
		return applicantGid;
	}
	public void setApplicantGid(int applicantGid) {
		this.applicantGid = applicantGid;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public int getReleaserGid() {
		return releaserGid;
	}
	public void setReleaserGid(int releaserGid) {
		this.releaserGid = releaserGid;
	}
	public String getReleaserName() {
		return releaserName;
	}
	public void setReleaserName(String releaserName) {
		this.releaserName = releaserName;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getOpType() {
		return opType;
	}
	public void setOpType(String opType) {
		this.opType = opType;
	}
	
	public String getLicenseName() {
		return licenseName;
	}
	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
}
