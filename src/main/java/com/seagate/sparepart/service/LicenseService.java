package com.seagate.sparepart.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seagate.sparepart.dao.LicenseDAO;
import com.seagate.sparepart.domain.LicenseInventoryEntry;
import com.seagate.sparepart.domain.LicenseOpEntry;

@Service
public class LicenseService {

	private LicenseDAO dao;
	
	@Autowired
	public LicenseService(LicenseDAO dao){
		this.dao = dao;
	}

	//Actions on license_operation
	public void addLicenseOpEntry(LicenseOpEntry loe){
//		1. Create on row in inventory_operation
//		2. Decide if the license name is exist in DB "inventory"
//		3. If yes, update license total quantity and spare quantity in DB "inventory"
//		4. If no, create one new row in DB "inventory"
//		5. inv_id is get from "license", so it should update "inventory" first, then get the inv_id back to update.

//		not completed
//		6. Frontend -- Judge if loe.getQuantity() > 0
//		7. set user 'gid 'name and 'op_date in loe
//		8. use String for op_date
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
	
	public void delLicenseOpEntry(int invOpId){
//		1. Update inv_op_id entry status to "0"
//		2. Create a new inv_op, which have same value with the deleted one, except inv_op_id, op_type, op_date, status = 0
//		3. Decrease the total quantity of inv license
		
//		remark:
//			Update invOp shouldn't change the invOpId
//			Create invOp should have new invOpId
//		
//		not completed
//		4. what if spare_quantity < 0??
		
		dao.iavLicOpStat(invOpId);
		
		LicenseOpEntry loe = dao.getLicenseOp(invOpId);
		loe.setOpType("delete");
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

	public void aplyLicenseInvEntry(LicenseInventoryEntry lie){
		
	}
	
}
