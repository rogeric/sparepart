package com.seagate.sparepart.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seagate.sparepart.domain.LicenseInventoryEntry;
import com.seagate.sparepart.domain.LicenseOpEntry;

@Repository
public class LicenseDAOImpl implements LicenseDAO {


	private JdbcTemplate jdbcTemplate;
	private static final String INSERT_LIC_OP = 
			"insert into inventory_operation (license_name, license_key, license_type, from_site, quantity, total_price, expire_date, operator_gid, operator_name, op_type, op_date, inv_id, status) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_LIC_OP_BY_ID = "select inv_op_id as invOpId, license_name as licenseName, license_key as licenseKey, license_type as licenseType, from_site as fromSite, quantity, total_price as totalPrice, expire_date as expireDate, operator_gid as opGid, operator_name as opName, op_type as opType, DATE_FORMAT(op_date,'%Y-%m-%d %H:%i:%s' ) as opDate, inv_id as invId, status from inventory_operation where inv_op_id = ?";
	private static final String GET_LIC_OP_LIST = "select inv_op_id as invOpId, license_name as licenseName, license_key as licenseKey, license_type as licenseType, from_site as fromSite, quantity, total_price as totalPrice, expire_date as expireDate, operator_gid as opGid, operator_name as opName, op_type as opType, DATE_FORMAT(op_date,'%Y-%m-%d %H:%i:%s' ) as opDate, inv_id as invId, status from inventory_operation";
	private static final String GET_LIC_OP_LIST_ACT = "select inv_op_id as invOpId, license_name as licenseName, license_key as licenseKey, license_type as licenseType, from_site as fromSite, quantity, total_price as totalPrice, expire_date as expireDate, operator_gid as opGid, operator_name as opName, op_type as opType, DATE_FORMAT(op_date,'%Y-%m-%d %H:%i:%s' ) as opDate, inv_id as invId, status from inventory_operation where status = 1";
	

	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	@Override
	public void addLicenseOpEntry(LicenseOpEntry loe) {
		// TODO Auto-generated method stub
		
		jdbcTemplate.update(INSERT_LIC_OP, loe.getLicenseName(), loe.getLicenseKey(), loe.getLicenseType(), loe.getFromSite(), loe.getQuantity(), loe.getTotalPrice(), loe.getExpireDate(), loe.getOpGid(), loe.getOpName(), loe.getOpType(), loe.getOpDate(), loe.getInvId(), loe.getStatus());
	}

	
	@Override
	public LicenseOpEntry getLicenseOp(int invOpId) {
		// TODO Auto-generated method stub
		return (LicenseOpEntry)jdbcTemplate.queryForObject(GET_LIC_OP_BY_ID, new Object[] { invOpId }, new BeanPropertyRowMapper(LicenseOpEntry.class));
	}

	
	@Override
	public List<LicenseOpEntry> getLicenseOpList() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_LIC_OP_LIST, new BeanPropertyRowMapper(LicenseOpEntry.class));
	}


	@Override
	public List<LicenseOpEntry> getLicenseOpListAct() {
		// TODO Auto-generated method stub
		List<LicenseOpEntry> list = jdbcTemplate.query(GET_LIC_OP_LIST_ACT, new BeanPropertyRowMapper(LicenseOpEntry.class));
		return list;
	}

	private static final String IAV_LIC_OP = "update inventory_operation set status = 0 where inv_op_id = ?";
	@Override
	public void iavLicOpStat(int invOpId) {
		jdbcTemplate.update(IAV_LIC_OP, invOpId);
	}

	// Operations on license inventory
	
	private static final String INSERT_LIC_INV = 
			"insert into inventory (license_name, license_key, license_type, total_quantity, spare_quantity, inv_status) values (?,?,?,?,?,?)";
	
	@Override
	public void addLicenseInvEntry(LicenseInventoryEntry lie) {
		jdbcTemplate.update(INSERT_LIC_INV, lie.getLicenseName(), lie.getLicenseKey(), lie.getLicenseType(), lie.getTotalQuantity(), lie.getSpareQuantity(), lie.getInvStatus());

	}

	private static final String GET_LIC_INV_BY_NAME = "select inv_id as invId, license_name as licenseName, license_Key as licenseKey, license_type as licenseType, total_quantity as totalQuantity, spare_quantity as spareQuantity, inv_status as invStatus from inventory where license_name = ?";
	@Override
	public LicenseInventoryEntry getLicenseInv(String licenseName) {
		// TODO Auto-generated method stub
		return (LicenseInventoryEntry)jdbcTemplate.queryForObject(GET_LIC_INV_BY_NAME, new Object[] { licenseName }, new BeanPropertyRowMapper(LicenseInventoryEntry.class));
	}


	private static final String UPD_LIC_INV_QTY = "update inventory set total_quantity = ?, spare_quantity = ?, inv_status = ? where inv_id = ?";
	@Override
	public void updLicInvQty(int invId, int ttlQuantity, int sprQuantity, int invStatus) {
		jdbcTemplate.update(UPD_LIC_INV_QTY, ttlQuantity, sprQuantity, invStatus, invId);
	}

	

	private static final String CNT_LIC_INV = "select count(*) from inventory where license_name = ?";
	@Override
	public int cntLicenseInvEntry(String licenseName) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(CNT_LIC_INV, Integer.class, licenseName).intValue();
	}

	
	private static final String GET_LIC_INV_BY_ID = "select inv_id as invId, license_name as licenseName, license_Key as licenseKey, license_type as licenseType, total_quantity as totalQuantity, spare_quantity as spareQuantity, inv_status as invStatus from inventory where inv_id = ?";
	@Override
	public LicenseInventoryEntry getLicenseInv(int invId) {
		// TODO Auto-generated method stub
		return (LicenseInventoryEntry)jdbcTemplate.queryForObject(GET_LIC_INV_BY_ID, new Object[] {invId}, new BeanPropertyRowMapper(LicenseInventoryEntry.class));
	}	
	
	private static final String GET_LIC_INV_LIST_ALL = "SELECT inv_id as invId, license_name as licenseName, license_Key as licenseKey, license_type as licenseType, total_quantity as totalQuantity, spare_quantity as spareQuantity, inv_status as invStatus FROM INVENTORY";
	@Override
	public List<LicenseInventoryEntry> getLicenseInvList() {
		// TODO Auto-generated method stub
		List<LicenseInventoryEntry> licenses = jdbcTemplate.query(GET_LIC_INV_LIST_ALL, new BeanPropertyRowMapper(LicenseInventoryEntry.class));		
		return licenses;
	}

	private static final String GET_LIC_INV_LIST_ACT = "select inv_id as invId, license_name as licenseName, license_Key as licenseKey, license_type as licenseType, total_quantity as totalQuantity, spare_quantity as spareQuantity, inv_status as invStatus from inventory where inv_status = 1";

	@Override
	public List<LicenseInventoryEntry> getLicenseInvListAct() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_LIC_INV_LIST_ACT, new BeanPropertyRowMapper(LicenseInventoryEntry.class));
	}


	@Override
	public Map<Integer, String> getLicNameListAct() {
		// Get Map for inv_id and licenseName
		List<LicenseInventoryEntry> licenses = jdbcTemplate.query(GET_LIC_INV_LIST_ACT, new BeanPropertyRowMapper(LicenseInventoryEntry.class));
		Map<Integer, String> licenseInfo = new HashMap();
		for(LicenseInventoryEntry lie : licenses){
			licenseInfo.put(lie.getInvId(), lie.getLicenseName());
		}
		
		List<Map.Entry<Integer, String>> mappingList = new ArrayList<Map.Entry<Integer, String>>(licenseInfo.entrySet());
		Collections.sort(mappingList, new Comparator<Map.Entry<Integer,String>>(){
			public int compare(Map.Entry<Integer,String> mapping1, Map.Entry<Integer,String> mapping2){
				return mapping1.getValue().toLowerCase().compareTo(mapping2.getValue().toLowerCase());
			}			
		});		
		
		Map<Integer, String> sortedMap = new LinkedHashMap<Integer, String>();
		for (Iterator<Map.Entry<Integer, String>> it = mappingList.iterator(); it.hasNext();) {
			Map.Entry<Integer, String> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}


	private static final String GET_LIC_NAME_LIST = "select license_name from inventory";
	@Override
	public List<String> getLicNameList() {
		List<String> licenseNameList = jdbcTemplate.queryForList(GET_LIC_NAME_LIST, String.class);
		return licenseNameList;
	}

	
	@Override
	public Map<Integer, Integer> getLeftNumOfLic() {
		List<LicenseInventoryEntry> licenses = jdbcTemplate.query(GET_LIC_INV_LIST_ACT, new BeanPropertyRowMapper(LicenseInventoryEntry.class));
		Map<Integer,Integer> leftNum = new HashMap();
		for(LicenseInventoryEntry lie : licenses){
			leftNum.put(lie.getInvId(), lie.getSpareQuantity());
		}
		return leftNum;
	}
	


	



}
