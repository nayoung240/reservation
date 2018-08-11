package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	//category
	public static final String CATEGORY_ALL="select id, name from category";
	
	//main t
	public static final String ALL_COUNT="select count(*) from product";
	public static final String CATE_COUNT="select count(*) from product where category_id= :categoryId";
	public static final String ALL_PRODUCT="select p.id, p.category_id, p.description, p.content, d.place_name, pi.file_id, f.save_file_name from product p left join display_info d on p.id=d.product_id left join product_image pi on p.id=pi.product_id left join file_info f on f.id=pi.file_id where type='th' limit :start, :limit";
	public static final String ALL_PROMOTION_IMAGES="select f.save_file_name from product_image pi left join file_info f on pi.file_id=f.id where type='ma'";
	public static final String SOME_PROMOTION_IMAGES="select fi.save_file_name from promotion pm left join product p on pm.product_id=p.id left join product_image pi on pi.product_id=p.id left join file_info fi on fi.id=pi.file_id where type='ma'";
	public static final String CATE_PRODUCT="select p.category_id, p.id, d.product_id, p.description, p.content, d.place_name from product p left join display_info d on p.id=d.product_id where p.category_id= :categoryId order by p.id desc limit :start, :limit";
	
	//file_info
	public static final String FILE_INFO="select id, file_name from file_info";
	
	//promotion
	public static final String PROMOTION_ALL="select id, category_id from promotion";
	
	//display_info
	public static final String DISPLAY_INFO="select id, product_id, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date from display_info order by product_id desc";
	public static final String DISPLAY_INFO2="select place_name from display_info where product_id= :productId";
}
