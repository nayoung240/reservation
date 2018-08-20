package kr.or.connect.reservation.dto;

public class Count {
	private int cateCnt;

	public int getCateCnt() {
		return cateCnt;
	}

	public void setCateCnt(int cateCnt) {
		this.cateCnt = cateCnt;
	}

	@Override
	public String toString() {
		return "Count [cateCnt=" + cateCnt + "]";
	}
	
}
