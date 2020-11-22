package fr.uge.webServices.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import fr.uge.webServices.commons.Client;
import fr.uge.webServices.project.Car;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Client client;
       
    /**
     * @throws ServiceException 
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() throws ServiceException {
        super();
        client = new Client();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Car[] cars = client.getCars();
		int amount = client.getAmountToPay();
		List<Car> cart = client.getCart();
		request.setAttribute("amount", amount);
		request.setAttribute("cars", cars);
		request.setAttribute("cart", cart);
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Car[] cars = client.getCars();
		for(int i=0;i<cars.length;i++) {
			if (request.getParameter(cars[i].getId().toString()) != null) {
				client.addToCart(i);
			}
		}
		int amount = client.getAmountToPay();
		request.setAttribute("amount", amount);
		this.doGet(request, response);
	}

}
