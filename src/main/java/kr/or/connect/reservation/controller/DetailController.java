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
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DisplayImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductDetail;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.PromotionImg;
import kr.or.connect.reservation.service.DetailService;


@Controller
public class DetailController {
	@Autowired
	DetailService detaS;
	
	@RequestMapping(value="/detail" , method = {RequestMethod.GET, RequestMethod.POST})
	public String detail(
					@RequestParam(name="id", required=false, defaultValue="0") int id,
					ModelMap mm) {
		List<ProductDetail> product=detaS.getDetailProduct(id);
		List<ProductImage> productImage=detaS.getProductImage(id);
		int etCount=detaS.getEtCount(id);
		List<DisplayImage> displayImages=detaS.getDisplayImage(id);
		List<Comment> comment=detaS.getComments(id);
		List<CommentImage> reservationUserCommentImages=detaS.getCommentImages(id);
		
		mm.addAttribute("detailId", id);
		mm.addAttribute("product", product); 
		mm.addAttribute("productImage", productImage);
		mm.addAttribute("etCount", etCount);
		mm.addAttribute("displayImages", displayImages);
		mm.addAttribute("comment", comment);
		mm.addAttribute("commentImages", reservationUserCommentImages);
		
		return "detail";
	}
}
