package controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class GenreFilter
 */
@WebServlet("/GenreFilter")
public class GenreFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenreFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int recordsPerPage = 4;
		if(request.getParameter("page")!=null){
				page = Integer.parseInt(request.getParameter("page"));
		}
		
		String genre = request.getParameter("genre");
		BookDAO bookDao = new BookDAO();
		List<Book> books = bookDao.getAll((page-1)*recordsPerPage, recordsPerPage,genre);	
		
		int noOfRecords = bookDao.getNoOfRecords();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		
		request.setAttribute("books", books);
		request.setAttribute("currentPage", page);
		request.setAttribute("noOfPages", noOfPages);
		
		RequestDispatcher rd = request.getRequestDispatcher("IndexByGenre.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
