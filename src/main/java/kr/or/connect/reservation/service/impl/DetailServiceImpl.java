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
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DisplayImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductDetail;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.service.DetailService;
import kr.or.connect.reservation.service.ProductService;

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
	@Transactional
	public List<CommentImage> getCommentImages(int displayInfoId) {
		List<CommentImage> list=comidao.commentImageList(displayInfoId);
		return list;
	}
}
