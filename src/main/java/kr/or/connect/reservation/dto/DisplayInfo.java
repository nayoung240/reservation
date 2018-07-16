package kr.or.connect.reservation.dto;

import java.util.Date;

public class DisplayInfo {
	private int id;
	private int category_id;
	private String opening_name;
	private String place_name;
	private String place_lot;
	private String place_street;
	private String tel;
	private String homepage;
	private String email;
	private Date create_date;
	private Date modify_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getcategory_id() {
		return category_id;
	}
	public void setcategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getOpening_name() {
		return opening_name;
	}
	public void setOpening_name(String opening_name) {
		this.opening_name = opening_name;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getPlace_lot() {
		return place_lot;
	}
	public void setPlace_lot(String place_lot) {
		this.place_lot = place_lot;
	}
	public String getPlace_street() {
		return place_street;
	}
	public void setPlace_street(String place_street) {
		this.place_street = place_street;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	@Override
	public String toString() {
		return "DisplayInfo [id=" + id + ", category_id=" + category_id + ", opening_name=" + opening_name
				+ ", place_name=" + place_name + ", place_lot=" + place_lot + ", place_street=" + place_street
				+ ", tel=" + tel + ", homepage=" + homepage + ", email=" + email + ", create_date=" + create_date
				+ ", modify_date=" + modify_date + "]";
	}
	
}
