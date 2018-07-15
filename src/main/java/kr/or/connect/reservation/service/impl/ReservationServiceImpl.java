package kr.or.connect.reservation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	CategoryDao rdao;
	@Autowired
	ProductDao proddao;
	@Autowired
	PromotionDao promdao;
	
	@Override
	public List<Category> getCategories(){
		List<Category> list=rdao.categoryList();
		return list;
	}

	@Override
	public List<Product> getProducts() {
		List<Product> list=proddao.productList();
		return list;
	}

	@Override
	public List<Promotion> getPromotions() {
		List<Promotion> list=promdao.promotionList();
		return list;
	}

	@Override
	public int getAllCount() {
		return proddao.allCount();
	}

	@Override
	@Transactional
	public List<Product> getProduct(Integer category_id, Integer start) {
		List<Product> list=proddao.prodInfo(category_id, start, LIMIT);
		return list;
	}

	@Override
	public int getCateCount(Integer category_id) {
		return proddao.cateCount(category_id);
	}
}
