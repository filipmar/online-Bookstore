package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.User;
import model.dao.UserDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username, password;
		boolean result = false;
		
		UserDAO userDao = new UserDAO();
		List<User> users = userDao.getAll();
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		for (User user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password) && user.getStatus().equals("active")){
				result = true;
				HttpSession session = request.getSession();
				session.setAttribute("loggedUser",user);
				response.sendRedirect("LoginUserController");
			}
			
		}
		if(!result){
			request.getRequestDispatcher("Login.jsp").forward(request,response);	
		}
	}

}
