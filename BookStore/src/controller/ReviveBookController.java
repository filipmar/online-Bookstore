package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Book;
import model.dao.BookDAO;

/**
 * Servlet implementation class ReviveBookController
 */
@WebServlet("/ReviveBookController")
public class ReviveBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviveBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookID = Integer.valueOf(request.getParameter("bID"));
		
		BookDAO bookDao = new BookDAO();
		List<Book> allBooks = bookDao.getAll();
		
		for (Book book : allBooks) {
			if(book.getId() == bookID){
				book.setStatus("active");
				bookDao.delete(book);
			}
		}
		
		RequestDispatcher rq = request.getRequestDispatcher("LoginBookPreviewViewController");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
