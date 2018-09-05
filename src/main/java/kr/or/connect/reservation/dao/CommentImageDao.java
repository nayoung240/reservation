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

@Repository
public class CommentImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public CommentImageDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
/*		this.insertAction=new SimpleJdbcInsert(dataSource)
						.withTableName("display_info")
						.usingGeneratedKeyColumns("id");*/
	}

	// ruci.id, ruci.reservation_info_id, ruci.reservation_user_comment_id, ruci.file_id, fi.file_name, 
	//fi.save_file_name, fi.content_type, fi.delete_flag, fi.create_date, fi.modify_date 
	//from reservation_user_comment_image ruci left join file_info fi on fi.id=ruci.file_id where ruci.reservation_info_id= :displayInfoId
	public List<CommentImage> commentImageList(Integer displayInfoId){
		Map<String, Integer> params=new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		return jdbc.query(DETAIL_COMMENT_IMAGES, params, new RowMapper<CommentImage>() {

			@Override
			public CommentImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				CommentImage p = new CommentImage();
				p.setId(rs.getInt(1));
				p.setReservationInfoId(rs.getInt(2));
				p.setReservationUserCommentId(rs.getInt(3));
				p.setFileId(rs.getInt(4));
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
