package com.cap.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
     //   response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
        PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("link.html").include(request, response);  
        
        String name=request.getParameter("name");  
        
        String password=request.getParameter("password");  
        
        if(password.equals("fiserv"))
        {  
       out.print("Welcome, "+name);  
//        Cookie ck=new Cookie("uname",name);//true  
//        response.addCookie(ck);
//        Cookie ck1=new Cookie("pass",password);//true  
//        response.addCookie(ck1);
        	 HttpSession session= request.getSession();
        session.setAttribute("uname",name);  
        }  
        
        else{  
            out.print("Sorry, username or password error!");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
}  