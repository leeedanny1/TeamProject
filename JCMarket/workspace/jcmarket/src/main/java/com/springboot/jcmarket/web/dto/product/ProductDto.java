package com.springboot.jcmarket.web.dto.product;


import com.springboot.jcmarket.domain.product.Product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
     
	private int id;
	private int user_id;
	private int item_code;
	private String create_date;
	
	public Product toEntity() {
		  return Product.builder()
					.id(id)
					.user_id(user_id)
					.item_code(item_code)
					.create_date(create_date)
					.build(); 
	     
	}
}
