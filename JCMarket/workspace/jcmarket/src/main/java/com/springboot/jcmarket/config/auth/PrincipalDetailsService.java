package com.springboot.jcmarket.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.user.User;
import com.springboot.jcmarket.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {
private final UserRepository userrepository;
	@Override
	public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
		User userEntity = userrepository.getUser(user_id);

		if(userEntity==null) {
			return null;
		}else {
			UserDetails principaldetails = new PrincipalDetails(userEntity);			
			return principaldetails;
		}
	}
}
