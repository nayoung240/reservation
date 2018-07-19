package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	//category
	public static final String CATEGORY_ALL="select id, name from category";
	
	//product
	public static final String ALL_COUNT="select count(*) from product";
	public static final String CATE_COUNT="select count(*) from product where category_id= :categoryId";
	public static final String PRODUCT_ALL="select id, categoryId, description, content, event, create_date, modify_date from product";
	public static final String PRODUCT_ALL_ORIGIN="select id, category_id, description, content, event, create_date, modify_date from product limit :start, :limit";
	public static final String PAGING="select id, content, description from product where category_id= :categoryId order by id desc limit :start, :limit";
	//public static final String PRODUCT_JOIN="select p.category_id, p.id, d.product_id, p.description, p.content, d.place_name from product p inner join p.display_info d on p.id=d.product_id where p.category_id= :categoryId order by p.id desc limit :start :limit";
	
	//promotion
	public static final String PROMOTION_ALL="select id, category_id from promotion";
	
	//display_info
	public static final String DISPLAY_INFO="select id, product_id, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date from display_info order by product_id desc";
	public static final String DISPLAY_INFO2="select place_name from display_info where product_id= :productId";
}
