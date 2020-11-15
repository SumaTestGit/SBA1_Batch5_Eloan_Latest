package com.wellsfargo.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.evaluation.eloan.dao.ConnectionDao;

@WebServlet("/user")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ConnectionDao connDao;

	public void setConnDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}

	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		String viewName = "";
		try {
			switch (action) {
			case "registernewuser":
				viewName = registernewuser(request, response);
				break;
			case "validate":
				viewName = validate(request, response);
				break;
			case "placeloan":
				viewName = placeloan(request, response);
				break;
			case "application1":
				viewName = application1(request, response);
				break;
			case "editLoanProcess":
				viewName = editLoanProcess(request, response);
				break;
			case "registeruser":
				viewName = registerUser(request, response);
				break;
			case "register":
				viewName = register(request, response);
				break;
			case "application":
				viewName = application(request, response);
				break;
			case "trackloan":
				viewName = trackloan(request, response);
				break;
			case "editloan":
				viewName = editloan(request, response);
				break;
			case "displaystatus":
				viewName = displaystatus(request, response);
				break;
			default:
				viewName = "notfound.jsp";
				break;
			}
		} catch (Exception ex) {

			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
	}

	private String validate(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		String userName = request.getParameter("loginid");
		String password = request.getParameter("password");
		
		if(userName.equals("admin") && password.equals("admin")) {
			return "adminhome1.jsp";
		} else {
			return "userhome.jsp";
		}		
	}

	private String placeloan(HttpServletRequest request, HttpServletResponse response) {
		
		/* write the code to place the loan information */

		return null;
	}

	private String application1(HttpServletRequest request, HttpServletResponse response) {
		

		return null;
	}

	private String editLoanProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		/* write the code to edit the loan info */

		return null;
	}

	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		/* write the code to redirect page to read the user details */
		return "newuserui.jsp";
	}

	private String registernewuser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		String userName = request.getParameter("loginid");
		String password = request.getParameter("password");
		
		Connection con = connDao.connect();
		boolean userFound = ConnectionDao.validateUser(userName, password, con);
		
		if(!userFound) {
			connDao.createUser(userName, password, con);
			return "index.jsp";
		} else {
			return "";	
		}	
	}

	private String register(HttpServletRequest request, HttpServletResponse response) {
		
		/* write the code to redirect to register page */

		return null;
	}

	private String displaystatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		/*
		 * write the code the display the loan status based on the given application
		 * number
		 */

		return null;
	}

	private String editloan(HttpServletRequest request, HttpServletResponse response) {
		
		/* write a code to return to editloan page */
		Connection con;
		
		try {
			con = connDao.connect();
			
			String applicationnumber = request.getParameter("applicationnumber");
			
			String applicationStatus = connDao.selectStatusByApplicationNumber(applicationnumber, con);
			
			if(!applicationStatus.isEmpty()) {
				
				if (!applicationStatus.equalsIgnoreCase("approved")) {
					
					return "editloanui.jsp";
				} else {
					return "index.jsp";
				}				
			} 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return "notfound.jsp";		
	}

	private String trackloan(HttpServletRequest request, HttpServletResponse response) {
		
		/* write a code to return to trackloan page */

		return null;
	}

	private String application(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
}