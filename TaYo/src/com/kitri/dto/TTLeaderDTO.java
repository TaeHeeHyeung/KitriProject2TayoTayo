package com.kitri.dto;

public class TTLeaderDTO {
	private int tripSeq;		//�Բ�Ÿ��id
	private int tripNum;		//��������
	public TripBasicDTO tripBasicDTO = new TripBasicDTO();
	
	public int getTripSeq() {
		return tripSeq;
	}
	public void setTripSeq(int tripSeq) {
		this.tripSeq = tripSeq;
	}

	public int getTripNum() {
		return tripNum;
	}
	public void setTripNum(int tripNum) {
		this.tripNum = tripNum;
	}

	
	
}
