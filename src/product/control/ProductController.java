package product.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardQ.model.BoardQService;
import domain.BoardQ;
import domain.Product;
import product.model.ProductService;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product/product.do")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			if(m.equals("list")){
				list(request, response);
			}
			if(m.equals("detail")){
				detail(request, response);
			}
		}else{
			list(request, response);
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ProductService service = ProductService.getInstance();
		ArrayList<Product> list = service.listS();
		request.setAttribute("list", list);
		
		String view = "tea.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }
	
	private void detail(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ProductService service = ProductService.getInstance();
		String codeStr =  request.getParameter("p_code");
		if(codeStr != null) codeStr = codeStr.trim();
		long p_code = Long.parseLong(codeStr);
		
		
		ArrayList<Product> contents = service.contentsS(p_code);
		request.setAttribute("contents", contents);
		
		String view = "shop-single.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }
}
