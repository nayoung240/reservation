package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

import java.util.Collections;
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

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public ProductDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
		this.insertAction=new SimpleJdbcInsert(dataSource)
						.withTableName("product")
						.usingGeneratedKeyColumns("id");
	}
	
	private RowMapper<Product> product=BeanPropertyRowMapper.newInstance(Product.class);

	public List<Product> prodAllList(Integer start, Integer limit){
		Map<String, Integer> params=new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(PRODUCT_ALL_ORIGIN, params, product);
	}
	
/*	public List<Product> prodAllList(){
		return jdbc.query(PRODUCT_ALL, product);
	}
*/	
	public int allCount() {
		return jdbc.queryForObject(ALL_COUNT, Collections.emptyMap(), Integer.class);
	}
	
	public int cateCount(Integer categoryId) {
		Map<String, Integer> params=new HashMap<>();
		params.put("categoryId", categoryId);
		return jdbc.queryForObject(CATE_COUNT, params, Integer.class);
	}
	
	public List<Product> prodInfo(Integer categoryId, Integer start, Integer limit){
		Map<String, Integer> params=new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(PAGING, params, product);
	}
}
