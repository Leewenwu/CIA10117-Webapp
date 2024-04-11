package com.member;

import java.util.List;

public interface MemberDAO {

	int update(Member member);

	Member findByPK(Integer memId);

	List<Member> getAll();

}
