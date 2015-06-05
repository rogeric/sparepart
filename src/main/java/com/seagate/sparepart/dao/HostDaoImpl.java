package com.seagate.sparepart.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seagate.sparepart.domain.HostInvEntry;
import com.seagate.sparepart.domain.HostOpEntry;


@Repository
public class HostDaoImpl implements HostDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDateSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final String ADD_HOST_OP = "insert into host_operation (host_type, serial_number, no_of_cpu, hostname, ip, location, owner_gid, owner_name, operator_gid, operator_name, op_type, op_date, host_id, status) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	@Override
	public void addHostOp(HostOpEntry hoe) {		
		jdbcTemplate.update(ADD_HOST_OP, hoe.getHostType(), hoe.getSerialNumber(), hoe.getNoOfCpu(), hoe.getHostname(), hoe.getIp(), hoe.getLocation(), hoe.getOwnerGid(), hoe.getOwnerName(), hoe.getOperatorGid(), hoe.getOperatorName(), hoe.getOpType(), hoe.getOpDate(), hoe.getHostId(), hoe.getStatus());
	}

	private static final String GET_HOST_OP_LIST = "select host_op_id as hostOpId, host_type as hostType, serial_number as serialNumber, no_of_cpu as noOfCpu, hostname, ip, location, owner_gid as ownerGid, owner_name as ownerName, operator_gid as operatorGid, operator_name as operatorName, op_type as opType, DATE_FORMAT(op_date,'%Y-%m-%d %H:%i:%s' ) as opDate, host_id as hostId , status from host_operation";
	
	@Override
	public List<HostOpEntry> getHostOpList() {
		return jdbcTemplate.query(GET_HOST_OP_LIST, new BeanPropertyRowMapper(HostOpEntry.class));
	}

	private static final String GET_HOST_OP_LIST_ACT = "select host_op_id as hostOpId, host_type as hostType, serial_number as serialNumber, no_of_cpu as noOfCpu, hostname, ip, location, owner_gid as ownerGid, owner_name as ownerName, operator_gid as operatorGid, operator_name as operatorName, op_type as opType, DATE_FORMAT(op_date,'%Y-%m-%d %H:%i:%s' ) as opDate, host_id as hostId , status from host_operation where status = 1";
	
	@Override
	public List<HostOpEntry> getHostOpListAct() {
		return jdbcTemplate.query(GET_HOST_OP_LIST_ACT, new BeanPropertyRowMapper(HostOpEntry.class));
	}

	private static final String GET_HOST_INV_LIST_ACT = "select host_id as hostId, host_type as hostType, serial_number as serialNumber, no_of_cpu as noOfCpu, hostname, ip, location, owner_gid as ownerGid, owner_name as ownerName, status from host where status = 1";
	@Override
	public List<HostInvEntry> getHostInvListAct() {
		return jdbcTemplate.query(GET_HOST_INV_LIST_ACT, new BeanPropertyRowMapper(HostInvEntry.class));
	}
	
	private static final String GET_HOST_INV_LIST = "select host_id as hostId, host_type as hostType, serial_number as serialNumber, no_of_cpu as noOfCpu, hostname, ip, location, owner_gid as ownerGid, owner_name as ownerName, status from host";

	@Override
	public List<HostInvEntry> getHostInvList() {
		return jdbcTemplate.query(GET_HOST_INV_LIST, new BeanPropertyRowMapper(HostInvEntry.class));
	}
	
	private static final String GET_HOST_OP = "select host_op_id as hostOpId, host_type as hostType, serial_number as serialNumber, no_of_cpu as noOfCpu, hostname, ip, location, owner_gid as ownerGid, owner_name as ownerName, operator_gid as operatorGid, operator_name as operatorName, op_type as opType, DATE_FORMAT(op_date,'%Y-%m-%d %H:%i:%s' ) as opDate, host_id as hostId , status from host_operation where host_op_id = ?";
	
	@Override
	public HostOpEntry getHostOp(int hostOpId) {
		return (HostOpEntry)jdbcTemplate.queryForObject(GET_HOST_OP, new Object[] {hostOpId}, new BeanPropertyRowMapper(HostOpEntry.class));
	}

	private static final String IAV_HOST_OP = "update host_operation set status = 0 where host_op_id = ?";
	
	@Override
	public void iavHostOpStatus(int hostOpId) {
		jdbcTemplate.update(IAV_HOST_OP, hostOpId);
	}

	private static final String ADD_HOST_INV = "insert into host (host_type, serial_number, no_of_cpu, hostname, ip, location, owner_gid, owner_name, status) values (?,?,?,?,?,?,?,?,?)";
	@Override
	public void addHostInv(HostInvEntry hie) {
		jdbcTemplate.update(ADD_HOST_INV, hie.getHostType(), hie.getSerialNumber(), hie.getNoOfCpu(), hie.getHostname(), hie.getIp(), hie.getLocation(),hie.getOwnerGid(), hie.getOwnerName(), hie.getStatus());
	}

	private static final String  GET_HOST_INV_ACT = "select host_id as hostId, host_type as hostType, serial_number as serialNumber, no_of_cpu as noOfCpu, hostname, ip, location, owner_gid as ownerGid, owner_name as ownerName, status from host where hostname = ? and status = 1";

	@Override
	public HostInvEntry getHostInvAct(String hostname) {
		return (HostInvEntry)jdbcTemplate.queryForObject(GET_HOST_INV_ACT, new Object[] {hostname}, new BeanPropertyRowMapper(HostInvEntry.class));
	}
	
	private static final String IAV_HOST_INV = "update host set status = 0 where host_id = ?";

	@Override
	public void iavHostInvStatus(int hostId) {
		jdbcTemplate.update(IAV_HOST_INV, hostId);
	}


	@Override
	public Map<Integer,String> getHostnameListAct() {
		List<HostInvEntry> hieList = this.getHostInvListAct();
		Map<Integer,String> hostInfo = new TreeMap<Integer, String>();
					
		for(HostInvEntry hie : hieList){
			hostInfo.put(hie.getHostId(), hie.getHostname());
		}
		List<Map.Entry<Integer, String>> mappingList = new ArrayList<Map.Entry<Integer, String>>(hostInfo.entrySet());
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
	

}
