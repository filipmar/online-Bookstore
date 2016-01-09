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

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import model.beans.Book;
import model.beans.User;
import model.dao.BookDAO;

/**
 * Servlet implementation class UpdateBookController
 */
@WebServlet("/UpdateBookController")
public class UpdateBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 5 * 1024 * 1024; //5 MB
    private int maxMemSize = 1024 * 1024; //1 MB
    private File file ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer bID = Integer.valueOf(request.getParameter("bID"));
		BookDAO bookDao = new BookDAO();
		List<Book> allBooks = bookDao.getAll();
		for (Book book : allBooks) {
			if(book.getId() == bID){
				request.setAttribute("book", book);
				
			}
		}
		RequestDispatcher rq = request.getRequestDispatcher("updateBook.jsp");
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
			request.getRequestDispatcher("login.jsp").forward(request,
					response);
	}else{
		Book book = new Book();
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
					if (!fi.isFormField()) {
						// Get the uploaded file parameters
						}
			else{
				String fieldName = fi.getFieldName();
				String fieldValue = fi.getString();
				if(fieldName.equals("id")){
					book.setId(Integer.parseInt(fieldValue));
				}
				if (fieldName.equals("title")) {
					if (fieldValue != null) {
						book.setTitle(fieldValue);;
					}

				}
				if (fieldName.equals("authors"))
					book.setAuthors(fieldValue);
				if (fieldName.equals("publisher"))
					book.setPublisher(fieldValue);
				if (fieldName.equals("description"))
					if (fieldValue != null) {
						book.setDescription(fieldValue);
					}
				if (fieldName.equals("genre"))
					book.setGenre(fieldValue);
				if (fieldName.equals("numberInStock"))
					book.setNumberInStock(Integer.parseInt(fieldValue));
				if (fieldName.equals("publicationYear"))
					book.setPublicationYear(Integer.parseInt(fieldValue));
				if (fieldName.equals("price"))
					book.setPrice(Double.parseDouble(fieldValue));
				if (fieldName.equals("file"))
					book.setPictureURL(fieldValue);
			}

		}
			}catch (Exception ex) {
			System.out.println(ex);
		}
	}

		BookDAO bookDao = new BookDAO();
		bookDao.update(book);
		
		response.sendRedirect("LoginBookPreviewViewController");
	}
	}
}


