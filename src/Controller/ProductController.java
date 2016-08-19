/**
 * 
 */
package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.ProductBean;
import Entities.ProductEntity;
import Service.ProductServiceImpl;

/**
 * @author megapunk
 *
 */
public class ProductController extends HttpServlet{
	private ProductServiceImpl productServiceImpl;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		productServiceImpl = new ProductServiceImpl();
		ProductBean pBean = new ProductBean();
		String cname = req.getParameter("cname");
		HttpSession httpSession = req.getSession(true);
		try {
			List<ProductEntity> pList = productServiceImpl.getProductList(cname);
			if(pList != null){
				pBean.setpList(pList);
			}
//		req.setAttribute("pBean", pBean);
			httpSession.setAttribute("pBean", pBean);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(req, res);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
