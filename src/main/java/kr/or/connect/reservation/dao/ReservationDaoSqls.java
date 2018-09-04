package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	//category
	public static final String CATEGORIES="select c.id, c.name, count(*) from category c left join product p on c.id=p.category_id group by p.category_id";
	
	//main t
	public static final String ALL_COUNT="select count(*) from product";
	public static final String ALL_PRODUCT="select p.id, p.category_id, p.description, p.content, d.place_name, pi.file_id, f.save_file_name from product p left join display_info d on p.id=d.product_id left join product_image pi on p.id=pi.product_id left join file_info f on f.id=pi.file_id where type='th' limit :start, :limit";
	public static final String CATE_PRODUCT="select p.id, p.category_id, p.description, p.content, d.place_name, pi.file_id, f.save_file_name from product p left join display_info d on p.id=d.product_id left join product_image pi on p.id=pi.product_id left join file_info f on f.id=pi.file_id where type='th' and category_id= :categoryId limit :start, :limit";
	//public static final String ALL_PROMOTION_IMAGES="select f.save_file_name from product_image pi left join file_info f on pi.file_id=f.id where type='ma'";
	public static final String SOME_PROMOTION_IMAGES="select fi.save_file_name from promotion pm left join product p on pm.product_id=p.id left join product_image pi on pi.product_id=p.id left join file_info fi on fi.id=pi.file_id where type='ma'";
	public static final String API_PROMOTION="select pm.id, pm.product_id, p.category_id, c.name, p.description, pi.id from promotion pm left join product p on pm.product_id=p.id left join category c on p.category_id=c.id left join product_image pi on pi.product_id=p.id where type='ma'";
	
	//detail
	public static final String DETAIL_PRODUCT="select p.id, p.category_id, d.id, c.name, p.description, p.content, p.event, d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email, d.create_date, d.modify_date from product p left join display_info d on p.id=d.product_id left join category c on c.id=p.category_id left join product_image pi on p.id=pi.product_id left join file_info f on f.id=pi.file_id where d.id= :displayInfoId";
	public static final String DETAIL_PRODUCT_IMAGES="select pi.product_id, pi.id, pi.type, fi.id, fi.file_name, fi.save_file_name, fi.content_type, fi.delete_flag, fi.create_date, fi.modify_date from product_image pi left join file_info fi on pi.file_id=fi.id where pi.product_id= :displayInfoId and type='ma'";
	public static final String DETAIL_DISPLAY_IMAGES="select dii.id, dii.display_info_id, dii.file_id, fi.file_name, fi.save_file_name, fi.content_type, fi.delete_flag, fi.create_date, fi.modify_date from display_info_image dii left join file_info fi on dii.file_id=fi.id where dii.display_info_id= :displayInfoId";
	public static final String DETAIL_COMMENT="select ruc.id, ruc.product_id, ruc.reservation_info_id, ruc.score, ruc.comment, ruc.create_date, ruc.modify_date from reservation_user_comment ruc where ruc.product_id= :displayInfoId";
	public static final String DETAIL_COMMENT_IMAGES="select ruci.id, ruci.reservation_info_id, ruci.reservation_user_comment_id, ruci.file_id, fi.content_type, fi.delete_flag, fi.create_date, fi.modify_date from reservation_user_comment_image ruci left join file_info fi on fi.id=ruci.file_id where ruci.reservation_info_id= :displayInfoId";
	
/*	//file_info
	public static final String FILE_INFO="select id, file_name from file_info";
	
	//promotion
	public static final String PROMOTION_ALL="select id, category_id from promotion";
	
	//display_info
	public static final String DISPLAY_INFO="select id, product_id, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date from display_info order by product_id desc";
	public static final String DISPLAY_INFO2="select place_name from display_info where product_id= :productId";*/
}
