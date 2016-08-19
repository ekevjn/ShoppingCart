/**
 * 
 */
package Controller;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.LoginBean;
import Service.AuthenServiceImpl;

/**
 * @author megapunk
 *
 */
public class Register extends HttpServlet{
	AuthenServiceImpl authenServiceImpl;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		String uName = req.getParameter("userName");
		String pass = req.getParameter("password");
		String fname = req.getParameter("fullname");
		String rnumber = req.getParameter("rollnumber");
		
		boolean status = false;
		ResourceBundle rb = ResourceBundle.getBundle("resources.messages");
		
		try {
			authenServiceImpl = new AuthenServiceImpl();
			status = authenServiceImpl.doRegister(uName, pass, fname, rnumber);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		
		if(status){
			LoginBean bean = new LoginBean();
			bean.setUserName(uName);
			bean.setPassword(pass);
			HttpSession session = req.getSession(true);
			session.setAttribute("accountBean", bean);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(req, res);
		} else {
			req.setAttribute("mRegister", rb.getString("registerFail"));
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("registerfailed.jsp");
			requestDispatcher.forward(req, res);
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
		requestDispatcher.forward(req, res);
	}
}

