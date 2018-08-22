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

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.service.ProductService;

@RestController
public class CategoryApiController {
	@Autowired
	CategoryService cateS;

	@RequestMapping(value="/api/categories" , method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> productsList() {
		
		List<Category> cateList=cateS.getCategoriesApi();
		
		Map<String, Object> map = new HashMap<>();
		map.put("cateList", cateList);
		
		return map;
	}
}
