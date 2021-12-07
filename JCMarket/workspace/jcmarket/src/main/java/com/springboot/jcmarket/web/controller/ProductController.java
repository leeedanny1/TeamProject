package com.springboot.jcmarket.web.controller;

import java.util.Date;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.jcmarket.config.auth.PrincipalDetails;
import com.springboot.jcmarket.web.dto.product.ProductLikeDto;
import com.springboot.jcmarket.web.service.productService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/items")
@Controller
public class ProductController {
	
	private final productService productService;

//	hot-items 리스트
	@GetMapping("/hot/{page_number}")
	public ModelAndView hotProduct(@PathVariable int page_number) {
		ModelAndView mav = new ModelAndView("product/hot_product");
		mav.addObject("productList", productService.getHotProductList(page_number));
		mav.addObject("productBean", productService.getProductBean());
		return mav;
	}

//	new-items 리스트
	@GetMapping("/new/{page_number}")
	public ModelAndView newProduct(@PathVariable int page_number) {
		ModelAndView mav = new ModelAndView("product/new_product");
		mav.addObject("productList", productService.getNewProductList(page_number));
		mav.addObject("productBean", productService.getProductBean());
		return mav;
	}
	
	
	
//	아이템 디페일 페이지
	@GetMapping("/{item_code}")
	public ModelAndView productDtl(@PathVariable int item_code) {
		ModelAndView mav = new ModelAndView("product/product_dtl");
		mav.addObject("item", productService.getItemDtl(item_code));
		return mav;
	}

	
	
//	물건 판매 연결
	@GetMapping("/sale")
	public String sale(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		if(principalDetails == null) {
			return "/sign-in-select";
		} else {
			Date date = new Date();
			model.addAttribute("now", date);
			
			return "product/product_insert";
		}
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
        mav.addObject("items",  productService.getProduct(productLikeDto));
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
	
	@GetMapping("/search/{search_content}")
	public ModelAndView searchProduct(@PathVariable String search_content) {
		System.out.println(search_content);
		ModelAndView mav = new ModelAndView("search/search"); 
		mav.addObject("products" , productService.searchProduct(search_content));
		mav.addObject("searchValue", search_content);
		return mav;
	}
	

}