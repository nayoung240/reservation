package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;

@RestController
public class ProductsController {
	@Autowired
	ProductService prodS;

	@RequestMapping(value="/products" , method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> productsList(@RequestParam(name="categoryId", required=false, defaultValue="0") int categoryId,
											 @RequestParam(name="start", required=false, defaultValue="0") int start) {
		
		List<Product> allProdList=prodS.getAllProduct(start);
		List<Product> cateProdList=prodS.getCateProduct(categoryId, start);

		Map<String, Object> map = new HashMap<>();
		map.put("allProdList", allProdList);
		map.put("cateProdList", cateProdList);
		
		return map;
	}
}
