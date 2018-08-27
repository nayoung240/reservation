package kr.or.connect.reservation.dto;

public class PromotionImg {
	private String saveFileName;
	
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	@Override
	public String toString() {
		return "PromotionImg [saveFileName=" + saveFileName + "]";
	}
	
}
