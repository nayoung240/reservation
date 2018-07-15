package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.Product;

@Service
public interface ProductService {
	public List<Product> getProducts();
	public static final Integer LIMIT=4;
	public int getAllCount();
	public int getCateCount(Integer category_id);
	public List<Product> getProduct(Integer category_id, Integer start);
}
