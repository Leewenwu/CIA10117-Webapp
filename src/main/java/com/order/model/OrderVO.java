package com.order.model;
import java.sql.Date;

public class OrderVO implements java.io.Serializable {

	// TODO Auto-generated method stub
	private Integer orderid;
	private String sessionid;
	private String memberid;
	private Date orderdate;
	private Integer number;
	private Integer orderstate;
	private Date bookingdate;
	private Integer ordernote;
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
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
	public Integer getOrdernote() {
		return ordernote;
	}
	public void setOrdernote(Integer ordernote) {
		this.ordernote = ordernote;
	}

	
}
