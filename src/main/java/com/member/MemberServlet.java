package com.member;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		default:
			forwardpath = "index.jsp";

		}
		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardpath);
		dispatcher.forward(req, res);

	}

	private String getAll(HttpServletRequest req, HttpServletResponse res) {
		List<Member> memberList = memberService.getAll();
		req.setAttribute("memberList", memberList);

		return "/member/listAll.jsp";

	}

	private String getOne(HttpServletRequest req, HttpServletResponse res) {
		
//			String memIdStr = req.getParameter("memId");
//			Integer memId = Integer.parseInt(memIdStr);
		
			Integer memId = Integer.valueOf(req.getParameter("memId"));
			Member member = memberService.getOneMember(memId);
			
			
			
			
			String param = 
					"?memId=" +	 member.getMemId()+
					"&mName="+	 member.getmName()+
					"&mAccount="+ member.getmAccount()+
					"&mPassword="+member.getmPassword()+
					"&email="+member.getEmail()+
					"&phone="+member.getPhone()+
					"&address="+member.getAddress()+
					"&mState="+member.getmState()+
					"&gender=" + (member.getGender() ? "true" : "false") +
					"&birthday="+member.getBirthday();
//			req.setAttribute("member", member); //原本進入修改顯示當前資料的方法
			return "/member/update.jsp"+param;
	

	}

	private String getUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
		req.setAttribute("errorMsgs", errorMsgs);

		Integer memId = Integer.parseInt(req.getParameter("memId").trim());

		String mName = req.getParameter("mName").trim();

		if (mName == null || mName.trim().length() == 0) {
			errorMsgs.put("mName", "請輸入名字!");
		} else {
			mName = mName.trim(); 
			if (!mName.matches("[\\u4E00-\\u9FA5A-Za-z]+")) {
				errorMsgs.put("mName", "名字必須是英文或中文!");
			} else if (mName.length() < 1 || mName.length() > 20) {
				errorMsgs.put("mName", "名字長度必須在20 !");
			}
		}

		String mAccount = req.getParameter("mAccount").trim();
		String mPassword = req.getParameter("mPassword").trim();
		String email = req.getParameter("email").trim();
		String phone = req.getParameter("phone").trim();
		String address = req.getParameter("address").trim();
		Integer mState = Integer.parseInt(req.getParameter("mState").trim());
		boolean gender = Boolean.parseBoolean(req.getParameter("gender").trim());
		Date birthday = java.sql.Date.valueOf(req.getParameter("birthday").trim());
//		byte[] image = req.getParameter("image").getBytes(); // 處理方法可能需要根據實際情況調整
//		, image

		
		
		
		
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("errorMsgs", errorMsgs);
			Member prev = new Member();
			prev.setMemId(memId);
			prev.setmName(mName);
			prev.setmAccount(mAccount);
			prev.setmPassword(mPassword);
			prev.setEmail(email);
			prev.setPhone(phone);
			prev.setAddress(address);
			prev.setmState(mState);
			prev.setGender(gender);
			prev.setBirthday(birthday);
			//預留圖片的位置
			req.setAttribute("prev", prev);
			
			RequestDispatcher failureView = req.getRequestDispatcher("/member/update.jsp");
			failureView.forward(req, res);
			return "0"; // 程式中斷
		}

		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req.getRequestDispatcher("/member/update.jsp");
			failureView.forward(req, res);
			return null; // 程式中斷
		}

		Member getupdate = memberService.updateMember(memId, mName, mAccount, mPassword, email, phone, address, mState,
				gender, birthday);

		List<Member> allMembers = memberService.getAll();
		req.setAttribute("memberList", allMembers);

		req.setAttribute("member", getupdate);
		return "/member/listAll.jsp";

	}

	// 圖片 先預留
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
}
