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

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DisplayImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;

@Repository
public class ProductPriceDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public ProductPriceDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
/*		this.insertAction=new SimpleJdbcInsert(dataSource)
						.withTableName("display_info")
						.usingGeneratedKeyColumns("id");*/
	}
	
	public List<ProductPrice> priceList(Integer displayInfoId){
		Map<String, Integer> params=new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		return jdbc.query(DETAIL_PRICE, params, new RowMapper<ProductPrice>() {

			@Override
			public ProductPrice mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductPrice p = new ProductPrice();
				p.setId(rs.getInt(1));
				p.setProductId(rs.getInt(2));
				p.setPriceTypeName(rs.getString(3));
				p.setPrice(rs.getInt(4));
				p.setDiscountRate(rs.getFloat(5));
				p.setCreateDate(rs.getDate(6));
				p.setModifyDate(rs.getDate(7));
				return p;
			}
		});
	}
}
