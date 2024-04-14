package com.member;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
			String phone, String address, Integer mState, boolean gender, Date birthday) {
//		, byte[] image
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
//		member.setImage(image);
		dao.update(member);
		return member;

	}

	public byte[] getDefaultImageData() {
		File imageFile = new File("path/to/default/image.jpg"); // 替換為實際的文件路徑
		byte[] imageData = null;
		try {
			imageData = Files.readAllBytes(imageFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
			// 處理異常，可能是文件不存在或讀取錯誤
		}
		return imageData;
	}

	public List<Member> getAll() {
		return dao.getAll();
	}
}
