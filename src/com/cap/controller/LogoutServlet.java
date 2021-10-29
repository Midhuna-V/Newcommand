package com.cap.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LogoutServlet extends HttpServlet {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
            response.setContentType("text/html");  
       //    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
            PrintWriter out=response.getWriter();  
            request.getRequestDispatcher("link.html").include(request, response);  
//           Cookie ck=new Cookie("uname","");
//            	ck.setMaxAge(0);
//            	response.addCookie(ck);
            
          HttpSession session=  request.getSession();
            session.invalidate();
            
            out.print("You are successfully logged out!");  
            out.close();  
    }  
}  