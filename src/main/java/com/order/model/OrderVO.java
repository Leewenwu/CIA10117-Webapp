package com.order.model;
import java.sql.Date;
import java.util.*;


public class OrderVO implements java.io.Serializable {

	// TODO Auto-generated method stub
	private Integer orderid;
	private Integer sessionid;
	private Integer memberid;
	private Date orderdate;
	private Integer number;
	private Integer orderstate;
	private Date bookingdate;
	private String ordernote;
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getSessionid() {
		return sessionid;
	}
	public void setSessionid(Integer sessionid) {
		this.sessionid = sessionid;
	}
	public Integer getMemberid() {
		return memberid;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(Integer orderstate) {
		this.orderstate = orderstate;
	}
	public Date getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}
	public String getOrdernote() {
		return ordernote;
	}
	public void setOrdernote(String ordernote) {
		this.ordernote = ordernote;
	}

	
}
