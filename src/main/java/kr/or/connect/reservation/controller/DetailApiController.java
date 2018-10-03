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
								@RequestParam(name="displayInfoId", required=false, defaultValue="1") int dispId) {
		
		List<ProductImage> etImages=detaS.getEtImage(dispId);
		List<ProductImage> productImage=detaS.getProductImage(dispId);
		List<ProductDetail> product=detaS.getDetailProduct(dispId);
		
		Map<String, Object> map = new HashMap<>();
		map.put("etImages", etImages);
		map.put("productImage", productImage);
		map.put("product", product); 
		return map;
	}
	
	@RequestMapping(value="/api/detail-products/{displayInfoId}" , method = {RequestMethod.GET})
	public Map<String, Object> detailProductsList(@PathVariable(name="displayInfoId") int dispId) {
		
		List<ProductDetail> product=detaS.getDetailProduct(dispId);
		List<ProductImage> productImages=detaS.getProductImage(dispId);
		List<DisplayImage> displayImages=detaS.getDisplayImage(dispId);
		List<Comment> comment=detaS.getComments(dispId);
		List<CommentImage> reservationUserCommentImages=detaS.getCommentImages(dispId);
		List<ProductPrice> productPrices=detaS.getPrices(dispId);
		
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
