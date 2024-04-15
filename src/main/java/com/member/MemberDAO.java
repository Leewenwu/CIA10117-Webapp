package com.member;

import java.util.List;

public interface MemberDAO {

	int update(Member member);

	List<Member> getAll();

	Member findByPK(Integer memId);

}
