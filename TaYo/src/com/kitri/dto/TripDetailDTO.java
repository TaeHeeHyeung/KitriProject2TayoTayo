package com.kitri.dto;

public class TripDetailDTO {
	private int tripSeq;			//������̵�
	private String placeId;			//����ڵ�
	private int Day;				//����
	private String image;			//�̹���
	private String detailTitle;		//��������
	private String detailContent;	//��������
	
	public PlaceDTO placeDTO = new PlaceDTO();
	
	public int getTripSeq() {
		return tripSeq;
	}
	public void setTripSeq(int tripSeq) {
		this.tripSeq = tripSeq;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public int getDay() {
		return Day;
	}
	public void setDay(int day) {
		Day = day;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDetailTitle() {
		return detailTitle;
	}
	public void setDetailTitle(String detailTitle) {
		this.detailTitle = detailTitle;
	}
	public String getDetailContent() {
		return detailContent;
	}
	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}
	
	
}
