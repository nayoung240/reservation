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
import kr.or.connect.reservation.dto.DisplayImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.PromotionImg;
import kr.or.connect.reservation.service.MainService;


@Controller
public class MainController {
	@Autowired
	MainService mainS;
	
	@RequestMapping(value="/main" , method = {RequestMethod.GET, RequestMethod.POST})
	public String products(
					@RequestParam(name="start", required=false, defaultValue="0") int start,
					ModelMap mm) {
		
		List<Category> categoryList=mainS.getCategoriesApi();
		
		//개수
		int allCnt=mainS.getAllCount();		
		
		//product
		List<Product> allProdList=mainS.getAllProduct(start);

		//promotion
		List<PromotionImg> allPromList=mainS.getPromotionsImages();
		
		//카테고리
		mm.addAttribute("categoryList", categoryList);	
		
		//개수
		mm.addAttribute("allCnt", allCnt);
		
		//product
		mm.addAttribute("allProdList", allProdList);
		
		//promotion
		mm.addAttribute("allPromList", allPromList);
		
		return "main";
	}
}
