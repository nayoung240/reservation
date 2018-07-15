package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.PROMOTION_ALL;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Promotion;

@Repository
public class PromotionDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public PromotionDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
		this.insertAction=new SimpleJdbcInsert(dataSource)
						.withTableName("promotion")
						.usingGeneratedKeyColumns("id");
	}
	
	private RowMapper<Promotion> promotion=BeanPropertyRowMapper.newInstance(Promotion.class);
	public List<Promotion> promotionList(){
		return jdbc.query(PROMOTION_ALL, promotion);
	}
}
