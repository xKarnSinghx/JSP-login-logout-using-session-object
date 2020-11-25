package com.karn.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Login")
public class Login extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String un = request.getParameter("uname");
      String pw = request.getParameter("pass");
      if (un.equals("karn")&pw.equals("myFirst") ){
         out.print("Welcome, " + un);
         HttpSession session = request.getSession(true); // reuse existing
                                             // session if exist
                                             // or create one
         session.setAttribute("user", un);
         session.setMaxInactiveInterval(60); // 60 seconds
         response.sendRedirect("home.jsp");
      } else {
         RequestDispatcher rd = request.getRequestDispatcher("login.html");
         out.println("<font color=red>Either user name or password is wrong.</font>");
         rd.include(request, response);
      } 
   }
}
