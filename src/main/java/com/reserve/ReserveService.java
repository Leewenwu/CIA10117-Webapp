package com.reserve;

import static com.reserve.Constants.PAGE_MAX_RESULT;

import java.sql.Date;
import java.sql.Timestamp;

public class ReserveService {

	private ReserveDAO dao;

	public ReserveService() {
		dao = new ReserveDAOimpl();

	}

	public ReserveOrder getOne(Integer reserveOrderId) {
		return dao.findPK(reserveOrderId);

	}

	public ReserveOrder update(Integer reserveOrderId, Integer reserveSessionId, Integer memberId,
			Date reserveOrderDate, Integer reserveNumber, Integer reserveOrderState, Timestamp bookingDate,
			String orderNote, ReserveSession reserveSession) {

		ReserveOrder order = new ReserveOrder();
		order.setReserveSessionId(reserveSessionId);
		order.setMemberId(memberId);
		order.setReserveOrderDate(reserveOrderDate);
		order.setReserveNumber(reserveNumber);
		order.setReserveOrderState(reserveOrderState);
		order.setBookingDate(bookingDate);
		order.setOrderNote(orderNote);
		order.setReserveSession(reserveSession);

		dao.update(order);
		return order;

	}
		
	
	
	
}
