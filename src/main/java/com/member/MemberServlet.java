package com.member;

import java.io.IOException;
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
	
	
}
