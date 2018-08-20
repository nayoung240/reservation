package kr.or.connect.reservation.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Count;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao proddao;
	
	@Override
	public int getAllCount() {
		return proddao.allCount();
	}

	@Override
	public int getCateCount(Integer categoryId) {
		return proddao.cateCount(categoryId);
	}
	
	@Override
	public List<Count> getCateCnt() {
		return proddao.cateCntList();
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
