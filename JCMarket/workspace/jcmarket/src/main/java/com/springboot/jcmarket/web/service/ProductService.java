package com.springboot.jcmarket.web.service;

import java.util.List;

import com.springboot.jcmarket.domain.notice.Notice;
import com.springboot.jcmarket.domain.product.Product;
import com.springboot.jcmarket.web.beans.FileBean;
import com.springboot.jcmarket.web.beans.ProductBean;
import com.springboot.jcmarket.web.dto.product.ProductDto;
import com.springboot.jcmarket.web.dto.product.ProductInsertDto;
import com.springboot.jcmarket.web.dto.product.ProductLikeDto;

public interface ProductService {
	
//	전체 상품목록 가져옴
	// 원하는 갯수만큼 담는 리스트를 위한 bean
	public void setProductBean(int pageNumber);
	public ProductBean getProductBean();
	// 페이지 넘버
	public int parseIntPageNumber(int pageNumber);
//	인기상품
	// 모든 공지사항을 가져와서
	public List<Product> getHotProductListAll();
	// 원하는 갯수만큼 노출
	public List<Product> getHotProductList(int pageNumber);
//	최근상품
	// 모든 공지사항을 가져와서
	public List<Product> getNewProductListAll();
	// 원하는 갯수만큼 노출
	public List<Product> getNewProductList(int pageNumber);
	
//	조회수 증가
	public void plusItemCount(int item_code);
	
//	디테일페이지
	public Product getItemDtl(int item_code, int user_id);
	
//	파일
	//파일업로드
	public ProductDto fileUpload(ProductInsertDto productInsertDto);
	// 파일 리스트 가져오기
	public List<FileBean> getFileList(Product product);
	// 파일삭제
	public StringBuilder deleteFileName(String[] fileNames, String[] deleteFileNames);
	
//	상품등록
	// 상품 게시글 업로드
	public int itemInsert(ProductInsertDto productInsertDto);
	
//	상품수정
	public int itemUpdate(Product product);
	
//	상품삭제
	public int itemDelete(int itme_code);
	
	
	
	
	
	
    public ProductLikeDto addLike(ProductLikeDto productLikeDto);
    public ProductLikeDto deleteLike(ProductLikeDto productLikeDto);
    public Product getProduct(ProductLikeDto productLikeDto);
    public List<Product> searchProduct(String search_content);
    public List<Product> getSaleProduct(int id);
    public List<Product> getSelectProduct(int id);
}
