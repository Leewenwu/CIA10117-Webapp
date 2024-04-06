package com.order.model;

import java.sql.Date;
import java.util.List;

public class OrderService {

	private OrderDAO_interface dao;

	public OrderService() {
		dao = new OrderDAO();

	}

	public OrderVO addOrder(Integer sessionid, Integer menberid, java.sql.Date orderdate, Integer number,
			Date bookingdate, String ordernote) {

		OrderVO ordvo = new OrderVO();

		ordvo.setSessionid(sessionid);
		ordvo.setMemberid(menberid);
		ordvo.setOrderdate(orderdate);
		ordvo.setNumber(number);
		ordvo.setBookingdate(bookingdate);
		ordvo.setOrdernote(ordernote);

		dao.insert(ordvo);

		return ordvo;

	}
	public OrderVO updateOrder(Integer orderid  ,String ordernote) {

		OrderVO ordvo = new OrderVO();
		ordvo.setOrderid(orderid);
		ordvo.setOrdernote(ordernote);
		dao.update(ordvo);
		return ordvo;
	}

//	public OrderVO updateOrder(Integer orderid  ,String ordernote) {
//
//		OrderVO ordvo = new OrderVO();
//		ordvo.setOrderid(orderid);
//		ordvo.setOrdernote(ordernote);
//		dao.update(ordvo);
//		return ordvo;
//	}

	public void deleteOrder(Integer ordid) {
		dao.delete(ordid);

	}

	public OrderVO getOneOrd(Integer ordid) {
		return dao.findByPrimaryKey(ordid);

	}

	public List<OrderVO> getAll() {
		return dao.getAll();
	}
}
