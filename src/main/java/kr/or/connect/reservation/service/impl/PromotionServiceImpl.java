package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.PromotionImg;
import kr.or.connect.reservation.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {
	@Autowired
	PromotionDao pdao;
	
	@Override
	@Transactional
	public List<Promotion> getPromotions() {
		List<Promotion> list=pdao.promotionList();
		return list;
	}

	@Override
	@Transactional
	public List<PromotionImg> getPromotionsImages() {
		List<PromotionImg> list=pdao.promotionImgList();
		return list;
	}

}
