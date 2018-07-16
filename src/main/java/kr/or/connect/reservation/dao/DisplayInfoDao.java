package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.Product;

@Repository
public class DisplayInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
		this.insertAction=new SimpleJdbcInsert(dataSource)
						.withTableName("display_info")
						.usingGeneratedKeyColumns("id");
	}
	
	private RowMapper<DisplayInfo> display=BeanPropertyRowMapper.newInstance(DisplayInfo.class);
	public List<DisplayInfo> displayInfoList(Integer product_id, Integer start, Integer limit){
		Map<String, Integer> params=new HashMap<>();
		params.put("product_id", product_id);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(DISPLAY_INFO, params, display);
	}
	
	
}
