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
import kr.or.connect.reservation.service.ProductService;

@RestController
public class DetailApiController {
	@Autowired
	DetailService detS;
	
	@RequestMapping(value="/api/detail" , method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> detailProductsList(
								@RequestParam(name="displayInfoId", required=false, defaultValue="0") int displayInfoId) {
		
		List<ProductImage> etImages=detS.getEtImage(displayInfoId);
		
		Map<String, Object> map = new HashMap<>();
		map.put("etImages", etImages);
		return map;
	}
}
