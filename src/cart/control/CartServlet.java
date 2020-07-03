package cart.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart/cart.do")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String m = "";
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch(m) {
				case "cart": form(request, response); break;
				case "check": check(request, response); break;
				case "out": out(request, response); break;
				default: response.sendRedirect("../index.jsp");
			}
		}else {
			response.sendRedirect("../index.jsp");
		}
	}
	private void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "login.jsp";
		response.sendRedirect(view);
	}

}
