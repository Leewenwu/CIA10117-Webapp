package com.session.model;

import java.util.List;

public interface SionDAO {
	int insert(Sion sion);

	int delete(Integer sionId);

	List<Sion> getAll();
}
