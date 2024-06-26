package com.member;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 0, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 10)
@WebServlet("/member/member.do")
public class MemberServlet extends HttpServlet {

	private MemberService memberService;

	public void init() throws ServletException {
		memberService = new MemberService();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardpath = "";
		if (action == null) {
			action = "-1";
			return;
		}
		  
		switch (action) {
		case "getAll":
			forwardpath = getAll(req, res);
			break;
		case "getOne":
			forwardpath = getOne(req, res);
			break;
		case "getUpdate":
			forwardpath = getUpdate(req, res);
			break;
		case "compositeQuery":
			forwardpath = getCompositeQuery(req, res);
			break;
		default:
			forwardpath = "/index.jsp";

		}
		
		res.setContentType("text/html; charset=UTF-8");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardpath);
		
		dispatcher.forward(req, res);

	}

	private String getAll(HttpServletRequest req, HttpServletResponse res) {
		String page = req.getParameter("page");
		int currentpage = (page == null) ? 1 : Integer.parseInt(page);
		
		List<Member> memberList = memberService.getAll(currentpage);
			
		if (req.getSession().getAttribute("memberPageQty") == null) {
			int memberPageQty = memberService.getPageTotal();
			req.getSession().setAttribute("memberPageQty", memberPageQty);
		}
		req.setAttribute("currentpage", currentpage);
		req.setAttribute("memberList", memberList);

		return "/member/listAll.jsp";

	}

	private String getOne(HttpServletRequest req, HttpServletResponse res) {

//			String memIdStr = req.getParameter("memId");
//			Integer memId = Integer.parseInt(memIdStr);

		Integer memId = Integer.valueOf(req.getParameter("memId"));
		Member member = memberService.getOneMember(memId);

		String param = "?memId=" + member.getMemId() + "&mName=" + member.getmName() + "&mAccount="
				+ member.getmAccount() + "&mPassword=" + member.getmPassword() + "&email=" + member.getEmail()
				+ "&phone=" + member.getPhone() + "&address=" + member.getAddress() + "&mState=" + member.getmState()
				+ "&gender=" + (member.getGender() ? "true" : "false") + "&birthday=" + member.getBirthday();
//			req.setAttribute("member", member); //原本進入修改顯示當前資料的方法
		return "/member/update.jsp" + param;

	}

	private String getUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
		req.setAttribute("errorMsgs", errorMsgs);

		Integer memId = Integer.parseInt(req.getParameter("memId").trim());
		String mName = req.getParameter("mName").trim();
		String mAccount = req.getParameter("mAccount").trim();
		String mPassword = req.getParameter("mPassword").trim();
		String email = req.getParameter("email").trim();
		String phone = req.getParameter("phone").trim();
		String address = req.getParameter("address").trim();
		Byte mState = Byte.parseByte(req.getParameter("mState").trim());
		Boolean gender = Boolean.parseBoolean(req.getParameter("gender").trim());
		Date birthday = java.sql.Date.valueOf(req.getParameter("birthday").trim());
		byte[] image = null;

		InputStream in = req.getPart("image").getInputStream();

		if (in.available() != 0) {
			image = new byte[in.available()];
			in.read(image);
			in.close();

		} else {
			image = memberService.getOneMember(memId).getImage();
		}
