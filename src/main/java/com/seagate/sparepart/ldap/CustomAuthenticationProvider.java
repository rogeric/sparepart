package com.seagate.sparepart.ldap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private CustomGrantedAuthority grantedAuthority; 
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (loginService.login(name, password) != null) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            
            int gid = Integer.parseInt(name);
            if(grantedAuthority.getRole(gid) != null){
            	grantedAuths.add(new SimpleGrantedAuthority(grantedAuthority.getRole(gid)));
            }
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
            token.setDetails(loginService.login(name, password));
            return token;
        } else {
            throw new BadCredentialsException("Invalid username or password");
        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
