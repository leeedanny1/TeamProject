package com.springboot.jcmarket.config.oauth2;

import java.util.Map;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.springboot.jcmarket.config.auth.PrincipalDetails;
import com.springboot.jcmarket.config.oauth2.provider.OAuth2UserDto;
import com.springboot.jcmarket.domain.user.User;
import com.springboot.jcmarket.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

	private final UserRepository userrepository;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oauth2user=super.loadUser(userRequest);
		Map<String,Object> attributes = oauth2user.getAttributes();
		String provider = userRequest.getClientRegistration().getRegistrationId();
		String providerId=null;
		if(provider.equals("google")) {
			providerId=(String)attributes.get("sub");
		}else  if(provider.equals("naver")) {
			attributes = (Map<String, Object>) attributes.get("response");
			providerId= (String)attributes.get("id");
		}else {
			providerId=UUID.randomUUID().toString().replaceAll("-", "");
		}
		String user_id= provider+"_"+providerId;
		User userEntity = userrepository.getUser(user_id);
		if(userEntity==null) {//처음로그인한것
			OAuth2UserDto oauth2userdto= OAuth2UserDto.builder().user_id(user_id).user_password(new BCryptPasswordEncoder().encode(UUID.randomUUID().toString()))
					.user_name((String)attributes.get("user_name")).user_phone((String)attributes.get("user_phone")).user_nickname((String)attributes.get("user_nickname"))
					.role((String)attributes.get("role-user")).provider((String)attributes.get(provider)).build();
			userrepository.signUp(userEntity);
		}

		return new PrincipalDetails(userEntity,attributes);
	}

}



