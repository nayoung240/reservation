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
	@Autowired
	ProductService prodS;
	@Autowired
	DisplayInfoService dispS;
	
	@GetMapping(path="/main")
	public String main(	@RequestParam(name="category_id", required=false, defaultValue="1") int category_id,
						@RequestParam(name="product_id", required=false, defaultValue="1") int product_id,
					@RequestParam(name="start", required=false, defaultValue="0") int start,
					ModelMap mm) {
		
		List<Category> categoryList=cateS.getCategories();
		
		List<Product> productList=prodS.getProducts();                                                                                             
		List<Product> pagingList=prodS.getProduct(category_id, start);
		
		List<DisplayInfo> displayList=dispS.getDisplayInfos();
		
		int allCnt=prodS.getAllCount();
		


		//페이징 번호
/*		int cnt=prodS.getCateCount(category_id);  
		int pageCnt=cnt/ProductService.LIMIT;
		if(cnt%ProductService.LIMIT>0) {
			pageCnt++;
		}
		List<Integer> pageStartList=new ArrayList<>();
		for(int i=0; i<pageCnt; i++) {
			pageStartList.add(i*ProductService.LIMIT);
		}*/
		
		mm.addAttribute("categoryList", categoryList);

		mm.addAttribute("productList", productList);

		//	mm.addAttribute("promotionList", promotionList);
		
		mm.addAttribute("allCount", allCnt);
		mm.addAttribute("pagingList", pagingList);
/*		mm.addAttribute("count", cnt);
		mm.addAttribute("pageStartList", pageStartList);*/
		
		mm.addAttribute("displayList", displayList);
		return "main";
	}
}
