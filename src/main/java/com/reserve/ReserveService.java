package com.reserve;

import static com.reserve.Constants.PAGE_MAX_RESULT;

import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.member.Member;

public class ReserveService {

	private ReserveDAO dao;

	public ReserveService() {
		dao = new ReserveDAOimpl();

	}

	public ReserveOrder getOne(Integer reserveOrderId) {
		return dao.findPK(reserveOrderId);

	}

	public ReserveOrder insert(Date reserveOrderDate, 
			Integer reserveNumber, 
//			Byte reserveOrderState,
			Date bookingDate, 
			String orderNote,
			Member member,
			ReserveSession reserveSession) {

		ReserveOrder order = new ReserveOrder();
		order.setReserveOrderDate(reserveOrderDate);
		order.setReserveNumber(reserveNumber);
//		order.setReserveOrderState(reserveOrderState);
		order.setBookingDate(bookingDate);
		order.setOrderNote(orderNote);
		order.setMember(member);
		order.setReserveSession(reserveSession);

		dao.insert(order);
		return order;

	}

	public ReserveOrder update(Integer reserveOrderId, Integer reserveSessionId, Member member, Date reserveOrderDate,
			Integer reserveNumber, Byte reserveOrderState, Date bookingDate, String orderNote,
			ReserveSession reserveSession) {

		ReserveOrder order = new ReserveOrder();

		order.setReserveOrderDate(reserveOrderDate);
		order.setReserveNumber(reserveNumber);
		order.setReserveOrderState(reserveOrderState);
		order.setBookingDate(bookingDate);
		order.setOrderNote(orderNote);
		order.setReserveOrderId(reserveSessionId);
		order.setMember(member);
		order.setReserveSession(reserveSession);

		dao.update(order);
		return order;

	}

	public List<ReserveOrder> getAll(int Page) {
		return dao.getAll(Page);

	}

	public int getPageTotal(Map<String, String[]> map) {
		long total = dao.getTotal();
		int pageQty = (int) (total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
		return pageQty;

	}

	public List<ReserveOrder> getAll() {
		return dao.getAll();

	}

	public int getPageTotal() {
		long total = dao.getTotal();
		int pageQty = (int) (total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
		return pageQty;

	}	

	public List<ReserveOrder> getCompositeQuery(Map<String, String[]> map, int Page) {
		Map<String, String> query = new HashMap<>();
		// Map.Entry即代表一組key-value
		Set<Map.Entry<String, String[]>> entry = map.entrySet();

		for (Map.Entry<String, String[]> row : entry) {
			String key = row.getKey();

			if ("action".equals(key)) {
				continue;
			}

			String value = row.getValue()[0];
			if (value == null || value.isEmpty()) {
				continue;
			}
			query.put(key, value);
		}

		System.out.println(query);

		try {
			List<ReserveOrder> list = dao.getCompositeQuery(query, Page);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
