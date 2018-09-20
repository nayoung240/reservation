package kr.or.connect.reservation.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductDetail;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.PromotionImg;

@Service
public interface MainService {
	//category
	public List<Category> getCategoriesApi();
	
	//product
	public static final Integer LIMIT=4;
	public int getAllCount();
	public List<Product> getAllProduct(Integer start);	
	public List<Product> getCateProduct(Integer categoryId, Integer start);
	
	//promotion
	public List<Promotion> getPromotions();
	public List<PromotionImg> getPromotionsImages();
}
