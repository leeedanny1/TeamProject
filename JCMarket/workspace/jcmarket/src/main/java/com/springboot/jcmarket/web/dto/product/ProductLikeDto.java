package com.springboot.jcmarket.web.dto.product;


import com.springboot.jcmarket.domain.product.Product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductLikeDto {
    
	private int id;
	private int user_id;
	private int item_code;
	private int like_count;
	private int like_result;
	private String create_date;
	
	public Product toEntity() {
		  return Product.builder()
					
					.user_id(user_id)
					.item_code(item_code)
					.like_count(like_count)
					.create_date(create_date)
					.build(); 
	     
	}
}
