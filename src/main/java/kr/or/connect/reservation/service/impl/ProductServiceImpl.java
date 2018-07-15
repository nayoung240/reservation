package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao proddao;
	
	@Override
	public List<Product> getProducts() {
		List<Product> list=proddao.productList();
		return list;
	}

	@Override
	public int getAllCount() {
		return proddao.allCount();
	}

	@Override
	public int getCateCount(Integer category_id) {
		return proddao.cateCount(category_id);
	}

	@Override
	@Transactional
	public List<Product> getProduct(Integer category_id, Integer start) {
		List<Product> list=proddao.prodInfo(category_id, start, LIMIT);
		return list;
	}

}
