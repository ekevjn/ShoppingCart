/**
 * 
 */
package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.CartBean;
import Beans.LoginBean;
import Service.ProductServiceImpl;

/**
 * @author megapunk
 *
 */
public class Checkout extends HttpServlet {
	private ProductServiceImpl productServiceImpl;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession httpSession = req.getSession(true);
		LoginBean loginBean = (LoginBean) httpSession.getAttribute("accountBean");
		if (loginBean == null || loginBean.getUserName() == null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, res);
		} else {
			CartBean cartBean = (CartBean) httpSession.getAttribute("cartBean");
			if (cartBean == null) {
				cartBean = new CartBean();
			}
			
			productServiceImpl = new ProductServiceImpl();

			try {
				productServiceImpl.processCheckout(cartBean, loginBean);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			httpSession.removeAttribute("cartBean");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(req, res);
		}

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
