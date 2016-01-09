package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.beans.Book;
import model.beans.Order;
import model.beans.Purchaser;
import model.dao.BookDAO;
import model.dao.OrderDAO;
import model.dao.PurchaserDAO;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		BookDAO bookDao = new BookDAO();
		Book book = bookDao.getBookByID(Integer.parseInt(request.getParameter("bId")));
		@SuppressWarnings("unchecked")
		List<Book> booksInCart = (List<Book>) session.getAttribute("booksInCart");
		if(booksInCart == null){
			booksInCart = new ArrayList<Book>();
		}
		booksInCart.add(book);
		System.out.println(book.getPrice());

		request.getSession().setAttribute("booksInCart", booksInCart);
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Book> booksInCart= (List<Book>) session.getAttribute("booksInCart");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String adress = request.getParameter("adress");
		int zipCode = Integer.parseInt(request.getParameter("zipCode"));
		String city = request.getParameter("city");
		int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
		String granted = request.getParameter("granted");
		String email = request.getParameter("email");
		
		Purchaser purchaser = new Purchaser(firstName, lastName, adress, zipCode, city, phoneNumber,email);
		PurchaserDAO purchaserDao = new PurchaserDAO();
		purchaserDao.add(purchaser);
		
		List<Purchaser> purchasersList = purchaserDao.getAll();
		ArrayList<Integer> purchaserIds = new ArrayList<Integer>();
		for (Purchaser purchaser2 : purchasersList) {
			purchaserIds.add(purchaser2.getId());
		}
		int purchaserID = Collections.max(purchaserIds);
		for (Purchaser pur : purchasersList) {
			if(purchaserID == pur.getId()){
				purchaser = pur;
			}
		}
		
		for (Book book : booksInCart) {
			OrderDAO orderDao = new OrderDAO();
			Order order = new Order(purchaser, granted);
			orderDao.add(order,book, purchaser);
		}
		
		session.invalidate();
		response.sendRedirect("");
		
		
	}

}
