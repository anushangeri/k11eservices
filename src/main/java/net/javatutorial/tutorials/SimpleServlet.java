package net.javatutorial.tutorials;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {

	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nricfin");
//		String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        username = username.trim();
//        password = password.trim();
//
//        if (username.equals("admin")) {
//            if (password.equals("blackyellow")) {
//                HttpSession session = request.getSession();
//                session.setAttribute("authenticatedUser", username);
//                response.sendRedirect("admin");
//            } else {
//                request.setAttribute("msg", "Invalid Username/Password");
//                RequestDispatcher rd = request.getRequestDispatcher("LoginUI.jsp");
//                rd.forward(request, response);
//            }
//        }
		String responseObj = "Hello " + name;
		request.setAttribute("responseObj", responseObj);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
	}

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}
	
}
