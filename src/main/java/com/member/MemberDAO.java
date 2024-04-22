package com.member;

import java.util.List;
import java.util.Map;

public interface MemberDAO {

	int update(Member member);

	Member findByPK(Integer memId);


	List<Member> getAll();
	
	List<Member> getCompositeQuery(Map<String, String> map);
	

}
