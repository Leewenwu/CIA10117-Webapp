package com.reserve;

import java.util.List;
import java.util.Map;

public interface ReserveDAO {
	int insert(ReserveOrder entity);

	int update(ReserveOrder entity);

	long getTotal();
	
	ReserveOrder findPK(Integer id);

	List<ReserveOrder> getAll();

	List<ReserveOrder> getAll(int Page);

	List<ReserveOrder> getCompositeQuery(Map<String, String> map, int Page);

}
