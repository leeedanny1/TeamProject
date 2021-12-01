package com.springboot.jcmarket.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.jcmarket.config.auth.PrincipalDetails;
import com.springboot.jcmarket.domain.product.Product;

import com.springboot.jcmarket.web.dto.product.ProductLikeDto;

import com.springboot.jcmarket.web.service.productService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/items")
@Controller
public class ProductController {

	/*
	 * 페이지 연결
	 */
	private final productService productService;

//	hot-items 연결
	@GetMapping("/hot")
	public String hotProduct() {
		return "product/hot_product";
	}

//	new-items 연결
	@GetMapping("/new")
	public String newProduct() {
		return "product/new_product";
	}

//	물건 판매 연결
	@GetMapping("/sale")
	public String sale() {
		return "product/product_insert";
	}

//	@GetMapping("/purchase")
//	public String purchase() {
//		return "product/purchase";
//	}
	
//상품가져오기 테스트중  
	@GetMapping("/purchase/{item_code}")
	public ModelAndView getProduct(@PathVariable int item_code,  @AuthenticationPrincipal PrincipalDetails principal) {
		System.out.println("code: " + item_code);
		ProductLikeDto productLikeDto = new ProductLikeDto();
		productLikeDto.setItem_code(item_code);
		if(principal != null) {
			productLikeDto.setUser_id(principal.getUser().getId());
		}
		
		ModelAndView mav = new ModelAndView("product/purchase");
		
		mav.addObject("items", productService.getProduct(productLikeDto));
		return mav;
	}
	

	@ResponseBody
	@PostMapping("/add-like")
	public Object addLike(@RequestParam int productId, @AuthenticationPrincipal PrincipalDetails principal) {
		if(principal == null) {
			return "2";
		}
		
		System.out.println("productId: " + productId);
		ProductLikeDto productLikeDto = new ProductLikeDto();
		productLikeDto.setItem_code(productId);
	    
		productLikeDto.setUser_id(principal.getUser().getId());
		return  productService.addLike(productLikeDto);
	}

	@ResponseBody
	@DeleteMapping("/delete-like")
	public Object deleteLike(@RequestParam int productId, @AuthenticationPrincipal PrincipalDetails principal) {
		
		ProductLikeDto productLikeDto = new ProductLikeDto();
		productLikeDto.setItem_code(productId);
		productLikeDto.setUser_id(principal.getUser().getId());
		return productService.deleteLike(productLikeDto);
	}

}