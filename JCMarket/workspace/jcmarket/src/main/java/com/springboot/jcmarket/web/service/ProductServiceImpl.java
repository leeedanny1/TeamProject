package com.springboot.jcmarket.web.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.jcmarket.domain.product.Product;
import com.springboot.jcmarket.domain.product.ProductRepository;
import com.springboot.jcmarket.web.beans.FileBean;
import com.springboot.jcmarket.web.beans.ProductBean;
import com.springboot.jcmarket.web.dto.product.ProductDto;
import com.springboot.jcmarket.web.dto.product.ProductInsertDto;
import com.springboot.jcmarket.web.dto.product.ProductLikeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    
    private final ServletContext context;
    
    private ProductBean productBean;
    private List<Product> productListAll;
    private List<Product> productList;
    
    ProductDto productDto = new ProductDto();
    Product product = new Product();
    
    
//  상품목록 가져오기
    // 빈
    @Override
    public void setProductBean(int pageNumber) {
    	productBean = new ProductBean();
    	
		productBean.setNoticeTotalCount(productListAll.size());
		productBean.setPageNumber(pageNumber);
		productBean.setStartIndex();
		productBean.setEndIndex();
		productBean.setTotalPage();
		productBean.setStartPage();
		productBean.setEndPage();
    }
    
    @Override
    public ProductBean getProductBean() {
    	return productBean;
    }
    
    // 페이지넘버
    @Override
    public int parseIntPageNumber(int pageNumber) {
    	return pageNumber;
    }

//  인기상품
    // 모든 상품목록 갸져옴
    @Override
    public List<Product> getHotProductListAll() {
    	return productRepository.getHotProductListAll();
    }
    
    //원하는 갯수만큼 노출
    @Override
    public List<Product> getHotProductList(int pageNumber) {
    	productListAll = getHotProductListAll();
    	productList = new ArrayList<Product>();
    	
    	setProductBean(pageNumber);
    	
    	for (int i = productBean.getStartIndex(); i < productBean.getEndIndex() && i < productBean.getNoticeTotalCount(); i++) {
    		productList.add(productListAll.get(i));
    	}
    	return productList;
    }
    
//  최근상품
    // 모든 상품목록 갸져옴
    @Override
    public List<Product> getNewProductListAll() {
    	return productRepository.getNewProductListAll();
    }
    
    //원하는 갯수만큼 노출
    @Override
    public List<Product> getNewProductList(int pageNumber) {
    	productListAll = getNewProductListAll();
    	productList = new ArrayList<Product>();
    	
    	setProductBean(pageNumber);
    	
    	for (int i = productBean.getStartIndex(); i < productBean.getEndIndex() && i < productBean.getNoticeTotalCount(); i++) {
    		productList.add(productListAll.get(i));
    	}
    	return productList;
    }
    
    
    
//    조회수 증가
    @Override
    public void plusItemCount(int item_code) {
    	productRepository.plusItemCount(item_code);
    }
    
    
    
//    디테일 페이지
    @Override
    public Product getItemDtl(int item_code, int user_id) {
    	plusItemCount(item_code);
    	return productRepository.getItemDtl(item_code, user_id);
    }
    
    
