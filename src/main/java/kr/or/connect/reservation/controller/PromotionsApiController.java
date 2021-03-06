package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.MainService;

@RestController
public class PromotionsApiController {
	@Autowired
	MainService mainS;
	
	@RequestMapping(value="/api/promotions" , method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> promotionList() {
		
		List<Promotion> promList=mainS.getPromotions();
		
		Map<String, Object> map = new HashMap<>();
		map.put("promList", promList);
		
		return map;
	}
}
