package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

import java.util.List;

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
	public List<DisplayInfo> displayInfoList(){
		return jdbc.query(DISPLAY_INFO, display);
	}
	
	
}
