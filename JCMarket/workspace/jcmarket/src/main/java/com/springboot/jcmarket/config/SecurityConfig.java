package com.springboot.jcmarket.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.jcmarket.config.oauth2.PrincipalOauth2UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration //IoC 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter{
   
   private final PrincipalOauth2UserService  principaloauth2userservice;
   
   @Bean
   public BCryptPasswordEncoder encoder() {
      return new BCryptPasswordEncoder();
   }
   
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable(); //csrf 비활성화         
      http.authorizeRequests()
      .antMatchers( "/user/**","/chat","/chatting/**","/items/sale","my-shop")
      .authenticated() //인증이 필요해
      .anyRequest() //antMatchers 외에 모든요청
      .permitAll() //요청이 없어도 된다(모든 권한을 부여한다.)
      .and()
       .logout()
      .logoutUrl("/logout")
      .logoutSuccessUrl("/")
      .invalidateHttpSession(false).deleteCookies("JSESSIONID")
      .and()
      .formLogin() //로그인 페이지 커스텀
      .loginPage("/sign-in-select") //get
      .usernameParameter("user_id")
      .passwordParameter("user_password")
      .loginProcessingUrl("/sign-in") //post controller를 따로 만들필요 없음(security가 자동으로 처리)
      .defaultSuccessUrl( "/")//로그인 성공시 이동할 URL
      .failureUrl("/sign-in")
      .and()
      .oauth2Login()
      .loginPage("/auth/signin")//로그인할주소
      .defaultSuccessUrl("/sign-up-social")//oauth2로그인이 성공하였을때
      .userInfoEndpoint()
      .userService(principaloauth2userservice);//서비스 
   }
}