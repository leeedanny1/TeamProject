package com.springboot.jcmarket.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.jcmarket.config.auth.PrincipalDetails;
import com.springboot.jcmarket.web.dto.chat.ChatDto;
import com.springboot.jcmarket.web.service.ChatService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ChatController {
	private final ChatService chatService;


	@GetMapping("/chat")
	public ModelAndView chatList(@AuthenticationPrincipal PrincipalDetails prDetails) {
		ModelAndView mav = new ModelAndView("chat/chat");
		mav.addObject("chatList", chatService.getChatListAll(prDetails.getUser().getId()));
		
		return mav;
	}
	@GetMapping("/chatting/{item_code}/{buyer_id}/{seller_id}")
	public ModelAndView chattingList(@AuthenticationPrincipal PrincipalDetails prDetails, @PathVariable int item_code,@PathVariable int buyer_id ,@PathVariable int seller_id, ChatDto chatdto) {
		ModelAndView mav = new ModelAndView("chat/chat");
		System.out.println(chatdto);
		if(prDetails.getUser().getId()==buyer_id){
			mav.addObject("chatmsg", chatService.getChatting( seller_id, prDetails.getUser().getId(),item_code));
			
		}else if (prDetails.getUser().getId()==seller_id ) {
			mav.addObject("chatmsg", chatService.getChatting(prDetails.getUser().getId(), buyer_id, item_code));
			
		}
		mav.addObject("chatList", chatService.getChatListAll(prDetails.getUser().getId()));
		System.out.println(prDetails);
		return mav;
	}
	@ResponseBody
	@PostMapping("/chat-insert")
	public String chat_insert(@RequestBody ChatDto chatdto) {
		System.out.println(chatdto);
		
		return Integer.toString(chatService.Chattinginput(chatdto.getSeller_id(),chatdto.getBuyer_id(),chatdto.getItem_code(),chatdto.getWriter_nickname(),chatdto.getChat_content()));
	}
}
