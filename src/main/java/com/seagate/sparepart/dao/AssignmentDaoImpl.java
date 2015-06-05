package com.seagate.sparepart.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seagate.sparepart.domain.Assignment;


@Repository
public class AssignmentDaoImpl implements AssignmentDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AssignmentDaoImpl(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final String ADD_ASSIGNMENT = "insert into assignment (inv_id, license_name, host_id, hostname, quantity, applicant_gid, applicant_name, apply_date, releaser_gid, op_type) values (?,?,?,?,?,?,?,?,?,?)";
	@Override
	public void createAssignment(Assignment asn) {
		jdbcTemplate.update(ADD_ASSIGNMENT, asn.getInvId(), asn.getLicenseName(), asn.getHostId(), asn.getHostname(), asn.getQuantity(), asn.getApplicantGid(), asn.getApplicantName(), asn.getApplyDate(), asn.getReleaserGid(), "assign");
	}

	
	private static final String RELEASE_ASSIGNMENT = "update assignment set releaser_gid = ?, releaser_name = ?, release_date = ?, op_type = 'release' where asn_id = ?";
	@Override
	public void releaseAssignment(int asnId, int releaserGid, String releaserName, String releaseDate) {
		jdbcTemplate.update(RELEASE_ASSIGNMENT, releaserGid, releaserName, releaseDate, asnId);
	}

	private static final String GET_ASSIGNMENTS_ACT = "select asn_id as asnId, inv_id as invId, license_name as licenseName, host_id as hostId, hostname, quantity, applicant_gid as applicantGid, applicant_name as applicantName, DATE_FORMAT(apply_date,'%Y-%m-%d %H:%i:%s' ) as applyDate, releaser_gid as releaserGid, releaser_name as releaserName, DATE_FORMAT(release_date,'%Y-%m-%d %H:%i:%s' ) as releaseDate, op_type as opType from assignment where op_type = 'assign'";
	@Override
	public List<Assignment> getAssignmentsAct() {
		return jdbcTemplate.query(GET_ASSIGNMENTS_ACT, new BeanPropertyRowMapper(Assignment.class));		
	}

	private static final String GET_ASSIGNMENTS = "select asn_id as asnId, inv_id as invId, license_name as licenseName, host_id as hostId, hostname, quantity, applicant_gid as applicantGid, applicant_name as applicantName, DATE_FORMAT(apply_date,'%Y-%m-%d %H:%i:%s' ) as applyDate, releaser_gid as releaserGid, releaser_name as releaserName, DATE_FORMAT(release_date,'%Y-%m-%d %H:%i:%s' ) as releaseDate, op_type as opType from assignment";
	@Override
	public List<Assignment> getAssignments() {
		List<Assignment> asnList = jdbcTemplate.query(GET_ASSIGNMENTS, new BeanPropertyRowMapper(Assignment.class));
		return asnList;
	}
	
	private static final String GET_ASSIGNMENT = "select asn_id as asnId, inv_id as invId, license_name as licenseName, host_id as hostId, hostname, quantity, applicant_gid as applicantGid, applicant_name as applicantName, DATE_FORMAT(apply_date,'%Y-%m-%d %H:%i:%s' ) as applyDate, releaser_gid as releaserGid, releaser_name as releaserName, DATE_FORMAT(release_date,'%Y-%m-%d %H:%i:%s' ) as releaseDate, op_type as opType from assignment where asn_id = ?";
	@Override
	public Assignment getAssignment(int asnId) {
		return (Assignment)jdbcTemplate.queryForObject(GET_ASSIGNMENT, new Object[] { asnId }, new BeanPropertyRowMapper(Assignment.class));
	}
	
	private static final String GET_ASN_BY_HOST = "select asn_id from assignment where host_id = ? and op_type = 'assign'";
	@Override
	public List<Integer> getAssignmentsByHost(int hostOpId) {
		
		return jdbcTemplate.queryForList(GET_ASN_BY_HOST, Integer.class, hostOpId);		 
	}


}
