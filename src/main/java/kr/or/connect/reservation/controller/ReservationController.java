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
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ReservationService;


@Controller
public class ReservationController {
	@Autowired
	ReservationService rs;
	
	@GetMapping(path="/main")
	public String main(	@RequestParam(name="category_id", required=false, defaultValue="1") int category_id, 
					@RequestParam(name="start", required=false, defaultValue="0") int start,
					ModelMap mm) {
		List<Category> categoryList=rs.getCategories();
		List<Product> productList=rs.getProducts();                                                                                             
		List<Promotion> promotionList=rs.getPromotions();
		
		int allCnt=rs.getAllCount();
		
		//페이징
		List<Product> list=rs.getProduct(category_id, start);
		int cnt=rs.getCateCount(category_id);  
		int pageCnt=cnt/ReservationService.LIMIT;
		if(cnt%ReservationService.LIMIT>0) {
			pageCnt++;
		}
		List<Integer> pageStartList=new ArrayList<>();
		for(int i=0; i<pageCnt; i++) {
			pageStartList.add(i*ReservationService.LIMIT);
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
		
		return "main";
	}
}
