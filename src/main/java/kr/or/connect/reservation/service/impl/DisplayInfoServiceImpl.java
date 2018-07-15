package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.DisplayInfoDao;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.service.DisplayInfoService;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService {
	@Autowired
	DisplayInfoDao dispdao;
	
	@Override
	public List<DisplayInfo> getDisplayInfos(Integer product_id) {
		List<DisplayInfo> list=dispdao.displayInfoList(product_id);
		return list;
	}

}
