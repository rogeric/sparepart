package com.seagate.sparepart.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seagate.sparepart.dao.HostDao;
import com.seagate.sparepart.domain.HostInvEntry;
import com.seagate.sparepart.domain.HostOpEntry;

@Service
public class HostService {

	private HostDao dao;
	
	@Autowired
	public HostService(HostDao dao){
		this.dao = dao;
	}
	
	
	
	public void addHostOp(HostOpEntry hoe){
//		1. Insert a row in Host inventory
//		2. Get host_id from the record, set it into host op entry
//		3. Insert a row in Host Op table
//		4. Set user 'gid 'name and 'op_date in loe
		HostInvEntry hie = new HostInvEntry();
		hie.setHostType(hoe.getHostType());
		hie.setSerialNumber(hoe.getSerialNumber());
		hie.setNoOfCpu(hoe.getNoOfCpu());
		hie.setHostname(hoe.getHostname());
		hie.setIp(hoe.getIp());
		hie.setLocation(hoe.getLocation());
		hie.setOwnerGid(hoe.getOwnerGid());
		hie.setOwnerName(hoe.getOwnerName());
		hie.setStatus(1);
		dao.addHostInv(hie);
		
		int id = dao.getHostInvAct(hie.getHostname()).getHostId();
		hoe.setHostId(id);
		hoe.setOpType("create");
		hoe.setStatus(1);
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		hoe.setOpDate(currentTime);
		dao.addHostOp(hoe);
	}
	
	public void delHostOp(int hostOpId){
//		1. Mark host op row's status to 0
//		2. Create 1 new row in host op, most of the columns are same as the deleted one, except hostOpId, operator, op_type, op_date, status
//		3. Mark host inv row's status to 0
		
//		TODO delete host will release related licenses
		dao.iavHostOpStatus(hostOpId);
		
		HostOpEntry hoe = new HostOpEntry();
		hoe = dao.getHostOp(hostOpId);
		int hostId = hoe.getHostId();
		hoe.setOpType("delete");
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		hoe.setOpDate(currentTime);
		hoe.setStatus(0);
		dao.addHostOp(hoe);
		
		dao.iavHostInvStatus(hostId);
		
	}
	
	public List<HostInvEntry> getHostInvListAct(){
		return dao.getHostInvListAct();
	}
	
	public List<HostOpEntry> getHostOpListAct(){
		return dao.getHostOpListAct();
	}
	
	public Map<Integer,String> getHostnameListAct(){
		return dao.getHostnameListAct();
	}
	
	public HostOpEntry getHostOp(int hostOpId){
		return dao.getHostOp(hostOpId);
	}
}
