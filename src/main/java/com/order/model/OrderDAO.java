package com.order.model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrderDAO implements OrderDAO_interface {

//	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/mytest?serverTimezone=Asia/Taipei";
//	String userid = "root";
//	String passwd = "1234";

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mytest");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

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
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, ordVO.getSessionid());
			pstmt.setInt(2, ordVO.getMemberid());
			pstmt.setDate(3, ordVO.getOrderdate());
			pstmt.setInt(4, ordVO.getNumber());
			pstmt.setTimestamp(5, ordVO.getBookingdate());
			pstmt.setString(6, ordVO.getOrdernote());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
			} catch (Exception e) {
					e.printStackTrace(System.err);
					}
			}
		}

	}

	@Override
	public void update(OrderVO ordVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, ordVO.getOrdernote());
			pstmt.setInt(2, ordVO.getOrderid()); // 第二個問號對應的是訂單ID
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer ordid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, ordid);
			int rowsAffected = pstmt.executeUpdate();
			System.out.println(rowsAffected + " rows affected.");
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public OrderVO findByPrimaryKey(Integer ordno) {
		OrderVO ordVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, ordno);
			rs = pstmt.executeQuery();

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

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return ordVO;
	}

	public List<OrderVO> getAll() {
		List<OrderVO> list = new ArrayList<OrderVO>();
		OrderVO ordVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

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
				list.add(ordVO);
			}
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

}
