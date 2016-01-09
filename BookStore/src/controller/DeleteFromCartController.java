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
import javax.servlet.http.HttpSession;

import model.beans.Book;
import model.dao.BookDAO;

/**
 * Servlet implementation class DeleteFromCartController
 */
@WebServlet("/DeleteFromCartController")
public class DeleteFromCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFromCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		BookDAO bookDao = new BookDAO();
		Book book = bookDao.getBookByID(Integer.parseInt(request.getParameter("bId")));
		System.out.println(book.getId());
		@SuppressWarnings("unchecked")
		ArrayList<Book> booksInCart = (ArrayList<Book>) session.getAttribute("booksInCart");
		for (Book book2 : booksInCart) {
			if(book2.getId() == book.getId()){
				booksInCart.remove(book2);
				break;
			}
		}
		request.getSession().setAttribute("booksInCart", booksInCart);
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
