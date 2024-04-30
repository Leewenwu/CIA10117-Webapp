package com.reserve.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.member.Member;
import com.member.MemberDAO;
import com.member.MemberDAOimpl;
import com.reserve.ReserveDAO;
import com.reserve.ReserveDAOimpl;
import com.reserve.ReserveOrder;
import com.reserve.ReserveService;
//import com.reserve.ReserveSession;
import com.reserve.ReserveSession;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 0, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 10)
@WebServlet("/reserve/reserve.do")

public class ReserveServlet extends HttpServlet {

	private ReserveService reserveService;

	private ReserveDAO reservedao;
	private MemberDAO memberdao;

	@Override
	public void init() throws ServletException {

		reserveService = new ReserveService();
		memberdao = new MemberDAOimpl();
		reservedao = new ReserveDAOimpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardPath = "";
		switch (action) {
		case "getAll":
			forwardPath = getAllReserve(req, res);
			break;
		case "insert":
			forwardPath = insert(req, res);
			break;
		default:
			forwardPath = "/index.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);

	}

	private String insert(HttpServletRequest req, HttpServletResponse rep) {
		Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
		req.setAttribute("errorMsgs", errorMsgs);

		Date reserveOrderDate = java.sql.Date.valueOf(req.getParameter("OrderDate").trim());

		Integer reserveNumber = Integer.parseInt(req.getParameter("reserveNumber").trim());

//		Byte reserveOrderState = Byte.parseByte(req.getParameter("reserveOrderState").trim());

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		String dateString = req.getParameter("bookingDate"); // 从请求中获取日期字符串，"dateInput" 是表单中日期输入字段的名称
		Date bookingDate = null;
		try {
			bookingDate = dateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String orderNote = req.getParameter("Note");

		if (orderNote == null || orderNote.trim().length() == 0) {
			orderNote = "";
		}

		// 假設 Member 和 ReserveSession 的 ID 通過表單提交
		Integer memberId = Integer.parseInt(req.getParameter("memId"));
		Integer Id = Integer.parseInt(req.getParameter("sessionId"));

		// 查找對應的 Member 和 ReserveSession 實體
		Member member = memberdao.findByPK(memberId);
		ReserveSession reserveSession = reservedao.findsessionPK(Id);

		reserveService.insert(reserveOrderDate, reserveNumber, bookingDate, orderNote, member, reserveSession);
		List<ReserveOrder> allOrder = reserveService.getAll();
		req.setAttribute("resList", allOrder);

		return "/reserve/listAllreserve.jsp";
	}

	private String getAllReserve(HttpServletRequest req, HttpServletResponse rep) {
		String page = req.getParameter("page");
		int currentPage = (page == null) ? 1 : Integer.parseInt(page);
		List<ReserveOrder> resList = reserveService.getAll();

		if (req.getSession().getAttribute("resPageQty") == null) {
			int resPageQty = reserveService.getPageTotal();
			req.getSession().setAttribute("resPageQty", resPageQty);
		}
		req.setAttribute("resList", resList);
		req.setAttribute("currentPage", currentPage);

		return "/reserve/listAllreserve.jsp";

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
