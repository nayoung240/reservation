package kr.or.connect.reservation.service;

import java.util.List;
import java.util.Map;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;


public interface ReservationService {
	public List<Category> getCategories();
	public List<Product> getProducts();
	public List<Promotion> getPromotions();
	//product
	public static final Integer LIMIT=4;
	public int getAllCount();
	public int getCateCount(Integer category_id);
	public List<Product> getProduct(Integer category_id, Integer start);

}
