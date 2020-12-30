package net.javatutorial.tutorials;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javatutorial.DAO.VMSManagerDAO;
import net.javatutorial.entity.Visitor;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/vms.jsp")
public class ViewVisitorRecordServlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Visitor> vList = VMSManagerDAO.retrieveAll();
		ArrayList<String> responseObj = new ArrayList<String>();
		String message = "Success";
		request.setAttribute("vList", vList);
		if(vList == null) {
			message = "No visitor records.";
		}
		responseObj.add(message);
		request.setAttribute("responseObj", responseObj);
        RequestDispatcher rd = request.getRequestDispatcher("vms.jsp");
        rd.forward(request, response);
	}
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ArrayList<Visitor> vList = VMSManagerDAO.retrieveAll();
//		ArrayList<String> responseObj = new ArrayList<String>();
//		String message = "Success";
//		request.setAttribute("vList", vList);
//		if(vList == null) {
//			message = "No visitor records.";
//		}
//		responseObj.add(message);
//		request.setAttribute("responseObj", responseObj);
//        RequestDispatcher rd = request.getRequestDispatcher("viewVisitor.jsp");
//        rd.forward(request, response);
//	}
        
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
	}

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}
}
