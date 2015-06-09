package com.seagate.sparepart.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.seagate.sparepart.dao.AssignmentDao;
import com.seagate.sparepart.dao.LicenseDAO;
import com.seagate.sparepart.domain.Assignment;
import com.seagate.sparepart.domain.LicenseInventoryEntry;
import com.seagate.sparepart.domain.LicenseOpEntry;

@Service
public class LicenseService {

	private LicenseDAO dao;
	private AssignmentDao asnDao;
	
	@Autowired
	public LicenseService(LicenseDAO dao, AssignmentDao asnDao){
		this.dao = dao;
		this.asnDao = asnDao;
	}

	//Actions on license_operation
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void addLicenseOpEntry(LicenseOpEntry loe){
//		1. Create on row in inventory_operation
//		2. Decide if the license name is exist in DB "inventory"
//		3. If yes, update license total quantity and spare quantity in DB "inventory"
//		4. If no, create one new row in DB "inventory"
//		5. inv_id is get from "license", so it should update "inventory" first, then get the inv_id back to update.
//		6. Frontend -- Judge if loe.getQuantity() > 0
//		8. use String for op_date
		
//		not completed
//		7. set user 'gid 'name and 'op_date in loe

		LicenseInventoryEntry lie;
		int count = dao.cntLicenseInvEntry(loe.getLicenseName());
		if(count != 0){
			lie = dao.getLicenseInv(loe.getLicenseName());
			lie.setTotalQuantity(lie.getTotalQuantity() + loe.getQuantity());
			lie.setSpareQuantity(lie.getSpareQuantity() + loe.getQuantity());
			lie.setInvStatus(1);
			dao.updLicInvQty(lie.getInvId(), lie.getTotalQuantity(), lie.getSpareQuantity(), lie.getInvStatus());;
		}else{
			lie = new LicenseInventoryEntry();
			lie.setLicenseName(loe.getLicenseName());
			lie.setLicenseKey(loe.getLicenseKey());
			lie.setLicenseType(loe.getLicenseType());
			lie.setTotalQuantity(loe.getQuantity());
			lie.setSpareQuantity(loe.getQuantity());
			lie.setInvStatus(1);
			dao.addLicenseInvEntry(lie);			
		}
		
		//debug
		int id = dao.getLicenseInv(loe.getLicenseName()).getInvId(); 
		loe.setInvId(id);
		
//		loe.setInvId(dao.getLicenseInv(loe.getLicenseName()).getInvId());
		
		
		loe.setStatus(1);
		loe.setOpType("create");
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		loe.setOpDate(currentTime);
		dao.addLicenseOpEntry(loe);		
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delLicenseOpEntry(int invOpId, int opGid, String opName){
//		1. Update inv_op_id entry status to "0"
//		2. Create a new inv_op, which have same value with the deleted one, except inv_op_id, op_type, op_date, status = 0
//		3. Decrease the total quantity of inv license
		
//		remark:
//			Update invOp shouldn't change the invOpId
//			Create invOp should have new invOpId
//		
//		not completed
//		4. what if spare_quantity < 0??
//		5. the operator's gid and name should be changed
		
		dao.iavLicOpStat(invOpId);
		
		LicenseOpEntry loe = dao.getLicenseOp(invOpId);
		loe.setOpType("delete");
		loe.setOpGid(opGid);
		loe.setOpName(opName);
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		loe.setOpDate(currentTime);
		loe.setStatus(0);
		dao.addLicenseOpEntry(loe);
		
		LicenseInventoryEntry lie = dao.getLicenseInv(loe.getLicenseName());
		int invId = lie.getInvId();
		int ttlQuantity = lie.getTotalQuantity() - loe.getQuantity();
		int sprQuantity = lie.getSpareQuantity() - loe.getQuantity();
		if(sprQuantity <= 0){			
			dao.updLicInvQty(invId, ttlQuantity, sprQuantity, 0);
		}else{
			dao.updLicInvQty(invId, ttlQuantity, sprQuantity, 1);		
		}
		
	}
	
	public List<LicenseOpEntry> getLicenseOpList(){
		return dao.getLicenseOpList();
	}
	
	public List<LicenseOpEntry> getLicenseOpListAct(){
		
		return dao.getLicenseOpListAct();
	}
	
	public List<LicenseInventoryEntry> getLicenseInvList(){
		return dao.getLicenseInvList();
	}
	
	public List<LicenseInventoryEntry> getLicenseInvListAct(){
		return dao.getLicenseInvListAct();
	}
	
	public Map<Integer, String> getLicNameListAct(){
//		Get license's name whose status are active in database
		return dao.getLicNameListAct();
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void aplyLicense(Assignment assignment){
		LicenseInventoryEntry lie = dao.getLicenseInv(assignment.getInvId());
		int leftQuantity = lie.getSpareQuantity() - assignment.getQuantity();
		if(leftQuantity == 0){
			dao.updLicInvQty(lie.getInvId(), lie.getTotalQuantity(), leftQuantity, 0);
		}else{
			dao.updLicInvQty(lie.getInvId(), lie.getTotalQuantity(), leftQuantity, 1);
		}
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		assignment.setApplyDate(currentTime);
		asnDao.createAssignment(assignment);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void rlsLicense(int asnId, int releaserGid, String releaserName){
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String releaseDate = sdf.format(dt);
		asnDao.releaseAssignment(asnId, releaserGid, releaserName, releaseDate);
		Assignment asn = asnDao.getAssignment(asnId);
		LicenseInventoryEntry lie = dao.getLicenseInv(asn.getInvId());
		int ttlQuantity = lie.getTotalQuantity();
		int sprQuantity = lie.getSpareQuantity() + asn.getQuantity();
		if(sprQuantity > 0){
			dao.updLicInvQty(asn.getInvId(), ttlQuantity, sprQuantity, 1);	
		}else{
			dao.updLicInvQty(asn.getInvId(), ttlQuantity, sprQuantity, 0);
		}
	}
	
	public List<Assignment> getAssignedLicense(){
		List<Assignment> asnList = asnDao.getAssignmentsAct();
		return asnList;
	}
	
	public List<String> getLicNameList(){
		return dao.getLicNameList();
	}

	public Map<Integer,Integer> getLeftNumOfLic(){
		return dao.getLeftNumOfLic();
	}
	
	public List<Integer> getAssignmentsByHost(int hostId){
		return asnDao.getAssignmentsByHost(hostId);
	}
	
}
