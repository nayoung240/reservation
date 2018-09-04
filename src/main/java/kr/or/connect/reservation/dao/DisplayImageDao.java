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

import kr.or.connect.reservation.dto.DisplayImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;

@Repository
public class DisplayImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public DisplayImageDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
/*		this.insertAction=new SimpleJdbcInsert(dataSource)
						.withTableName("display_info")
						.usingGeneratedKeyColumns("id");*/
	}
	
	//dii.id, dii.display_info_id, dii.file_id, fi.file_name, fi.save_file_name, 
	//fi.content_type, fi.delete_flag, fi.create_date, fi.modify_date 
	public List<DisplayImage> displayImageList(Integer displayInfoId){
		Map<String, Integer> params=new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		return jdbc.query(DETAIL_DISPLAY_IMAGES, params, new RowMapper<DisplayImage>() {

			@Override
			public DisplayImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				DisplayImage p = new DisplayImage();
				p.setId(rs.getInt(1));
				p.setDisplayInfoId(rs.getInt(2));
				p.setFileId(rs.getInt(3));
				p.setFileName(rs.getString(4));
				p.setSaveFileName(rs.getString(5));
				p.setContentType(rs.getString(6));
				p.setDeleteFlag(rs.getInt(7));
				p.setCreateDate(rs.getDate(8));
				p.setModifyDate(rs.getDate(9));
				return p;
			}
		});
	}
	
}
