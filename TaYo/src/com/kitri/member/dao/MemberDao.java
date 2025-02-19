package com.kitri.member.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.MemberDetailDTO;
import com.kitri.dto.MemberDTO;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class MemberDao {

	private static MemberDao MemberDao;
	static {
		MemberDao = new MemberDao();
	}

	public static MemberDao getInstance() {
		return MemberDao;
	}

	public String insertMember(String name, String email, String pass, int age, int grade, String gender,
			String address, String address_detail, java.util.Date joindate, java.util.Date outdate) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "insert all " + "into member(name, email, pass, age, grade, gender) values (?, ?, ?, ?, ?, ?) "
					+ "into member_detail (email, address, address_detail, joindate, outdate) values (?, ?, ?, ?, ?) "
					+ "select * " + "from dual";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, pass);
			pstmt.setInt(4, age);
			pstmt.setInt(5, grade);
			pstmt.setString(6, gender);

			pstmt.setString(7, email);
			pstmt.setString(8, address);
			pstmt.setString(9, address_detail);
			pstmt.setDate(10, new java.sql.Date(joindate.getTime()));
			pstmt.setDate(11, null);

			int result = pstmt.executeUpdate();
			if (result == 2) {
				return "1";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return "-1";
	}

	public String insertMember(String name, String email, String pass, String gender) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "insert all " + "into member(name, email, pass, age, grade, gender) values (?, ?, ?, ?, ?, ?)\n "
					+ "into member_detail (email, address, address_detail, joindate, outdate) values (?, ?, ?, ?, ?)\n "
					+ "select * " + "from dual";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, pass);
			pstmt.setInt(4, -1);
			pstmt.setInt(5, -1);
			pstmt.setString(6, gender);

			pstmt.setString(7, email);
			pstmt.setString(8, null);
			pstmt.setString(9, null);
			pstmt.setDate(10, null);
			pstmt.setDate(11, null);

			int result = pstmt.executeUpdate();
			System.out.println("MemberDao insertMember result: "+ result);
			if (result == 2) {
				return "1";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return "-1";
	}

	public List<MemberDTO> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO memberDto = null;
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			conn = DBConnection.makeConnection();
			String sql = "select name, email, pass, age, grade, gender, address, address_detail, joindate, outdate\n"
					+ "from member JOIN member_detail using(email)\n";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int board_seq = rs.getInt("board_seq");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String pass = rs.getString("pass");
				int age = rs.getInt("age");
				int grade = rs.getInt("grade");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String addressDetail = rs.getString("address_detail");
				Date joindate = rs.getDate("joindate");
				Date outdate = rs.getDate("outdate");
				MemberDetailDTO memberDetailDto = new MemberDetailDTO(email, address, addressDetail, joindate, outdate);
				memberDto = new MemberDTO(email, name, pass, age, grade, gender, memberDetailDto);
				list.add(memberDto);
//				System.out.println("MemberDao select all" +list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	public MemberDTO selectById(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO memberDto = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "select name, email, pass, age, grade, gender, address, address_detail, joindate, outdate\n" + 
					"    from member JOIN member_detail using (email)\n" + 
					"    where email like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String pass = rs.getString("pass");
				int age = rs.getInt("age");
				int grade = rs.getInt("grade");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String addressDetail = rs.getString("address_detail");
				Date joindate = rs.getDate("joindate");
				Date outdate = rs.getDate("outdate");
				MemberDetailDTO memberDetailDto = new MemberDetailDTO(email, address, addressDetail, joindate, outdate);
				memberDto = new MemberDTO(email, name, pass, age, grade, gender, memberDetailDto);
				return memberDto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return null;
	}

	public static void main(String[] args) {

//		MemberDao.getInstance().insertMember("name1", "email1", "pass", 20, 1, "M", "address", "address_detail",new java.util.Date(), new java.util.Date());

		List<MemberDTO> list = MemberDao.getInstance().selectAll();
		for (MemberDTO mem : list) {
			System.out.println("MemberDao main:" + mem.toString());

		}

	}

}
