package fr.uge.webServices.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.uge.webServices.commons.Client;
import fr.uge.webServices.project.Car;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/payment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("haveAccount")!=null) {
			long id_test =  Long.valueOf(request.getParameter("account_id"));
			Client client = (Client) request.getSession().getAttribute("client");
			if (client.checkAccount(id_test)) {
				request.getSession().setAttribute("verif_account_id", id_test);
				request.getSession().setAttribute("amount_account", client.getAmountAccount());
				request.getSession().setAttribute("client", client);
			}
		}
		else if(request.getParameter("createAccount")!=null) {
			Client client = (Client) request.getSession().getAttribute("client");
			String currency =  request.getParameter("currency");
			double amount = Double.valueOf(request.getParameter("deposit"));
			System.out.println("avant: "+client.bankSize());
			if (client.createAccount(currency)) {
				System.out.println(client.getAccount_id());
				System.out.println(client.bankSize());
				client.depositOf(amount);
			}
		}
		else if(request.getParameter("disconnect")!=null) {
			Client client = (Client) request.getSession().getAttribute("client");
			client.setAccount_id(-1);
			request.getSession().setAttribute("client", client);
		}
		else if(request.getParameter("makeADeposit")!=null) {
			Client client = (Client) request.getSession().getAttribute("client");
			double amount = Double.valueOf(request.getParameter("deposit"));
			client.depositOf(amount);
			request.getSession().setAttribute("client", client);
		}else if(request.getParameter("BUY")!=null) {
			Client client = (Client) request.getSession().getAttribute("client");
			List<Car> cars = client.getCart();
			if (client.buy()) {
				request.getSession().setAttribute("achat", "fait");
				request.getSession().setAttribute("achats", cars);
			}else {
				request.getSession().setAttribute("achat", "erreur");
			}
			request.getSession().setAttribute("client", client);
		}
		doGet(request, response);
	}

}
