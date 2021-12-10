package com.springboot.jcmarket.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.jcmarket.config.auth.PrincipalDetails;
import com.springboot.jcmarket.domain.user.User;
import com.springboot.jcmarket.web.dto.auth.SignUpDto;
import com.springboot.jcmarket.web.dto.auth.findAccountDto;
import com.springboot.jcmarket.web.service.ProductService;
import com.springboot.jcmarket.web.service.SignUpService;
import com.springboot.jcmarket.web.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserService userService;
	private final SignUpService signUpService;
	private final ProductService productService;

	@GetMapping("/update")
	public String update() {
		
		return "mypage/user_update";
	}

	 
	@ResponseBody
	@PutMapping("/update")
	public String update(@RequestBody SignUpDto signUpDto , @AuthenticationPrincipal PrincipalDetails prDetails) {
		User user = signUpService.getUser(signUpDto.getUser_id());
		int update = 0;
		if (signUpDto.getUser_password() == "") {
			signUpDto.setUser_password(user.getUser_password());
		} else if (signUpDto.getUser_nickname() == "") {
			signUpDto.setUser_nickname(user.getUser_nickname());
		}
		update =userService.updateUser(signUpDto);
		if(update==1) {
			
			  prDetails.getUser().setUser_nickname(signUpDto.getUser_nickname());
			  prDetails.getUser().setUser_phone(signUpDto.getUser_phone());		
		}
		return  Integer.toString(update);
	
	}
	
	
	@GetMapping("/find-id")
	public String findId() {
		System.out.println(123);
		return "find_account/find_id";
	}
	
	@GetMapping("/find-password")
	public String findPassword() {
		return "find_account/find_password";
	}
	
	@ResponseBody
	@PostMapping("/find-id")
	public Object findId(@RequestBody findAccountDto findAccountDto) {
		System.out.println("find-id:" + findAccountDto);
	   return userService.findId(findAccountDto);
	}
	
	@ResponseBody
	@PostMapping("/find-password")
	public Object findPassword(@RequestBody findAccountDto findAccountDto) {
	   return userService.findPassword(findAccountDto);
	}
	
	@ResponseBody
	@PutMapping("/update-password")
	public String updatePassword(@RequestBody findAccountDto findAccountDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		findAccountDto.setUser_password(new BCryptPasswordEncoder().encode(findAccountDto.getUser_password()));
		 return Integer.toString(userService.updatePassword(findAccountDto));
	}
	
	//내상점
    @GetMapping("my-shop/{id}")
	public ModelAndView myShop(@PathVariable int id,  @AuthenticationPrincipal PrincipalDetails principalDetails) {
       
    	ModelAndView mav = new ModelAndView("mypage/my_shop");
    	mav.addObject("mySaleProducts", productService.getSaleProduct(id));
    	mav.addObject("mySelectProducts", productService.getSelectProduct(id));
    	mav.addObject("user_nickname", userService.getNickname(id));
		return mav;
	} 
	
	
	
	@ResponseBody
	@DeleteMapping("/withdraw")
	public String withdraw(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		System.out.println(principalDetails.getUser().getId());
		return Integer.toString(userService.withdraw(principalDetails.getUser().getId()));
	}
}
