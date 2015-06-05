package com.seagate.sparepart.domain;

public class HostInvEntry {
	int hostId;
	String hostType;
	String serialNumber;
	int noOfCpu;
	String hostname;
	String ip;
	String location;
	int ownerGid;
	String ownerName;
	int status;
	public int getHostId() {
		return hostId;
	}
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	public String getHostType() {
		return hostType;
	}
	public void setHostType(String hostType) {
		this.hostType = hostType;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public int getNoOfCpu() {
		return noOfCpu;
	}
	public void setNoOfCpu(int noOfCpu) {
		this.noOfCpu = noOfCpu;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getOwnerGid() {
		return ownerGid;
	}
	public void setOwnerGid(int ownerGid) {
		this.ownerGid = ownerGid;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
