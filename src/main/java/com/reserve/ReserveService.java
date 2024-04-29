package com.reserve;

import static com.reserve.Constants.PAGE_MAX_RESULT;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;



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
	
	public List<ReserveOrder> getCompositeQuery(Map<String, String[]> map,int Page) {
		Map<String, String> query = new HashMap<>();
		// Map.Entry即代表一組key-value
		Set<Map.Entry<String, String[]>> entry = map.entrySet();

		for (Map.Entry<String, String[]> row : entry) {
			String key = row.getKey();
			// 因為請求參數裡包含了action，做個去除動作
			if ("action".equals(key)) {
				continue;
			}
			// 若是value為空即代表沒有查詢條件，做個去除動作
			String value = row.getValue()[0]; // getValue拿到一個String陣列, 接著[0]取得第一個元素檢查
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
