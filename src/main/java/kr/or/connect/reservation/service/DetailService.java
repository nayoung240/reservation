package kr.or.connect.reservation.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DisplayImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductDetail;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;

@Service
public interface DetailService {
	public static final Integer LIMIT=4;
	public List<ProductDetail> getDetailProduct(Integer displayInfoId);
	public List<ProductImage> getProductImage(Integer displayInfoId);
	public List<ProductImage> getEtImage(Integer displayInfoId);
	public int getEtCount(Integer displayInfoId);
	
	public List<DisplayImage> getDisplayImage(int displayInfoId);
	
	public List<Comment> getComments(int displayInfoId);
	public String getAvgScore(int displayInfoId);
	public int getCommentCnt(int displayInfoId);
	public List<CommentImage> getCommentImages(int displayInfoId);
	
	public List<ProductPrice> getPrices(int displayInfoId);
}
