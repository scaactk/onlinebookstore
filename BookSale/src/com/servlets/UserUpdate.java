package com.servlets;

import com.javabeen.UserBeen;
import com.sqls.UserSql;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserUpdate extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public UserUpdate() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    
		String Uemail = request.getParameter("Uemail");
		String Ulogname = request.getParameter("Ulogname");
		String Upassword = request.getParameter("Upassword");
		String Uesex = request.getParameter("Uesex");
		String Urealname = request.getParameter("Urealname");
		String Uphone = request.getParameter("Uphone");
		String Uaddress = request.getParameter("Uaddress");
		UserSql edi = new UserSql();
		UserBeen user = new UserBeen();
		user.setAddress(Uaddress);
		user.setE_mail(Uemail);
		user.setIDName(Ulogname);
		user.setPassWord(Upassword);
		user.setTelephone(Uphone);
		user.setTrueName(Urealname);
		user.setSex(Uesex);
		if(edi.updateUser(Uemail, user)){
			response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("user/UserRegister.jsp");
		}
		
		
		out.flush();
		out.close();
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}