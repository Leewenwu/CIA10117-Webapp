package com.order.model;

import java.util.*;
import java.sql.*;

public class OrderJDBC implements OrderDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "1234";
	
	private static final String INSERT_STMT = 
	"INSERT INTO reserve_order"
	+ " (reserve_session_id, member_id, reserve_order_date,"
	+ " reserve_number, booking_date, order_note) "
	+ "VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT reserve_order_id,reserve_session_id, member_id,"
		+ " reserve_order_date, reserve_number,"
		+ "reserve_order_state, booking_date, order_note"
		+ "FROM reserve_order by reserve_order_id;";
		private static final String GET_ONE_STMT = 
			"SELECT reserve_order_id,reserve_session_id, member_id, reserve_order_date,"
			+ " reserve_number,reserve_order_state, booking_date, "
			+ "order_note FROM reserve_order where reserve_order_id = ?";
		private static final String DELETE = 
			"DELETE FROM reserve_order where reserve_order_id = ?";
		private static final String UPDATE = 
			"UPDATE reserve_order set order_note=? where reserve_order_id = ?";

	
	@Override
	public void insert(OrderVO ordVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(OrderVO ordVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer ordno) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public OrderVO findByPrimaryKey(Integer ordno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
