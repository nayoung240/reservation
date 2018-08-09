package kr.or.connect.reservation.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.Product;

@Service
public interface ProductService {
	public static final Integer LIMIT=4;
	//public List<Product> getAllProducts(Integer start);
	//public List<Product> getAllProducts();
	public int getAllCount();
	public int getCateCount(Integer categoryId);
	//public List<Product> getProduct(Integer categoryId, Integer start);
	
	//public List<Map<String, Object>> getAllProduct(Integer start);
	public List<Product> getAllProduct(Integer start);	
	public List<Map<String, Object>> getCateProduct(Integer categoryId, Integer start);
}
