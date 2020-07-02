package member.control;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.model.LoginService;
import login.model.LoginSet;
import member.model.MemberService;
import member.model.MemberSet;
import domain.Member;

@WebServlet("/member/member.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String m = "";
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch(m) {
				case "form": form(request, response); break;
				case "check": check(request, response); break;
				case "join": join(request, response); break;
				case "congrats": congrats(request, response); break;
				case "out": out(request, response); break;
				default: response.sendRedirect("../index.do");
			}
		}else {
			response.sendRedirect("../index.do");
		}
	}
	private void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "join.jsp";
		response.sendRedirect(view);
	}
	private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String id = request.getParameter("id");
	    String pwd = request.getParameter("pwd");
	    String name = request.getParameter("name");
	    String birth = request.getParameter("birth");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    String addr = request.getParameter("addr");
	    String addr2 = request.getParameter("addr2");
	    if(id != null) id = id.trim();
	    if(pwd != null) pwd = pwd.trim();
	    if(pwd != null) name = name.trim();
	    if(pwd != null) birth = birth.trim();
	    if(pwd != null) email = email.trim();
	    if(pwd != null) phone = phone.trim();
	    if(pwd != null) addr = addr.trim();
	    if(pwd != null) addr2 = addr2.trim();
	    
	    MemberService service = MemberService.getInstance();
	    int rCode = service.checkMember(id);
	    request.setAttribute("rCode", rCode);
	    if(rCode==MemberSet.PASS) {
	    	
	    }else {
	    	
	    }
	    
	    if(rCode == LoginSet.PASS) {
	    	HttpSession session = request.getSession();
	    	//Member m = service.getMemberS(id);
	    	session.setAttribute("loginUser", m);
	    }
	    
	    String view = "login_msg.jsp";
	    RequestDispatcher rd = request.getRequestDispatcher(view);
	    rd.forward(request, response);
	}
	
	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String id = request.getParameter("id");
	    String pwd = request.getParameter("pwd");
	    String name = request.getParameter("name");
	    String birthStr = request.getParameter("birth");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    String addr = request.getParameter("addr");
	    String addr2 = request.getParameter("addr2");
	    if(id != null) id = id.trim();
	    if(pwd != null) pwd = pwd.trim();
	    if(pwd != null) name = name.trim();
	    if(pwd != null) birthStr = birthStr.trim();
	    if(pwd != null) email = email.trim();
	    if(pwd != null) phone = phone.trim();
	    if(pwd != null) addr = addr.trim();
	    if(pwd != null) addr2 = addr2.trim();
	    
	    Date birth = null;
	    try {
		    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    java.util.Date utilBirthStr = dateFormat.parse(birthStr);
		    birth = new java.sql.Date(utilBirthStr.getTime());
	    }catch(ParseException pe) {}
	    
	    MemberService service = MemberService.getInstance();
	    Member member = new Member(id, pwd, name, birth, phone, email, addr, addr2, null);
	    Boolean rCode = service.join(member);
	    
	    HttpSession session = request.getSession();
	    session.setAttribute("member", member);

	    if(rCode) {
		    response.sendRedirect("member.do?m=congrats");
	    }
	}
	
	private void congrats(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String view = "congrats.jsp";
		response.sendRedirect(view);
	}
	
	private void out(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//session.removeAttribute("loginUser");
		session.invalidate();
		
		String view = "../index.html";
		response.sendRedirect(view);
	}
}
