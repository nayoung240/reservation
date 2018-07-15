package kr.or.connect.reservation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.service.DisplayInfoService;
import kr.or.connect.reservation.service.ProductService;


@Controller
public class ReservationController {
	@Autowired
	CategoryService cateS;
	ProductService prodS;
	DisplayInfoService dispS;
	
	@GetMapping(path="/main")
	public String main(	@RequestParam(name="category_id", required=false, defaultValue="1") int category_id, 
					@RequestParam(name="start", required=false, defaultValue="0") int start,
					ModelMap mm) {
		
		List<Category> categoryList=cateS.getCategories();
		//List<Product> productList=prodS.getProducts();                                                                                             
		//List<DisplayInfo> displayList=dispS.getDisplayInfos(product_id);
		//List<Promotion> promotionList=rs.getPromotions();
		
		int allCnt=prodS.getAllCount();
		
		//페이징
		List<Product> list=prodS.getProduct(category_id, start);
		int cnt=prodS.getCateCount(category_id);  
		int pageCnt=cnt/ProductService.LIMIT;
		if(cnt%ProductService.LIMIT>0) {
			pageCnt++;
		}
		List<Integer> pageStartList=new ArrayList<>();
		for(int i=0; i<pageCnt; i++) {
			pageStartList.add(i*ProductService.LIMIT);
		}
		
		mm.addAttribute("categoryList", categoryList);
		
		//mm.addAttribute("allCount", allCount);
		//mm.addAttribute("cateCount", cateCount);

/*		mm.addAttribute("productList", productList);
		mm.addAttribute("promotionList", promotionList);
*/		
		
		mm.addAttribute("allCount", allCnt);
		mm.addAttribute("list", list);
		mm.addAttribute("count", cnt);
		mm.addAttribute("pageStartList", pageStartList);
		
		//mm.addAttribute("displayList", displayList);
		return "main";
	}
}
