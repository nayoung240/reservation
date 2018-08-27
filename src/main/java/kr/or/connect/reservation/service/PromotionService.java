package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.Promotions;

@Service
public interface PromotionsService {
	public List<Promotions> getPromotionsImages();
}
