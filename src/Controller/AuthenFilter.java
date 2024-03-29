/**
 * 
 */
package Controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author megapunk
 *
 */
public class AuthenFilter implements Filter{

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse res = (HttpServletResponse) arg1;
		
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("accountBean") == null) {
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		} else {
			arg2.doFilter(req, res);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
}
