package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Book;
import model.beans.Order;
import model.beans.Purchaser;
import model.dao.BookDAO;
import model.dao.OrderDAO;
import model.dao.PurchaserDAO;

/**
 * Servlet implementation class LoginOrdersViewController
 */
@WebServlet("/LoginOrdersViewController")
public class LoginOrdersViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOrdersViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderDAO orderDao = new OrderDAO();
		List<Order> allOrders = orderDao.getAll();
		request.setAttribute("allOrders", allOrders);
		
		double totalPrice = 0;
		int totalOrderes = 0;
		int totalDeliveredOrders= 0;
			
		
		for (Order order : allOrders) {
			if(order.getGranted().equals("ordered")){
				totalOrderes += 1;
			}
			if(order.getGranted().equals("delivered")){
				totalDeliveredOrders += 1;
				totalPrice += order.getBook().getPrice();
				totalOrderes += 1;
			}
			if(order.getGranted().equals("sent")){
				totalOrderes += 1;
			}
			if(order.getGranted().equals("cancel")){
				totalOrderes += 1;
			}
		}
		
		String priceValue = String.format("%.2f", totalPrice);
		double totalPrice2 = Double.parseDouble(priceValue);
		request.setAttribute("totalPrice", totalPrice2);
		request.setAttribute("totalOrderes", totalOrderes);
		request.setAttribute("totalDeliveredOrders", totalDeliveredOrders);
		
		RequestDispatcher rq = request.getRequestDispatcher("loginOrders.jsp");
		rq.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
