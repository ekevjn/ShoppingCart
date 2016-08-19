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

/**
 * @author megapunk
 *
 */
public class Logout extends HttpServlet{
	protected void doGet (HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		res.setContentType("text/html");
		
		HttpSession session = req.getSession();
		if(session != null){
			session.invalidate();
		}
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(req, res);
	}
}
