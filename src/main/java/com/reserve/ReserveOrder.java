package com.reserve;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

import com.member.Member;

@Entity
@DynamicUpdate
@Table(name = "reserve_order")
public class ReserveOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reserve_order_id", nullable = false)
	private Integer reserveOrderId;


	@Column(name = "reserve_order_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date reserveOrderDate;

	@Column(name = "reserve_number", nullable = false)
	private Integer reserveNumber;

	@Column(name = "reserve_order_state", nullable = false)
	private Byte reserveOrderState = 1;

	@Column(name = "booking_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingDate;

	@Column(name = "order_note", length = 50)
	private String orderNote;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id", referencedColumnName = "member_id" )
	private Member member;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reserve_session_id", referencedColumnName = "reserve_session_id" )
	private ReserveSession reserveSession;

	public Integer getReserveOrderId() {
		return reserveOrderId;
	}

	public void setReserveOrderId(Integer reserveOrderId) {
		this.reserveOrderId = reserveOrderId;
	}

	
	
//	public Integer getMemberId() {
//		return memberId;
//	}
//
//	public void setMemberId(Integer memberId) {
//		this.memberId = memberId;
//	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getReserveOrderDate() {
		return reserveOrderDate;
	}

	public void setReserveOrderDate(Date reserveOrderDate) {
		this.reserveOrderDate = reserveOrderDate;
	}

	public Integer getReserveNumber() {
		return reserveNumber;
	}

	public void setReserveNumber(Integer reserveNumber) {
		this.reserveNumber = reserveNumber;
	}

	public Byte getReserveOrderState() {
		return reserveOrderState;
	}

	public void setReserveOrderState(Byte reserveOrderState) {
		this.reserveOrderState = reserveOrderState;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getOrderNote() {
		return orderNote;
	}

	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}

	public ReserveSession getReserveSession() {
	    return reserveSession;
	}

	public void setReserveSession(ReserveSession reserveSession) {
	    this.reserveSession = reserveSession;
	}


	public ReserveOrder() {
		super();
		// TODO Auto-generated constructor stub
	}



}
