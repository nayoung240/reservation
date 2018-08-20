package kr.or.connect.reservation.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.Count;
import kr.or.connect.reservation.dto.Product;

@Service
public interface ProductService {
	public static final Integer LIMIT=4;

	public int getAllCount();
	public int getCateCount(Integer categoryId);
	public List<Count> getCateCnt();	
	
	public List<Product> getAllProduct(Integer start);	
	public List<Product> getCateProduct(Integer categoryId, Integer start);

}
