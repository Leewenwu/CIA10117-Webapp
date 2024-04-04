package com.order.model;

import java.sql.Date;
import java.util.List;

public class OrderService {

	private OrderDAO_interface dao;

	public OrderService() {
		dao = new OrderDAO();

	}

	public OrderVO addOrder(Integer orderid, Integer memberid, java.sql.Date orderdate, Integer number,
			Integer orderstate, Date bookingdate, String ordernote) {

		OrderVO ordvo = new OrderVO();

		ordvo.setOrderid(orderid);
		ordvo.setMemberid(memberid);
		ordvo.setOrderdate(orderdate);
		ordvo.setNumber(number);
		ordvo.setOrderstate(orderstate);
		ordvo.setBookingdate(bookingdate);
		ordvo.setOrdernote(ordernote);

		dao.insert(ordvo);

		return ordvo;

	}

	public OrderVO updateOrder(String ordernote) {

		OrderVO ordvo = new OrderVO();

		ordvo.setOrdernote(ordernote);
		dao.update(ordvo);
		return ordvo;
	}

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
