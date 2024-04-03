package com.order.model;

import java.sql.Date;
import java.util.List;

public class OrderService {

	private OrderDAO_interface dao;

	public OrderService() {
		dao = new OrderDAO();

	}

	public OrderVO addOrder(Integer orderid, String memberid, java.sql.Date orderdate, Integer number,
			Integer orderstate, Date bookingdate, Integer ordernote) {

		OrderVO ordvo = new OrderVO();

		// 设置OrderVO对象的各个属性
		ordvo.setOrderid(orderid);
		ordvo.setMemberid(memberid);
		ordvo.setOrderdate(orderdate);
		ordvo.setNumber(number);
		ordvo.setOrderstate(orderstate);
		ordvo.setBookingdate(bookingdate);
		ordvo.setOrdernote(ordernote);

		// 使用DAO将订单信息插入数据库
		dao.insert(ordvo);

		// 返回包含了新增订单信息的OrderVO对象
		return ordvo;

	}

	public OrderVO updateOrder(Integer ordernote) {

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

	public List<OrderVO> getALL() {
		return dao.getAll();
	}
}
