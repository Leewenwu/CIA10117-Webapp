package com.reader;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.MemberService;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 0,  
maxFileSize = 1024 * 1024 * 1,  
maxRequestSize = 1024 * 1024 * 10  
)
@WebServlet("/member/DBGifReader")
public class DBGifReader extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		try {
			Integer memId = Integer.valueOf(req.getParameter("memId"));
			MemberService memSvc = new MemberService();
			
			out.write(memSvc.getOneMember(memId).getImage());

		} catch (Exception e) {
			InputStream in = getServletContext().getResourceAsStream("member/pic/nopic.jpg");
			byte[] buf = new byte[in.available()];
			in.read(buf);
			out.write(buf);
			in.close();
		}
	}
}
