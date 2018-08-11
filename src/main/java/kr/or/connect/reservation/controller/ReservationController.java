package kr.or.connect.reservation.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotions;
import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.service.DisplayInfoService;
import kr.or.connect.reservation.service.PromotionsService;
import kr.or.connect.reservation.service.ProductService;


@Controller
public class ReservationController {
	@Autowired
	CategoryService cateS;
	@Autowired
	ProductService prodS;
	@Autowired
	DisplayInfoService dispS;
	@Autowired
	PromotionsService promS;
	
	@RequestMapping(value="/main" , method = {RequestMethod.GET, RequestMethod.POST})
	public String products(
					@RequestParam(name="categoryId", required=false, defaultValue="1") int categoryId,
					@RequestParam(name="start", required=false, defaultValue="0") int start,
					ModelMap mm) {
		
		List<Category> categoryList=cateS.getCategories();

		//List<Product> productAllList=prodS.getAllProducts(start);                                                                                             
		//List<Product> productAllList=prodS.getAllProducts();                     
	
		//List<Product> pagingList=prodS.getProduct(categoryId, start);
		//List<Product> joinList=prodS.getJoinProducts(categoryId);
		
		List<DisplayInfo> displayList=dispS.getDisplayInfos();
		
	
		//개수
		int allCnt=prodS.getAllCount();		
		int cateCnt=prodS.getCateCount(categoryId);
		
		//product
		List<Product> allProdList=prodS.getAllProduct(start);

		List<Map<String, Object>> cateProdList=prodS.getCateProduct(categoryId, start);

		//promotion
		List<Promotions> allPromList=promS.getPromotionsImages();
		
		//카테고리
		mm.addAttribute("categoryList", categoryList);	
		
		//개수
		mm.addAttribute("allCnt", allCnt);
		mm.addAttribute("cateCnt", cateCnt);
		
		//product
		mm.addAttribute("allProdList", allProdList);
		mm.addAttribute("cateProdList", cateProdList);
		
		//promotion
		mm.addAttribute("allPromList", allPromList);
		
		
		mm.addAttribute("displayList", displayList);
		
		return "main";
	}
	
}
