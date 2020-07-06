package orders.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order/order.do")
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String m = "";
	
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch(m) {
				case "checkout": checkout(request, response); break;
				case "thankyou": thankyou(request, response); break;
				case "search": search(request, response); break;
				default: index(request, response);
			}
		}else {
			index(request, response);
		}
		
	}
	
	public void index(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "../index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	public void checkout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "checkout.jsp";
		response.sendRedirect(view);
	}
	
	public void thankyou(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("thankyou.jsp");
	}
	
	public void search(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("search.jsp");
	}
	
}
