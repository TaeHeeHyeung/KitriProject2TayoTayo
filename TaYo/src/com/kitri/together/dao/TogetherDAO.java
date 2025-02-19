package com.kitri.together.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.TTLeaderDTO;
import com.kitri.dto.TripDetailDTO;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class TogetherDAO {
	//함께타요 마감임박순 select
	public List<TTLeaderDTO> selectPlan() {
		List<TTLeaderDTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DBConnection.makeConnection();
			
			String selectPlanSQL = "select tt.trip_seq, tt.now_num, tb.trip_num, tb.email, tb.trip_title, tb.start_date, tb.end_date, tb.viewCount, tb.likeCount " + 
					"from tt_leader tt, trip_basic tb " + 
					"where tt.trip_seq = tb.trip_seq " + 
					"and tb.trip_theme = '함께타요' " + 
					"order by tt.now_num/tb.trip_num";
			
			pstmt = con.prepareStatement(selectPlanSQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TTLeaderDTO ttLeaderDTO = new TTLeaderDTO();
				ttLeaderDTO.setTripSeq(rs.getInt("trip_seq"));
				ttLeaderDTO.setNowNum(rs.getInt("now_num"));
				
				ttLeaderDTO.tripBasicDTO.setTripNum(rs.getInt("trip_num"));
				ttLeaderDTO.tripBasicDTO.setEmail(rs.getString("email"));
				ttLeaderDTO.tripBasicDTO.setTripTitle(rs.getString("trip_title"));
				ttLeaderDTO.tripBasicDTO.setStartDate(rs.getDate("start_date"));
				ttLeaderDTO.tripBasicDTO.setEndDate(rs.getDate("end_date"));
				ttLeaderDTO.tripBasicDTO.setViewCount(rs.getInt("viewCount"));
				ttLeaderDTO.tripBasicDTO.setLikeCount(rs.getInt("likeCount"));
				
				
				list.add(ttLeaderDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}
	
		return list;
	}

	//함께타요best4
	public List<TTLeaderDTO> selectbest4() {
		List<TTLeaderDTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		try {
			con = DBConnection.makeConnection();
			
			String selectbestSQL = "select rownum, t.* " + 
					"from(select tt.trip_seq, tt.now_num, tb.trip_num, tb.email, tb.trip_title, tb.start_date, tb.end_date, tb.viewCount, tb.likeCount " + 
					"from tt_leader tt, trip_basic tb " + 
					"where tt.trip_seq = tb.trip_seq " + 
					"and tb.trip_theme = '함께타요' " + 
					"order by tt.now_num/tb.trip_num desc) t " + 
					"where rownum <= 4";  
			
			pstmt = con.prepareStatement(selectbestSQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TTLeaderDTO ttLeaderDTO = new TTLeaderDTO();
				
				ttLeaderDTO.setTripSeq(rs.getInt("trip_seq"));
				ttLeaderDTO.setNowNum(rs.getInt("now_num"));
				
				ttLeaderDTO.tripBasicDTO.setTripNum(rs.getInt("trip_num"));
				ttLeaderDTO.tripBasicDTO.setEmail(rs.getString("email"));
				ttLeaderDTO.tripBasicDTO.setTripTitle(rs.getString("trip_title"));
				ttLeaderDTO.tripBasicDTO.setStartDate(rs.getDate("start_date"));
				ttLeaderDTO.tripBasicDTO.setEndDate(rs.getDate("end_date"));
				ttLeaderDTO.tripBasicDTO.setViewCount(rs.getInt("viewCount"));
				ttLeaderDTO.tripBasicDTO.setLikeCount(rs.getInt("likeCount"));
				 
				
				list.add(ttLeaderDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}
	
		return list;
	}
	
	//함께타요 일정 상세 페이지 보여주기
	public List<TripDetailDTO> selectPlanDetail(int tripSeq) {
		List<TripDetailDTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		try {
			con = DBConnection.makeConnection();
			
			String selectPlanDetailSQL = "select * " + 
					"from trip_detail " + 
					"where trip_seq = ? " + 
					"order by trip_day, trip_order";  
			
			pstmt = con.prepareStatement(selectPlanDetailSQL);
			pstmt.setInt(1, tripSeq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TripDetailDTO tripDetailDTO = new TripDetailDTO();
				tripDetailDTO.setTrip_seq(rs.getInt("trip_seq"));
				tripDetailDTO.setTrip_day(rs.getInt("trip_day"));
				tripDetailDTO.setTrip_order(rs.getInt("trip_order"));
				tripDetailDTO.setPlace_name(rs.getString("place_name"));
				tripDetailDTO.setLoc_id(rs.getInt("loc_id"));
				tripDetailDTO.setImage(rs.getString("image"));
				tripDetailDTO.setDetail_title(rs.getString("detail_title"));
				tripDetailDTO.setDetail_content(rs.getString("detail_content"));
				tripDetailDTO.setPosX(rs.getFloat("posx"));
				tripDetailDTO.setPosY(rs.getFloat("posy"));
				
				list.add(tripDetailDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}
	
		return list;
	}
	
	//viewcount 올리기
	public void updateViewCount(int tripSeq, int viewCount) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.makeConnection();
			
			String updateViewCountSQL = "update trip_basic " + 
					"set viewcount = ? " + 
					"where trip_seq = ?";  
			
			pstmt = con.prepareStatement(updateViewCountSQL);
			pstmt.setInt(1, (viewCount+1));
			pstmt.setInt(2, tripSeq);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt);
		}
		
	}
	
	//likeCount 올리기
		public void updateLikeCount(int tripSeq, int likeCount, int heart) {
			System.out.println("현재 likeCount : " + likeCount);
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBConnection.makeConnection();
				
				String updateViewCountSQL = "update trip_basic " + 
						"set likeCount = ? " + 
						"where trip_seq = ?";  
				
				pstmt = con.prepareStatement(updateViewCountSQL); 
				pstmt.setInt(1, (likeCount+heart));
				pstmt.setInt(2, tripSeq);
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBClose.close(con, pstmt);
			}
			
		}
	
}
