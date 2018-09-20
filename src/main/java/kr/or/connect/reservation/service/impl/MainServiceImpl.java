package kr.or.connect.reservation.service.impl;

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
import kr.or.connect.reservation.dto.ProductDetail;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.PromotionImg;
import kr.or.connect.reservation.service.MainService;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	CategoryDao catedao;
	@Autowired
	PromotionDao promdao;
	@Autowired
	ProductDao proddao;
	
	//category
	@Override
	public List<Category> getCategoriesApi() {
		List<Category> list=catedao.categoryList();
		return list;
	}
	
	//promotion
	@Override
	@Transactional
	public List<Promotion> getPromotions() {
		List<Promotion> list=promdao.promotionList();
		return list;
	}

	@Override
	@Transactional
	public List<PromotionImg> getPromotionsImages() {
		List<PromotionImg> list=promdao.promotionImgList();
		return list;
	}
	
	//product
	@Override
	public int getAllCount() {
		return proddao.allCount();
	}

	@Override
	@Transactional
	public List<Product> getAllProduct(Integer start) {
		List<Product> list=proddao.allProdList(start, LIMIT);
		return list;
	}
	
	@Override
	@Transactional
	public List<Product> getCateProduct(Integer categoryId, Integer start) {
		List<Product> list=proddao.cateProdList(categoryId, start, LIMIT);
		return list;
	}
}
