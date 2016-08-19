/**
 * 
 */
package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.LoginBean;
import Common.ApplicationConstant;
import Service.AuthenServiceImpl;

/**
 * @author megapunk
 *
 */
public class Login extends HttpServlet {
	private AuthenServiceImpl loginServiceImpl;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String uName = request.getParameter("userName");
		String pass = request.getParameter("password");

		int status = 0;

		HttpSession session = request.getSession(false);

		LoginBean bean = new LoginBean();

		try {
			loginServiceImpl = new AuthenServiceImpl();
			bean = loginServiceImpl.doLogin(uName, pass);
			session.setAttribute("accountBean", bean);

			/*
			 * if(status != ApplicationConstant.AUTHEN_STATUS_NOT_LOGIN){
			 * session.setAttribute("accountBean", bean); if(status ==
			 * ApplicationConstant.AUTHEN_STATUS_ADMIN){
			 * session.setAttribute("accountBean", bean); } }
			 */
		} catch (ClassNotFoundException e) {
			System.err.println(e);
			e.printStackTrace();
		}

		if (bean.getFullname() != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginfailed.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(req, res);
	}
}
