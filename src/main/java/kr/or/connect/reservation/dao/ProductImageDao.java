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
import kr.or.connect.reservation.dto.ProductImage;

@Repository
public class ProductImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public ProductImageDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
/* 데이터 삽입 시 필요한 구문
  		this.insertAction=new SimpleJdbcInsert(dataSource)
						.withTableName("product")
						.usingGeneratedKeyColumns("id");*/
	}

	//pi.product_id, pi.id, pi.type, f.id, f.file_name, f.save_file_name, 
	//f.content_type, f.delete_flag, f.create_date, f.modify_date 
	public List<ProductImage> prodImageList(Integer displayInfoId){
		Map<String, Integer> params=new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		return jdbc.query(DETAIL_PRODUCT_IMAGES, params, new RowMapper<ProductImage>() {

			@Override
			public ProductImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductImage p = new ProductImage();
				p.setProductId(rs.getInt(1));
				p.setProductImageId(rs.getInt(2));
				p.setType(rs.getString(3));
				p.setFileInfoId(rs.getInt(4));
				p.setFileName(rs.getString(5));
				p.setSaveFileName(rs.getString(6));
				p.setContentType(rs.getString(7));
				p.setDeleteFlag(rs.getInt(8));
				p.setCreateDate(rs.getDate(9));
				p.setModifyDate(rs.getDate(10));
				return p;
			}
		});
	}
}
