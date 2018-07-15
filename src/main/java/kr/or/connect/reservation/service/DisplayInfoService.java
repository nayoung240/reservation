package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.DisplayInfo;

@Service
public interface DisplayInfoService {
	public List<DisplayInfo> getDisplayInfos();
}
