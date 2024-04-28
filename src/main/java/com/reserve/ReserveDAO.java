package com.reserve;

import java.util.List;
import java.util.Map;

public interface ReserveDAO {
	int insert(ReserveOrder Reserve);

	int update(ReserveOrder Reserve);

	long getTotal();
	
	ReserveOrder findPK(Integer reserveOrderId);

	List<ReserveOrder> getAll();

	List<ReserveOrder> getAll(int Page);

	List<ReserveOrder> getCompositeQuery(Map<String, String> map, int Page);

}
