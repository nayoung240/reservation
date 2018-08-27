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

import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotions;

@Repository
public class PromotionsDao {
	private NamedParameterJdbcTemplate jdbc;
	
	public PromotionsDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Promotions> promotionList(){
		return jdbc.query(SOME_PROMOTION_IMAGES, new RowMapper<Promotions>() {
			@Override
			public Promotions mapRow(ResultSet rs, int rowNum) throws SQLException {
				Promotions p=new Promotions();
				p.setSaveFileName(rs.getString(1));
				return p;
			}
		});
	}
}
