package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Order;
import model.dao.BookDAO;
import model.dao.OrderDAO;

/**
 * Servlet implementation class CancelOrderedOrderController
 */
@WebServlet("/CancelOrderedOrderController")
public class CancelOrderedOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderedOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int orderID = Integer.valueOf(request.getParameter("oID"));

		OrderDAO orderDao = new OrderDAO();
		List<Order> allOrders = orderDao.getAll();
		
		for (Order order : allOrders) {
			if(order.getId() == orderID){
				for (Order order2 : allOrders) {
					if(order.getPurchaser().getId() == order2.getPurchaser().getId()){
						order2.setGranted("cancel");
						orderDao.updateStatus(order2);
					}
				}
				
			}
		}
		RequestDispatcher rq = request.getRequestDispatcher("LoginOrdersViewController");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
