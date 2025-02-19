package com.kitri.dto;

import java.io.IOException;
import java.util.*;

import com.kitri.api.tour.service.TourResionCodeService;

/**
 * @author user
 *
 */
public class TripBasicDTO {
	private int tripSeq;		//여행아이디
	private String email;		//이메일
	private String tripTitle;	//여행이름
	private String tripTheme;	//여행테마
	private String tripSeason;	//여행시즌
	private int tripNum;		//여행정원
	private Date startDate;		//출발일
	private Date endDate;		//종료일
	private int viewCount;		//조회수
	private int likeCount;		//추천수
	private Date lastUpDate;		//최종수정일
	private String isComplete;		//완료여부
	List<TripDetailDTO> detailList;	//상세일정리스트
	TTLeaderDTO ttLeaderDTO; //함께타요 leader
	
	public TTLeaderDTO getTtLeaderDTO() {
		return ttLeaderDTO;
	}

	public void setTtLeaderDTO(TTLeaderDTO ttLeaderDTO) {
		this.ttLeaderDTO = ttLeaderDTO;
	}
	//set test
	private Set<Integer> loc_set;
	
	public Set<Integer> getLoc_set() {
		return loc_set;
	}

	public void setLoc_set(Set<Integer> loc_set) {
		this.loc_set = loc_set;
	}

	@Override
	public String toString() {
		return "TripBasicDTO [tripSeq=" + tripSeq + ", email=" + email + ", tripTitle=" + tripTitle + ", tripTheme="
				+ tripTheme + ", tripSeason=" + tripSeason + ", tripNum=" + tripNum + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", viewCount=" + viewCount + ", likeCount=" + likeCount + ", lastUpDate="
				+ lastUpDate + ", isComplete=" + isComplete + ", detailList=" + detailList + "]";
	}

	public TripBasicDTO() {
		super();
	}

	public TripBasicDTO(int tripSeq, String email, String tripTitle, String tripTheme, String tripSeason, int tripNum,
			Date startDate, Date endDate, int viewCount, int likeCount, Date lastUpDate, String isComplete, List<TripDetailDTO> detailList) {
		super();
		this.tripSeq = tripSeq;
		this.email = email;
		this.tripTitle = tripTitle;
		this.tripTheme = tripTheme;
		this.tripSeason = tripSeason;
		this.tripNum = tripNum;
		this.startDate = startDate;
		this.endDate = endDate;
		this.viewCount = viewCount;
		this.likeCount = likeCount;
		this.lastUpDate = lastUpDate;
		this.isComplete = isComplete;
		this.detailList = detailList; 
	}

	

	public List<TripDetailDTO> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<TripDetailDTO> detailList) {
		this.detailList = detailList;
	}
	public Date getLastUpDate() {
		return lastUpDate;
	}
	public void setLastUpDate(Date lastUpDate) {
		this.lastUpDate = lastUpDate;
	}
	public int getTripSeq() {
		return tripSeq;
	}
	public void setTripSeq(int tripSeq) {
		this.tripSeq = tripSeq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTripTitle() {
		return tripTitle;
	}
	public void setTripTitle(String tripTitle) {
		this.tripTitle = tripTitle;
	}
	public String getTripTheme() {
		return tripTheme;
	}
	public void setTripTheme(String tripTheme) {
		this.tripTheme = tripTheme;
	}
	public String getTripSeason() {
		return tripSeason;
	}
	public void setTripSeason(String tripSeason) {
		this.tripSeason = tripSeason;
	}
	public int getTripNum() {
		return tripNum;
	}
	public void setTripNum(int tripNum) {
		this.tripNum = tripNum;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(String isComplete) {
		this.isComplete = isComplete;
	}
	public List<TripDetailDTO> getTripDetailDTO() {
		return detailList;
	}
	public void setTripDetailDTO(List<TripDetailDTO> tripDetailDTO) {
		this.detailList = tripDetailDTO;
	}
}
