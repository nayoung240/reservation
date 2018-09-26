package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductDetail;

@Repository
public class ProductDetailDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public ProductDetailDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
/* 데이터 삽입 시 필요한 구문
  		this.insertAction=new SimpleJdbcInsert(dataSource)
						.withTableName("product")
						.usingGeneratedKeyColumns("id");*/
	}
	
	public List<ProductDetail> detailProdList(Integer displayInfoId){
		Map<String, Integer> params=new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		return jdbc.query(DETAIL_PRODUCT, params, new RowMapper<ProductDetail>() {

			@Override
			public ProductDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductDetail p = new ProductDetail();
				p.setId(rs.getInt(1));
				p.setCategoryId(rs.getInt(2));
				p.setDisplayInfoId(rs.getInt(3));
				p.setName(rs.getString(4));
				p.setDescription(rs.getString(5));
				p.setContent(rs.getString(6));
				p.setEvent(rs.getString(7));
				p.setOpeningHours(rs.getString(8));
				p.setPlaceName(rs.getString(9));
				p.setPlaceLot(rs.getString(10));
				p.setPlaceStreet(rs.getString(11));
				p.setTel(rs.getString(12));
				p.setHomepage(rs.getString(13));
				p.setEmail(rs.getString(14));
				p.setCreateDate(rs.getString(15));
				p.setModifyDate(rs.getString(16));
				return p;
			}
		});
	}
}