//----------------------------------------------格式判斷在這------------		
		if (mName == null || mName.trim().length() == 0) {
			errorMsgs.put("mName", "請輸入名字!");
		} else {
			mName = mName.trim();
			if (!mName.matches("[\\u4E00-\\u9FA5A-Za-z]+")) {
				errorMsgs.put("mName", "名字必須是英文或中文!");
			} else if (mName.length() < 1 || mName.length() > 10) {
				errorMsgs.put("mName", "名字長度必須在10個字以內!");
			}
		}

		// 驗證 mAccount
		if (mAccount == null || mAccount.isEmpty()) {
			errorMsgs.put("mAccount", "帳號不能為空！");
		} else if (!mAccount.matches("[\\u4E00-\\u9FA5A-Za-z0-9]{1,10}")) {
			errorMsgs.put("mAccount", "帳號必須是10個字以內的中英文或數字！");
		}

		// 驗證 mPassword

		if (mPassword == null || mPassword.isEmpty()) {
			errorMsgs.put("mPassword", "密碼不能為空！");
		} else if (!mPassword.matches("[\\u4E00-\\u9FA5A-Za-z0-9]{1,10}")) {
			errorMsgs.put("mPassword", "密碼必須是10個字以內的中英文或數字！");
		}

		// 驗證 email

		if (email == null || email.isEmpty()) {
			errorMsgs.put("email", "電子郵件不能為空！");
		} else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			errorMsgs.put("email", "電子郵件格式不正確！");
		}

		// 驗證 phone

		if (phone == null || phone.isEmpty()) {
			errorMsgs.put("phone", "電話號碼不能為空！");
		} else if (!phone.matches("\\d{10}")) {
			errorMsgs.put("phone", "電話號碼只能是10位的數字！");
		}

		// address
		if (address.trim().length() == 0 || address == null) {
			errorMsgs.put("address", "地址不可為空！");
		} else if (!address.matches("^[\\u4E00-\\u9FA5\\d]+$")) {
			errorMsgs.put("address", "地址只能包含中文和數字！！");
		}
		// 狀態
		String mStateStr = req.getParameter("mState").trim();
		mState = null;
		if (mStateStr.trim().length() == 0 || mStateStr.isEmpty()) {
			errorMsgs.put("mState", "狀態不能為空！");
		} else {
			try {
				mState = Byte.parseByte(mStateStr);
				// 這裡也可以添加對mState的進一步驗證，例如檢查其是否在特定範圍內等
			} catch (NumberFormatException e) {
				errorMsgs.put("mState", "無效的狀態格式！");
			}
		}
		// 性別
		String genderStr = req.getParameter("gender").trim();
		gender = false; // 根據你的業務邏輯默認值可以是true或false
		if (genderStr.isEmpty()) {
			errorMsgs.put("gender", "性別不能為空！");
		} else {
			gender = Boolean.parseBoolean(genderStr);
			// 如果你的性別字段應該是 "M" 或 "F"，你可能需要不同的檢查
			if (!genderStr.equalsIgnoreCase("true") && !genderStr.equalsIgnoreCase("false")) {
				errorMsgs.put("gender", "性別格式不正確！");
			}
		}

		// 生日
		String birthdayStr = req.getParameter("birthday").trim();
		birthday = null;
		if (birthdayStr.isEmpty()) {
			errorMsgs.put("birthday", "生日不能為空！");
		} else {
			try {
				birthday = java.sql.Date.valueOf(birthdayStr);
			} catch (IllegalArgumentException e) {
				errorMsgs.put("birthday", "無效的生日格式！");
			}
		}

		if (!errorMsgs.isEmpty()) {
		
			return "/member/update.jsp";  // 程式中斷
		}

		Member getupdate = memberService.updateMember(memId, mName, mAccount, mPassword, email, phone, address, mState,
				gender, birthday, image);

		List<Member> allMembers = memberService.getAll();
		req.setAttribute("memberList", allMembers);

		req.setAttribute("member", getupdate);
		return "/member/listAll.jsp";

	}

	public String getCompositeQuery(HttpServletRequest req, HttpServletResponse res) {
		Map<String, String[]> map = req.getParameterMap();
		
		
		String page = req.getParameter("page");
		int currentpage = (page == null) ? 1 : Integer.parseInt(page);
		 List<Member> memberList = memberService.getCompositeQuery(map,currentpage);
	
		if (req.getSession().getAttribute("QmemberPageQty") == null) {
			int memberPageQty = memberService.getPageTotal(map);
			req.getSession().setAttribute("QmemberPageQty", memberPageQty);
		}
		
		req.setAttribute("Qcurrentpage", currentpage);
		req.setAttribute("QmemberList", memberList);	
		
		if (map != null) {
			List<Member> memberlist = memberService.getCompositeQuery(map,currentpage);
			req.setAttribute("memberList", memberlist);
		} else {
			return "/index.jsp";
		}

		return "/member/listAll.jsp";

	}

}
