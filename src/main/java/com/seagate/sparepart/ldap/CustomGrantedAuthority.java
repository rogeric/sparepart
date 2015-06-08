package com.seagate.sparepart.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomGrantedAuthority {

	@Autowired
	private GrantedAuthorityDao gad;
	
	public String getRole(int gid){
		int roleExist = gad.ifRoleExisted(gid);
		if(roleExist > 0){
			return gad.getRole(gid);
		}else{
			return null;
		}
	}
}
