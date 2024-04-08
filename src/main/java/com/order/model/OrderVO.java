package com.order.model;

import java.sql.*;
import java.sql.Date;



public class OrderVO implements java.io.Serializable {

	// TODO Auto-generated method stub
	private Integer orderId;//order
	private Integer sessionId;
	private Integer memberId;
	private Date orderDate;
	private Integer number;
	private Integer orderState;
	private Timestamp bookingDate;
	private String orderNote;
	public Integer getOrderid() {
		return orderId;
	}
	public void setOrderid(Integer orderid) {
		this.orderId = orderid;
	}
	public Integer getSessionid() {
		return sessionId;
	}
	public void setSessionid(Integer sessionid) {
		this.sessionId = sessionid;
	}
	public Integer getMemberid() {
		return memberId;
	}
	public void setMemberid(Integer memberid) {
		this.memberId = memberid;
	}
	public Date getOrderdate() {
		return orderDate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderDate = orderdate;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getOrderstate() {
		return orderState;
	}
	public void setOrderstate(Integer orderstate) {
		this.orderState = orderstate;
	}
	public Timestamp getBookingdate() {
		return bookingDate;
	}
	public void setBookingdate(	Timestamp bookingdate) {
		this.bookingDate = bookingdate;
	}
	public String getOrdernote() {
		return orderNote;
	}
	public void setOrdernote(String ordernote) {
		this.orderNote = ordernote;
	}

	
}
