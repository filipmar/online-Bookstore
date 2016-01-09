package controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.User;
import model.dao.BookDAO;
import model.dao.UserDAO;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 * Servlet implementation class AddNewUserController
 */
@WebServlet("/AddNewUserController")
public class AddNewUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 5 * 1024 * 1024; // 5 MB
	private int maxMemSize = 1024 * 1024; // 1 MB
	private File file;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rq = request.getRequestDispatcher("addNewUser.jsp");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = "File upload.";
		List<String> filenames = null;
		isMultipart = ServletFileUpload.isMultipartContent(request);
		HttpSession session = request.getSession(false);
		User loggedUser = null;
		if (session != null)
			loggedUser = (User) session.getAttribute("loggedUser");
		if (loggedUser == null) {
			request.getRequestDispatcher("Login.jsp").forward(request,
					response);
		}else{
			User user = new User();
			
			if(isMultipart){
				ServletContext context = this.getServletConfig()
						.getServletContext();
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// maximum size that will be stored in memory
				factory.setSizeThreshold(maxMemSize);
				// Location to save data that is larger than maxMemSize.
				File repoPath = (File) context
						.getAttribute("javax.servlet.context.tempdir");
				factory.setRepository(repoPath);

				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);
				// maximum file size to be uploaded.
				upload.setSizeMax(maxFileSize);
				
				try{
					List<FileItem> fileItems = upload
							.parseRequest(new ServletRequestContext(request));
					filePath = request.getServletContext().getRealPath("/")
							+ "picture/";
					filenames = new ArrayList<String>();
					
					
					for (FileItem fi : fileItems) {
						
				
						String fieldName = fi.getFieldName();
						String fieldValue = fi.getString();
						if (fieldName.equals("username")) {
							if (fieldValue != null) {
								user.setUsername(fieldValue);
							}
	
						}
						if (fieldName.equals("firstName"))
							user.setFirstName(fieldValue);
						if (fieldName.equals("lastName"))
							user.setLastName(fieldValue);
						if (fieldName.equals("password"))
							if (fieldValue != null) {
								user.setPassword(fieldValue);
							}
						if (fieldName.equals("email"))
							user.setEmail(fieldValue);
						
						if (fieldName.equals("type"))
							user.setType(fieldValue);
					}

			}
				catch (Exception ex) {
				System.out.println(ex);
			}
		}
			UserDAO userDao = new UserDAO();
			boolean isExist = false;
			List<User> allUsers = userDao.getAll();
			for (User user2 : allUsers) {
				if(user.getUsername().equals(user2.getUsername())){
					isExist = true;
				}
			}
			if(!isExist){
				userDao.add(user);
				response.sendRedirect("LoginUsersViewController");
				return;
			}else{
				response.sendRedirect("AddNewUserController");
			}
		}
		
}
}
		



