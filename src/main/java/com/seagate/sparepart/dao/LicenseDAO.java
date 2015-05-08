package com.seagate.sparepart.dao;

import java.util.List;

import com.seagate.sparepart.domain.LicenseInventoryEntry;
import com.seagate.sparepart.domain.LicenseOpEntry;

public interface LicenseDAO {
	
//	op on license_operation

	//addLicenseOpEntry should not contain invOpId
	public void addLicenseOpEntry(LicenseOpEntry loe);
	public LicenseOpEntry getLicenseOp(int invOpId);
	public List<LicenseOpEntry> getLicenseOpList();
	public List<LicenseOpEntry> getLicenseOpListAct();
	

	//	inactive license op entry's status, should not change the invOpId
	public void iavLicOpStat(int invOpId);
	
	
//	op on license
	public void addLicenseInvEntry(LicenseInventoryEntry lie);
	public int cntLicenseInvEntry(String licenseName);
	public LicenseInventoryEntry getLicenseInv(int invId);
	public LicenseInventoryEntry getLicenseInv(String licenseName);
	public List<LicenseInventoryEntry> getLicenseInvList();
	public List<LicenseInventoryEntry> getLicenseInvListAct();
	
	public void updLicInvQty(int invId, int ttlQuantity, int sprQuantity, int invStatus);

	
}
