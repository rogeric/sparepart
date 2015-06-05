package com.seagate.sparepart.dao;

import java.util.List;
import java.util.Map;

import com.seagate.sparepart.domain.HostInvEntry;
import com.seagate.sparepart.domain.HostOpEntry;

public interface HostDao {

	public void addHostOp(HostOpEntry hoe);
	public List<HostOpEntry> getHostOpList();
	public List<HostOpEntry> getHostOpListAct();
	public HostOpEntry getHostOp(int hostOpId);
	public void iavHostOpStatus(int hostOpId);
		
	public void addHostInv(HostInvEntry hie);
	public List<HostInvEntry> getHostInvListAct();
	public List<HostInvEntry> getHostInvList();
	public HostInvEntry getHostInvAct(String hostname);
	public void iavHostInvStatus(int hostId);
	public Map<Integer,String> getHostnameListAct();

	
}
