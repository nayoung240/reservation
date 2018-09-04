package kr.or.connect.reservation.dto;

import java.util.Date;

public class Comment {
	private int id;
	private int productId;
	private int reservationInfoId;
	private float score;
	private String comment;
	private Date createDate;
	private Date modifyDate;
	
	public class commentImage{
		private int id;
		private int reservationInfoId;
		private int reservationUserCommentId;
		private int fileId;
		private String fileName;
		private String saveFileName;
		private String contentType;
		private int deleteFlag;
		private Date createDate;
		private Date modifyDate;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getReservationInfoId() {
			return reservationInfoId;
		}
		public void setReservationInfoId(int reservationInfoId) {
			this.reservationInfoId = reservationInfoId;
		}
		public int getReservationUserCommentId() {
			return reservationUserCommentId;
		}
		public void setReservationUserCommentId(int reservationUserCommentId) {
			this.reservationUserCommentId = reservationUserCommentId;
		}
		public int getFileId() {
			return fileId;
		}
		public void setFileId(int fileId) {
			this.fileId = fileId;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getSaveFileName() {
			return saveFileName;
		}
		public void setSaveFileName(String saveFileName) {
			this.saveFileName = saveFileName;
		}
		public String getContentType() {
			return contentType;
		}
		public void setContentType(String contentType) {
			this.contentType = contentType;
		}
		public int getDeleteFlag() {
			return deleteFlag;
		}
		public void setDeleteFlag(int deleteFlag) {
			this.deleteFlag = deleteFlag;
		}
		public Date getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}
		public Date getModifyDate() {
			return modifyDate;
		}
		public void setModifyDate(Date modifyDate) {
			this.modifyDate = modifyDate;
		}
		@Override
		public String toString() {
			return "CommentImage [id=" + id + ", reservationInfoId=" + reservationInfoId + ", reservationUserCommentId="
					+ reservationUserCommentId + ", fileId=" + fileId + ", fileName=" + fileName + ", saveFileName="
					+ saveFileName + ", contentType=" + contentType + ", deleteFlag=" + deleteFlag + ", createDate="
					+ createDate + ", modifyDate=" + modifyDate + "]";
		}
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", productId=" + productId + ", reservationInfoId=" + reservationInfoId
				+ ", score=" + score + ", comment=" + comment + ", createDate=" + createDate + ", modifyDate="
				+ modifyDate + "]";
	}
	
	
}
