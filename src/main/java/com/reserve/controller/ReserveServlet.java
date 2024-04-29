package com.reserve.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reserve.ReserveOrder;
import com.reserve.ReserveService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 0, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 10)
@WebServlet("/reserve/reserve.do")

public class ReserveServlet extends HttpServlet {

	private ReserveService reserveService;

	@Override
	public void init() throws ServletException {
		reserveService = new ReserveService();

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
//		case "compositeQuery":
//			forwardPath = getCompositeEmpsQuery(req, res);
//			break;
		default:
			forwardPath = "/index.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);

	}

	private String getAllReserve(HttpServletRequest req, HttpServletResponse rep) {
		String page = req.getParameter("page");
		int currentPage = (page == null) ? 1 : Integer.parseInt(page);

		List<ReserveOrder> resList = reserveService.getAll(currentPage);

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
