package com.member;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

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
		String memIdStr = req.getParameter("memId");

		if (memIdStr != null) {
			Integer memId = Integer.parseInt(memIdStr);
			Member getMember = memberService.getOneMember(memId);
			req.setAttribute("member", getMember);
		} else {
			return "/index.jsp";
		}
		return "/member/update.jsp";

	}

	private String getUpdate(HttpServletRequest req, HttpServletResponse res) {

		Integer memId = Integer.parseInt(req.getParameter("memId"));
		String mName = req.getParameter("mName");
		String mAccount = req.getParameter("mAccount");
		String mPassword = req.getParameter("mPassword");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		Integer mState = Integer.parseInt(req.getParameter("mState"));
		boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
		Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));

//		byte[] image = req.getParameter("image").getBytes(); // 處理方法可能需要根據實際情況調整
//		, image

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
