/**
 * 
 */
package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.CartBean;
import Entities.CartEntity;
import Entities.ProductEntity;
import Service.ProductServiceImpl;

/**
 * @author megapunk
 *
 */
public class Add2Cart extends HttpServlet {
	private ProductServiceImpl productServiceImpl;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String pId = req.getParameter("pId");
		String method = req.getParameter("method");

		HttpSession httpSession = req.getSession(true);
		CartBean cartBean = (CartBean) httpSession.getAttribute("cartBean");
		if (cartBean == null) {
			cartBean = new CartBean();
		}
		if (method != null) {
			if (method.compareToIgnoreCase("add") == 0) {
				productServiceImpl = new ProductServiceImpl();
				boolean foundItem = false;
				if (cartBean != null) {
					for (CartEntity bean : cartBean.getcList()) {
						if (bean.getpId().compareToIgnoreCase(pId) == 0) {
							ProductEntity productEntity = null;
							try {
								productEntity = productServiceImpl.getProduct(pId);

								bean.setQuanlity(bean.getQuanlity() + 1);
								bean.setPrice(Float.parseFloat(productEntity.getPrice()));
								bean.setTotal(bean.getQuanlity() * Float.parseFloat(productEntity.getPrice()));

								foundItem = true;
							} catch (ClassNotFoundException | SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
				if (!foundItem) {
					ProductEntity productEntity = null;
					try {
						productEntity = productServiceImpl.getProduct(pId);
						CartEntity bean = new CartEntity(pId, productEntity.getPname(), 1,
								Float.parseFloat(productEntity.getPrice()), Float.parseFloat(productEntity.getPrice()));
						cartBean.getcList().add(bean);
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
			}

			if (method.compareToIgnoreCase("remove") == 0) {
				List<CartEntity> cList = new ArrayList<CartEntity>();

				/*
				 * ListIterator<CartEntity> itl = (ListIterator<CartEntity>)
				 * cartBean.getcList().iterator(); while(itl.hasNext()){
				 * if(!itl.next().getpId().equalsIgnoreCase(pId)){
				 * cList.add(itl.next()); } }
				 */

				for (CartEntity bean : cartBean.getcList()) {
					if (bean.getpId().compareToIgnoreCase(pId) != 0) {
						// cartBean.removeEn(bean);
						cList.add(bean);
					}
				}
				cartBean.setcList(cList);
			}

			if (method.compareToIgnoreCase("removeall") == 0) {
				cartBean = new CartBean();
			}

			if (method.compareToIgnoreCase("update") == 0) {
			}
		}

		float totalprice = 0;
		for (CartEntity bean : cartBean.getcList()) {
			totalprice += bean.getTotal();
		}

		cartBean.setTotalprice(totalprice);
		httpSession.removeAttribute("cartBean");
		httpSession.setAttribute("cartBean", cartBean);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("checkout.jsp");
		requestDispatcher.forward(req, res);
	}
}
