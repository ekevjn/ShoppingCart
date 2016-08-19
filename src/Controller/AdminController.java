package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.BilldetailBean;
import Beans.CusbillBean;
import Beans.LoginBean;
import Beans.ProductBean;
import Entities.ProductEntity;
import Service.AuthenServiceImpl;
import Service.ProductServiceImpl;

public class AdminController extends HttpServlet {
	private ProductServiceImpl productServiceImpl;
	private AuthenServiceImpl authenServiceImpl;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		productServiceImpl = new ProductServiceImpl();
		authenServiceImpl = new AuthenServiceImpl();
		HttpSession httpSession = req.getSession(true);

		String method = req.getParameter("method");
		try {
			if (method == null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin.jsp");
				requestDispatcher.forward(req, res);
			} else {
				if (method.compareToIgnoreCase("cus") == 0) {
					List<LoginBean> loginBeans = new ArrayList<LoginBean>();
					loginBeans = productServiceImpl.getAllCustomer();
					if (loginBeans != null) {
						httpSession.removeAttribute("loginBeans");
						httpSession.setAttribute("loginBeans", loginBeans);
					}
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin2.jsp");
					requestDispatcher.forward(req, res);
				}

				if (method.compareToIgnoreCase("pro") == 0) {
					List<ProductEntity> productEntities;

					productEntities = productServiceImpl.getAllProduct();
					if (productEntities != null) {
						httpSession.removeAttribute("productEntities");
						ProductBean pBean = new ProductBean();
						pBean.setpList(productEntities);
						httpSession.setAttribute("productEntities", pBean);
					}
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin3.jsp");
					requestDispatcher.forward(req, res);
				}

				if (method.compareToIgnoreCase("bill") == 0) {
					List<CusbillBean> cusbillBeans = new ArrayList<CusbillBean>();
					
					cusbillBeans = productServiceImpl.getAllCusBill();
					if(cusbillBeans != null){
						httpSession.removeAttribute("cusbillBeans");
						httpSession.setAttribute("cusbillBeans", cusbillBeans);
					}
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin4.jsp");
					requestDispatcher.forward(req, res);
				}
				
				if(method.compareToIgnoreCase("billdetail") == 0){
					String billID = req.getParameter("billid");
					List<BilldetailBean> billdetailBeans = new ArrayList<BilldetailBean>();
					billdetailBeans = productServiceImpl.getCusBillDetail(billID);
					if(billdetailBeans != null){
						httpSession.removeAttribute("billdetailBeans");
						httpSession.setAttribute("billdetailBeans", billdetailBeans);
					}
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin5.jsp");
					requestDispatcher.forward(req, res);
				}
				
				if(method.compareToIgnoreCase("changestt") == 0){
					String billID = req.getParameter("billid");
					String stt = req.getParameter("stt");
					productServiceImpl.changeBillStatus(billID, stt);
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin4.jsp");
					requestDispatcher.forward(req, res);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
