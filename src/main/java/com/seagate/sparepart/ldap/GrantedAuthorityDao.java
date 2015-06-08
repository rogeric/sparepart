package com.seagate.sparepart.ldap;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GrantedAuthorityDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final String IF_ROLE_EXISTED = "select count(*) from authority where gid = ?";
	private static final String GET_ROLE = "select role from authority where gid = ?";
	
	public int ifRoleExisted(int gid){
		return jdbcTemplate.queryForObject(IF_ROLE_EXISTED, Integer.class, gid).intValue();
	}
	
	public String getRole(int gid){
		return jdbcTemplate.queryForObject(GET_ROLE, String.class, gid);
	}
}
