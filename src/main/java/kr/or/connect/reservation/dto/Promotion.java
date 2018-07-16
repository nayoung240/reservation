package kr.or.connect.reservation.dto;

public class Promotion {
	private int id;
	private int category_id;
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
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", category_id=" + category_id + "]";
	}
	
}
