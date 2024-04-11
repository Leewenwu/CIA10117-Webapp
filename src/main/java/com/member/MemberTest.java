package com.member;

import java.util.List;

public class MemberTest {
	public static void main(String[] args) {

		MemberDAO dao = new MemberDAOimpl();

		// ---------------------------
		Member mem1 = dao.findByPK(3);
		mem1.setPhone("0930222W221");
		dao.update(mem1);
		System.out.println(mem1.getmName() + ",");
		System.out.println(mem1.getPhone()); 

		// ---------------------------
//		List<Member> list = dao.getAll();
//		for (Member mem : list) {
//			System.out.println(mem.getmName() + ",");
//			System.out.println(mem.getMemId() + ",");
//			System.out.println(mem.getPhone() + ",");
//			System.out.println(mem.getEmail());
//
//		}
		//

	}
}
