package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.PromotionImg;

@Repository
public class PromotionDao {
	private NamedParameterJdbcTemplate jdbc;
	
	public PromotionDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<PromotionImg> promotionImgList(){
		return jdbc.query(SOME_PROMOTION_IMAGES, new RowMapper<PromotionImg>() {
			@Override
			public PromotionImg mapRow(ResultSet rs, int rowNum) throws SQLException {
				PromotionImg p=new PromotionImg();
				p.setSaveFileName(rs.getString(1));
				return p;
			}
		});
	}
	
	public List<Promotion> promotionList(){
		return jdbc.query(API_PROMOTION, new RowMapper<Promotion>() {
			@Override
			public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException {
				Promotion p=new Promotion();
				p.setId(rs.getInt(1));
				p.setProductId(rs.getInt(2));
				p.setCategoryId(rs.getInt(3));
				p.setCategoryName(rs.getString(4));
				p.setDescription(rs.getString(5));
				p.setProductImageId(rs.getInt(6));
				return p;
			}
		});
	}
}
