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

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DisplayImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;

@Repository
public class CommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public CommentDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
/*		this.insertAction=new SimpleJdbcInsert(dataSource)
						.withTableName("display_info")
						.usingGeneratedKeyColumns("id");*/
	}
	
	//ruc.id, ruc.product_id, ruc.reservation_info_id, ruc.score, ruc.comment, ruc.create_date, ruc.modify_date
	public List<Comment> commentList(Integer displayInfoId){
		Map<String, Integer> params=new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		return jdbc.query(DETAIL_COMMENT, params, new RowMapper<Comment>() {

			@Override
			public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Comment p = new Comment();
				p.setId(rs.getInt(1));
				p.setProductId(rs.getInt(2));
				p.setReservationInfoId(rs.getInt(3));
				p.setScore(rs.getFloat(4));
				p.setComment(rs.getString(5));
				p.setCreateDate(rs.getDate(6));
				p.setModifyDate(rs.getDate(7));
				return p;
			}
		});
	}

	public int commentCnt(int displayInfoId) {
		Map<String, Integer> params=new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		return jdbc.queryForObject(DETAIL_COMMENT_COUNT, params, Integer.class);
	}
}