//    파일
    // 파일등록
    @Override
    public ProductDto fileUpload(ProductInsertDto productInsertDto) {
    	// 초기화 한 번 해줌
    	productDto = new ProductDto();

    	// 경로지정
		String filePath = context.getRealPath("/static/itemfileupload");

		// insertDto에 있는 file을 multipartFile로..
		MultipartFile[] multipartFiles = productInsertDto.getFile();
		
		StringBuilder tempName = new StringBuilder();

		for (MultipartFile multipartFile : multipartFiles) {
			String originFile = multipartFile.getOriginalFilename();
				// 파일이름이 없다면 바로 dto 반환
				if (originFile.equals("")) {
					return productDto;
				}
//    		파일의 이름을 변경함.
//    		중복되는 파일명이 올라오면 하나는 사라지기 때문.
			String originFileExtention = originFile.substring(originFile.lastIndexOf("."));
			String tempFile = UUID.randomUUID().toString().replaceAll("-", "") + originFileExtention;

			tempName.append(tempFile);
			tempName.append(",");

//    		파일을 지정 경로에 저장
			File file = new File(filePath, tempFile);
			// 경로가 없다면 만들어주고
			if (!file.exists()) {
				file.mkdirs();
			}
			// 경로에 저장해라
			try {
				multipartFile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}

//    			마지막 파일명의 쉼표 지우기
		tempName.delete(tempName.length() - 1, tempName.length());
//    			파일이름을 저장해서 dto에 저장
		productDto.setTempFileNames(tempName.toString());
		
		System.out.println(productDto);

		return productDto;
    }
    
	// 파일 리스트 가져오기
	@Override
	public List<FileBean> getFileList(Product product) {
		// dto에 파일리스트가 없다면 null 반환
		if (product.getTempFileNames() == null || product.getTempFileNames() == null) {
			return null;
		}

		// 파일 리스트 생성
		List<FileBean> fileList = new ArrayList<FileBean>();

		// ,기준으로 나눔
		StringTokenizer tfn = new StringTokenizer(product.getTempFileNames(), ",");

		// 오리진 파일 네임이 있다면 fileBean에 넣음
		while (tfn.hasMoreTokens()) {
			FileBean fileBean = new FileBean();
			fileBean.setTempFileName(tfn.nextToken());
			fileList.add(fileBean);
		}

		return fileList;
	}
//    상품등록
    // 상품 게시글 등록
    @Override
    public int itemInsert(ProductInsertDto productInsertDto) {
    	System.out.println(productDto);
    	fileUpload(productInsertDto);
    	System.out.println(productDto);
    	
    	productDto.setItem_title(productInsertDto.getItem_title());
    	productDto.setItem_writer(productInsertDto.getItem_writer());
    	productDto.setLike_count(productInsertDto.getLike_count());
    	productDto.setItem_price(productInsertDto.getItem_price());
    	productDto.setItem_stat(productInsertDto.getItem_stat());
    	productDto.setItem_change(productInsertDto.getItem_change());
    	productDto.setItem_delivery(productInsertDto.getItem_delivery());
    	productDto.setItem_content(productInsertDto.getItem_content());
    	
    	System.out.println(productDto);
    	
    	Product product = productDto.toEntity();
    	
    	int mstResult = 0, dtlResult = 0;
    	
    	mstResult = productRepository.productMstInsert(product);
    	if(mstResult == 1) {
    		dtlResult = productRepository.productDtlInsert(product);
    	}
    	
    	return dtlResult;
    }
    
    

//    상품수정
    @Override
    public int itemUpdate(Product product) {
    	int mstResult = 0, dtlResult = 0;
    	
    	mstResult = productRepository.productMstUpdate(product);
    	if(mstResult == 1) {
    		dtlResult = productRepository.productDtlUpdate(product);
    	}
    	
    	return dtlResult;
    }
    
    
    
//    상품삭제
    @Override
    public int itemDelete(int item_code, int user_id) {
    	product = productRepository.getItemDtl(item_code, user_id);
		
		// 첨부파일 경로
		String filePath = context.getRealPath("/static/itemfileupload");
		// 첨부파일을 리스트로 불러옴
		List<FileBean> fileList = getFileList(product);
		
		if (fileList != null) {
			for (FileBean fileBean : fileList) {
				File file = new File(filePath, fileBean.getTempFileName());
				if (file.exists()) {
					file.delete();
				}
			}
		}
    	
    	return productRepository.productDelete(item_code);
    }

    
    
    
    
    
    
    
    
    
	
	@Override
	public ProductLikeDto addLike(ProductLikeDto productLikeDto) {
		Product product = productLikeDto.toEntity();
		int count_result = 0; 
		int like_result = 0;
		like_result = productRepository.addLike(product);
		
		if(like_result == 1) {
			count_result = productRepository.upLikeCount(product);
			if(count_result == 1) {
				productRepository.getLikeCount(product);
			}
		}
		productLikeDto.setLike_count(count_result);
		productLikeDto.setLike_result(like_result);
		  return productLikeDto;
	}

	@Override
	public ProductLikeDto deleteLike(ProductLikeDto productLikeDto) {
		Product product = productLikeDto.toEntity();
		int count_result = 0; 
		int like_result = 0;
		like_result = productRepository.deleteLike(product);
				
		if(like_result == 1) {
			count_result = productRepository.downLikeCount(product);
			if(count_result == 1) {
				productRepository.getLikeCount(product);
				
			}
		}
		productLikeDto.setLike_count(count_result);
		productLikeDto.setLike_result(like_result);
		  return productLikeDto; 
	}

	@Override
	public Product getProduct(ProductLikeDto productLikeDto) {
		  Product product = productLikeDto.toEntity();
		  return productRepository.getProduct(product); 
	}
     
	@Override
	public List<Product> searchProduct(String search_content) {
	      return productRepository.searchProduct(search_content);
	}

}
