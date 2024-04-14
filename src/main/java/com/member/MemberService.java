package com.member;

import java.sql.Date;
import java.util.List;

public class MemberService {

	private MemberDAO dao;

	public MemberService() {
		dao = new MemberDAOimpl();
	}

	public Member getOneMember(Integer memId) {
		return dao.findByPK(memId);
		
	}
	
	
	public Member updateMember(Integer memId, String mName, String mAccount, String mPassword, String email,
			String phone, String address, 	Integer mState, boolean gender, Date birthday, byte[] image) {

		Member member = new Member();
		member.setMemId(memId);
		member.setmName(mName);
		member.setmAccount(mAccount);
		member.setmPassword(mPassword);
		member.setEmail(email);
		member.setPhone(phone);
		member.setAddress(address);
		member.setmState(mState);
		member.setGender(gender);
		member.setBirthday(birthday);

		dao.update(member);
		return member;

	}

	public List<Member> getAll() {
		return dao.getAll();
	}
}
