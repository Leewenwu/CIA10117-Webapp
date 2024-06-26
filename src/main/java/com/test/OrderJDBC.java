package com.test;

import java.util.*;

import com.order.model.OrderDAO_interface;
import com.order.model.OrderVO;

import java.sql.*;

public class OrderJDBC implements OrderDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/mytest?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "1234";

	private static final String INSERT_STMT = "INSERT INTO reserve_order"
			+ " (reserve_session_id, member_id, reserve_order_date," + " reserve_number, booking_date, order_note) "
			+ "VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT reserve_order_id, reserve_session_id, member_id,"
	        + " reserve_order_date, reserve_number, reserve_order_state, booking_date, order_note "
	        + "FROM reserve_order ORDER BY reserve_order_id;";
	private static final String GET_ONE_STMT = "SELECT reserve_order_id,reserve_session_id, member_id, reserve_order_date,"
			+ " reserve_number,reserve_order_state, booking_date, "
			+ "order_note FROM reserve_order where reserve_order_id = ?";
	private static final String DELETE = "DELETE FROM reserve_order where reserve_order_id = ?";
	private static final String UPDATE = "UPDATE reserve_order set order_note=? where reserve_order_id = ?";

	@Override
	public void insert(OrderVO ordVO) {
		try (Connection connection = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = connection.prepareStatement(INSERT_STMT)) {
				 
			pstmt.setInt(1, ordVO.getSessionid());
			pstmt.setInt(2, ordVO.getMemberid());
			pstmt.setDate(3, ordVO.getOrderdate());
			pstmt.setInt(4, ordVO.getNumber());
			pstmt.setTimestamp(5, ordVO.getBookingdate());
			pstmt.setString(6, ordVO.getOrdernote());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// 適當的錯誤處理
		}

	}

	@Override
	public void update(OrderVO ordVO) {
		try (Connection connection = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = connection.prepareStatement(UPDATE)) {
			pstmt.setString(1, ordVO.getOrdernote());
			pstmt.setInt(2, ordVO.getOrderid()); // 第二個問號對應的是訂單ID
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void delete(Integer ordid) {
		try (Connection connection = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = connection.prepareStatement(DELETE)) {
			pstmt.setInt(1, ordid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	@Override
	public OrderVO findByPrimaryKey(Integer ordno) {
		OrderVO ordVO = null;
		try (Connection connection = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = connection.prepareStatement(GET_ONE_STMT)) {
			pstmt.setInt(1, ordno);

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					ordVO = new OrderVO();
					ordVO.setOrderid(rs.getInt("reserve_order_id"));
					ordVO.setSessionid(rs.getInt("reserve_session_id"));
					ordVO.setMemberid(rs.getInt("member_id"));
					ordVO.setOrderdate(rs.getDate("reserve_order_date"));
					ordVO.setNumber(rs.getInt("reserve_number"));
					ordVO.setOrderstate(rs.getInt("reserve_order_state"));
					ordVO.setBookingdate(rs.getTimestamp("booking_date"));
					ordVO.setOrdernote(rs.getString("order_note"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// 適當的錯誤處理
		}
		return ordVO;
	}

	@Override
	
	public List<OrderVO> getAll() {
		
		List<OrderVO> list = new ArrayList<OrderVO>();
		try (Connection connection = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = connection.prepareStatement(GET_ALL_STMT);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				OrderVO ordVO = new OrderVO();
				ordVO.setOrderid(rs.getInt("reserve_order_id"));
				ordVO.setSessionid(rs.getInt("reserve_session_id"));
				ordVO.setMemberid(rs.getInt("member_id"));
				ordVO.setOrderdate(rs.getDate("reserve_order_date"));
				ordVO.setNumber(rs.getInt("reserve_number"));
				ordVO.setOrderstate(rs.getInt("reserve_order_state"));
				ordVO.setBookingdate(rs.getTimestamp("booking_date"));
				ordVO.setOrdernote(rs.getString("order_note"));
				list.add(ordVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// 適當的錯誤處理
		}
		return list;
	}

}
