package com.kitri.dto;

public class TTLeaderDTO {
	private int tripSeq;		//�Բ�Ÿ��id
	private String partyEmail;	//�������̸���
	private int tripNum;		//��������
	private int partyOK;		//���Լ�������
	public int getTripSeq() {
		return tripSeq;
	}
	public void setTripSeq(int tripSeq) {
		this.tripSeq = tripSeq;
	}
	public String getPartyEmail() {
		return partyEmail;
	}
	public void setPartyEmail(String partyEmail) {
		this.partyEmail = partyEmail;
	}
	public int getTripNum() {
		return tripNum;
	}
	public void setTripNum(int tripNum) {
		this.tripNum = tripNum;
	}
	public int getPartyOK() {
		return partyOK;
	}
	public void setPartyOK(int partyOK) {
		this.partyOK = partyOK;
	}
	
	
}
