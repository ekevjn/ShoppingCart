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

import Beans.ManBean;
import Service.ProductServiceImpl;

/**
 * @author megapunk
 *
 */
public class ManController extends HttpServlet{
	private ProductServiceImpl productServiceImpl;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		productServiceImpl = new ProductServiceImpl();
		ManBean manBean = new ManBean();
		HttpSession httpSession = req.getSession(true);
		try {
			List<String> mList = productServiceImpl.getManList();
			if(mList != null){
				manBean.setmName(mList);
			}
//		req.setAttribute("manBean", manBean);
		if(httpSession == null || httpSession.getAttribute("mmanBean") == null){
			httpSession.setAttribute("mmanBean", manBean);
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(req, res);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
