package com.member;

import static com.member.Constants.PAGE_MAX_RESULT;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

public class MemberService {

	private MemberDAO dao;

	public MemberService() {
		dao = new MemberDAOimpl();
	}

	public Member getOneMember(Integer memId) {
		return dao.findByPK(memId);

	}

	public Member updateMember(Integer memId, String mName, String mAccount, String mPassword, String email,
			String phone, String address, byte mState, boolean gender, Date birthday, byte[] image) {

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
		member.setImage(image);
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

	public List<Member> getAll(int Page) {
		return dao.getAll(Page);
	}

	public List<Member> getAll() {
		return dao.getAll();
	}

	public int getPageTotal(Map<String, String[]> map) {
		long total = dao.getTotal();
		int pageQty = (int) (total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
		return pageQty;
	}
	
	
	public int getPageTotal() {
		long total = dao.getTotal();
		int pageQty = (int) (total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
		return pageQty;
	}

	public List<Member> getCompositeQuery(Map<String, String[]> map,int Page) {
		Map<String, String> query = new HashMap<>();
		// Map.Entry即代表一組key-value
		Set<Map.Entry<String, String[]>> entry = map.entrySet();

		for (Map.Entry<String, String[]> row : entry) {
			String key = row.getKey();
			// 因為請求參數裡包含了action，做個去除動作
			if ("action".equals(key)) {
				continue;
			}
			// 若是value為空即代表沒有查詢條件，做個去除動作
			String value = row.getValue()[0]; // getValue拿到一個String陣列, 接著[0]取得第一個元素檢查
			if (value == null || value.isEmpty()) {
				continue;
			}
			query.put(key, value);
		}

		System.out.println(query);

		try {
			List<Member> list = dao.getCompositeQuery(query, Page);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
