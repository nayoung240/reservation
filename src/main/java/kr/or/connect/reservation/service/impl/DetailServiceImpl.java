package kr.or.connect.reservation.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CommentDao;
import kr.or.connect.reservation.dao.CommentImageDao;
import kr.or.connect.reservation.dao.DisplayImageDao;
import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dao.ProductDetailDao;
import kr.or.connect.reservation.dao.ProductImageDao;
import kr.or.connect.reservation.dao.ProductPriceDao;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DisplayImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductDetail;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.service.DetailService;

@Service
public class DetailServiceImpl implements DetailService {
	@Autowired
	ProductDetailDao prodetdao;
	@Autowired
	ProductImageDao prodidao;
	@Autowired
	DisplayImageDao disidao;
	@Autowired
	CommentDao comdao;
	@Autowired
	CommentImageDao comidao;
	@Autowired
	ProductPriceDao prodpdao;

	@Override
	@Transactional
	public List<ProductDetail> getDetailProduct(Integer displayInfoId) {
		List<ProductDetail> list=prodetdao.detailProdList(displayInfoId);
		return list;
	}

	@Override
	@Transactional
	public List<ProductImage> getProductImage(Integer displayInfoId) {
		List<ProductImage> list=prodidao.prodImageList(displayInfoId);
		return list;
	}

	@Override
	@Transactional
	public List<DisplayImage> getDisplayImage(int displayInfoId) {
		List<DisplayImage> list=disidao.displayImageList(displayInfoId);
		return list;
	}

	@Override
	@Transactional
	public List<Comment> getComments(int displayInfoId) {
		List<Comment> list=comdao.commentList(displayInfoId);
		return list;
	}
	
	@Override
	public String getAvgScore(int displayInfoId) {
		List<Comment> list=comdao.commentList(displayInfoId);
		int sum=0;
		float size=list.size();
		
		for (Comment c : list) {
			sum+=c.getScore();
        }
		
		if(sum==0) {
			return "0.0";
		}
		else {
			return String.format("%.1f", sum/size);
		}
	}
	
	@Override
	public int getCommentCnt(int displayInfoId){
		try {
			return comdao.commentCnt(displayInfoId);
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	@Transactional
	public List<CommentImage> getCommentImages(int displayInfoId) {
		List<CommentImage> list=comidao.commentImageList(displayInfoId);
		return list;
	}
	
	@Override
	@Transactional
	public List<ProductPrice> getPrices(int displayInfoId) {
		List<ProductPrice> list=prodpdao.priceList(displayInfoId);
		return list;
	}

	@Override
	@Transactional
	public List<ProductImage> getEtImage(Integer displayInfoId) {
		List<ProductImage> list=prodidao.etImageList(displayInfoId);
		return list;
	}

	@Override
	@Transactional
	public int getEtCount(Integer displayInfoId) {
		return prodidao.etImageCount(displayInfoId);
	}


	
}
