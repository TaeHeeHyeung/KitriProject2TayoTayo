package com.kitri.dto;

import java.util.Date;

public class PlaceDTO {
	private String placeId;		//����ڵ�
	private int locId;			//�����ڵ�
	private String placeName;	//����̸�
	private String placeCtg;	//�������
	private int placePrice;		//��������
	private Date placeTime;		//��ҿ����ð�
	private String placeWay;	//��Ұ��¹��
	private String placeInfo;	//��Ҽ�������
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceCtg() {
		return placeCtg;
	}
	public void setPlaceCtg(String placeCtg) {
		this.placeCtg = placeCtg;
	}
	public int getPlacePrice() {
		return placePrice;
	}
	public void setPlacePrice(int placePrice) {
		this.placePrice = placePrice;
	}
	public Date getPlaceTime() {
		return placeTime;
	}
	public void setPlaceTime(Date placeTime) {
		this.placeTime = placeTime;
	}
	public String getPlaceWay() {
		return placeWay;
	}
	public void setPlaceWay(String placeWay) {
		this.placeWay = placeWay;
	}
	public String getPlaceInfo() {
		return placeInfo;
	}
	public void setPlaceInfo(String placeInfo) {
		this.placeInfo = placeInfo;
	}
	
	
}
