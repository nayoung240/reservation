package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DisplayImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductDetail;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.service.DetailService;

@RestController
public class DetailApiController {
	@Autowired
	DetailService detaS;
	
	@RequestMapping(value="/img/et" , method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> etImgList(
								@RequestParam(name="displayInfoId", required=false, defaultValue="1") int id) {
		
		List<ProductImage> etImages=detaS.getEtImage(id);
		List<ProductImage> productImage=detaS.getProductImage(id);
		List<ProductDetail> product=detaS.getDetailProduct(id);
		
		Map<String, Object> map = new HashMap<>();
		map.put("etImages", etImages);
		map.put("productImage", productImage);
		map.put("product", product); 
		return map;
	}
	
	@RequestMapping(value="/api/dproducts/{displayInfoId}" , method = {RequestMethod.GET})
	public Map<String, Object> detailProductsList(@PathVariable(name="displayInfoId") int displayInfoId) {
		
		List<ProductDetail> product=detaS.getDetailProduct(displayInfoId);
		List<ProductImage> productImages=detaS.getProductImage(displayInfoId);
		List<DisplayImage> displayImages=detaS.getDisplayImage(displayInfoId);
		List<Comment> comment=detaS.getComments(displayInfoId);
		List<CommentImage> reservationUserCommentImages=detaS.getCommentImages(displayInfoId);
		List<ProductPrice> productPrices=detaS.getPrices(displayInfoId);
		
		Map<String, Object> map = new HashMap<>();
		map.put("product", product);
		map.put("productImages", productImages);
		map.put("displayImages", displayImages);
		map.put("comment", comment);
		map.put("reservationUserCommentImages", reservationUserCommentImages);
		map.put("avgScore", 3.0);
		map.put("productPrices", productPrices);
		return map;
	}
}
