package net.javatutorial.tutorials;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import net.javatutorial.DAO.EmployeesManagerDAO;
import net.javatutorial.entity.Employee;

/**
 * Servlet implementation class ViewVehicleRecordServlet
 */
public class ViewEmployeeRecordServlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usertype = (String) request.getSession(false).getAttribute("usertype");
		String idNo = (String) request.getSession(false).getAttribute("idNo");
		String name = (String) request.getSession(false).getAttribute("name");
		String message = "No employee records available for: " + name;
		ArrayList<Employee> vList = null;
		if(!StringUtils.isEmpty(idNo)) {
			if(usertype != null && !usertype.toUpperCase().equals("SECURITY OFFICER")) {
				vList = EmployeesManagerDAO.retrieveAll();
				message = "List of employee records";
				request.setAttribute("vList", vList);
				if(vList == null && vList.size() == 0) {
					message = "No employee records available";
				}
			}
			else{
				vList = EmployeesManagerDAO.retrieveByID(idNo);
				message = "List of employee records for " + name;
				request.setAttribute("vList", vList);
				if(vList == null && vList.size() == 0) {
					message = "No employee records available for " + name;
				}
			}
		}
		
		request.setAttribute("message", message);
        RequestDispatcher rd = request.getRequestDispatcher("viewEmployees.jsp");
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
