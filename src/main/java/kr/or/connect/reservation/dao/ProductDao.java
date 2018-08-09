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
/* 데이터 삽입 시 필요한 구문
  		this.insertAction=new SimpleJdbcInsert(dataSource)
						.withTableName("product")
						.usingGeneratedKeyColumns("id");*/
	}
	
	private RowMapper<Product> product=BeanPropertyRowMapper.newInstance(Product.class);

/*	public List<Product> prodAllList(Integer start, Integer limit){
		Map<String, Integer> params=new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(PRODUCT_ALL_ORIGIN, params, product);
	}
	*/
	
	/*public List<Product> allProdList(Integer start, Integer limit){
		Map<String, Integer> params=new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(ALL_PRODUCT, params, product);
	}*/
	
	//List of Map
	//했지만 문제가 있음
	/*public List<Map<String, Object>> allProdList(Integer start, Integer limit){
		Map<String, Integer> params=new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.queryForList(ALL_PRODUCT, params);
	}*/
	
	//join사용
	//p.id, p.category_id, p.description, p.content, d.place_name, f.save_file_name
	public List<Product> allProdList(Integer start, Integer limit){
		Map<String, Integer> params=new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(ALL_PRODUCT, params, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setCategoryId(rs.getInt(2));
				p.setDescription(rs.getString(3));
				p.setContent(rs.getString(4));
				p.setPlaceName(rs.getString(5));
				p.setSaveFileName(rs.getString(6));
				return p;
			}
		});
	}
	
	public List<Map<String, Object>> cateProdList(Integer categoryId, Integer start, Integer limit){
		Map<String, Integer> params=new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.queryForList(CATE_PRODUCT, params);
	}
	
	public int allCount() {
		return jdbc.queryForObject(ALL_COUNT, Collections.emptyMap(), Integer.class);
	}
	
	public int cateCount(Integer categoryId) {
		Map<String, Integer> params=new HashMap<>();
		params.put("categoryId", categoryId);
		return jdbc.queryForObject(CATE_COUNT, params, Integer.class);
	}
	
/*	public List<Product> prodInfo(Integer categoryId, Integer start, Integer limit){
		Map<String, Integer> params=new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(PAGING, params, product);
	}*/
}
