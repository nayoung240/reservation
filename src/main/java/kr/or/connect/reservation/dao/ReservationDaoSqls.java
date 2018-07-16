package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	//category
	public static final String CATEGORY_ALL="select id, name from category";
	
	//product
	public static final String ALL_COUNT="select count(*) from product";
	public static final String CATE_COUNT="select count(*) from product where category_id=:category_id";
	public static final String PRODUCT_ALL="select id, category_id, description, content, event, create_date, modify_date from product";
	public static final String PAGING="select id, content, description from product where category_id= :category_id order by id desc limit :start, :limit";
	
	//promotion
	public static final String PROMOTION_ALL="select id, category_id from promotion";
	
	//display_info
	public static final String DISPLAY_INFO="select id, product_id, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date from display_info order by product_id desc";
	
}
