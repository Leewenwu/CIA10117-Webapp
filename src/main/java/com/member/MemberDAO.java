package com.member;

import java.util.List;
import java.util.Map;

public interface MemberDAO {

	int update(Member member);

	long getTotal();
	
	long getTotal(Map<String, String> map);

	Member findByPK(Integer memId);

	List<Member> getAll(int Page);
	
	List<Member> getAll();
	
//	List<Member> getCompositeQuery(Map<String, String> map);
	
	List<Member> getCompositeQuery(Map<String, String> map,int Page);
}
