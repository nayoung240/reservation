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

import kr.or.connect.reservation.dto.Count;
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
				p.setFileId(rs.getInt(6));
				p.setSaveFileName(rs.getString(7));
				return p;
			}
		});
	}
	
	public List<Product> cateProdList(Integer categoryId, Integer start, Integer limit){
		Map<String, Integer> params=new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(CATE_PRODUCT, params, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setCategoryId(rs.getInt(2));
				p.setDescription(rs.getString(3));
				p.setContent(rs.getString(4));
				p.setPlaceName(rs.getString(5));
				p.setFileId(rs.getInt(6));
				p.setSaveFileName(rs.getString(7));
				return p;
			}
		});
	}
	
	public int allCount() {
		return jdbc.queryForObject(ALL_COUNT, Collections.emptyMap(), Integer.class);
	}
	
	public int cateCount(Integer categoryId) {
		Map<String, Integer> params=new HashMap<>();
		params.put("categoryId", categoryId);
		return jdbc.queryForObject(CATE_COUNT, params, Integer.class);
	}
	

	public List<Count> cateCntList(){
		return jdbc.query(CATE_CNT, new RowMapper<Count>() {

			@Override
			public Count mapRow(ResultSet rs, int rowNum) throws SQLException {
				Count c=new Count();
				c.setCateCnt(rs.getInt(1));
				return c;
			}
		});
	}

}
