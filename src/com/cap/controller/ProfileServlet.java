package com.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
//		Cookie ck[] = request.getCookies();
//		if (ck != null) {
//			String name = ck[0].getValue();
//			if (!name.equals(null) || !name.equals("")) {
//
//				out.print("Hello, " + name + " Welcome to Profile");
//			}
//		} 
		
				HttpSession session=	request.getSession(false);
		if(session!=null)
		{
			String name=(String) session.getAttribute("uname");
			out.print("Hello, " + name + " Welcome to Profile");
		}
		else {
			out.print("Please login first");
			request.getRequestDispatcher("login.html").include(request,
					response);
		}
		out.close();
	}
}