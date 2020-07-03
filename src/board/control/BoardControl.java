package board.control;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardService;
import board.vo.ListResult;
import boardQ.model.BoardQService;
import domain.Board;
import domain.BoardQ;
import domain.Member;
import oracle.net.aso.m;

@WebServlet("/board/board.do")
public class BoardControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch (m) {
				case "write": write(request, response); break;
				case "writeOk": writeOk(request, response); break;
				case "content": System.out.println("in"); content(request, response);break;
				case "update": getBoard(request, response, "update"); break;
				case "updateOk": updateOk(request, response); break;
				case "delete": del(request, response); break;
				case "insert": insertS(request, response); break;
				
				default: list(request, response); break;
			}
		}else {
			list(request, response); 
		}
	}

	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		HttpSession session = request.getSession();
		System.out.println("check1");
		
		//유저접속(테스트) 
		session.setAttribute("loginUser", "gb11@naver.com");//지울 아이디
		session.setAttribute("Admin", domain.Admin.getAdmin());//임포트안하면 이렇게한다!
		//(1) cp 
		int cp = 1;
		if(cpStr == null) {
			Object cpObj = session.getAttribute("cp");
			if(cpObj != null) {
				cp = (Integer)cpObj;
			}
		}else {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}
		session.setAttribute("cp", cp);
		
		//(2) ps 
		int ps = 3;
		if(psStr == null) {
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				ps = (Integer)psObj;
			}
		}else {
			psStr = psStr.trim();
			int psParam = Integer.parseInt(psStr);
			
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				int psSession = (Integer)psObj;
				if(psSession != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}else {
				if(ps != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}
			
			ps = psParam;
		}
		session.setAttribute("ps", ps);
		
		BoardService service = BoardService.getInstance();
		ListResult listResult = service.getListResult(cp, ps);
		System.out.println(listResult);
		System.out.println(listResult.getList().size());
		request.setAttribute("listResult", listResult);
		
		if(listResult.getList().size() == 0 && cp>1) {
			response.sendRedirect("board.do?m=list&cp="+(cp-1));
		}else {
			String view = "list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
	public void insertS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String b_subject = request.getParameter("b_subject");
		String b_content = request.getParameter("b_content");
		Board board = new Board(-1, b_subject, b_content, null,-1);
		
		BoardService service = BoardService.getInstance();
		boolean flag = service.insertS(board);
		request.setAttribute("flag", flag );
		
		String view = "insert.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
	}
	public void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String b_seqStr = request.getParameter("seq").trim();
		long b_seq = Long.parseLong(b_seqStr);
		BoardService service = BoardService.getInstance();
		Board board = service.getBoardS(b_seq);
		
		request.setAttribute("board", board);
		
		
		String view = "write.jsp";	
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}	
	public void writeOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String b_subject = request.getParameter("b_subject");
		String b_content = request.getParameter("b_content");
		String b_count = request.getParameter("b_count");
		
		
		BoardService service = BoardService.getInstance();
		boolean flag = service.insertS(new Board(-1, b_subject, b_content, null,-1));
		request.setAttribute("result", flag);
		request.setAttribute("kind", "writeOk");
		
		String view = "msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	public void getBoard(HttpServletRequest request, HttpServletResponse response, String view)
			throws ServletException, IOException {
		long seq = getSeq(request);
		if(seq != -1L) {
			BoardService service = BoardService.getInstance();
			Board board = service.getBoardS(seq);
			request.setAttribute("board", board);
			
			RequestDispatcher rd = request.getRequestDispatcher(view+".jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("board.do");
		}
	}
	public void updateOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long b_seq = getSeq(request);
		String b_subject = request.getParameter("b_subject");
		String b_content = request.getParameter("b_content");
		String b_count = request.getParameter("b_count");
	
		
		BoardService service = BoardService.getInstance();
		boolean flag = service.updateS(new Board(-1, b_subject, b_content, null,-1));
		request.setAttribute("result", flag);
		request.setAttribute("kind", "updateOk");
		
		String view = "msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void content(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	BoardService service = BoardService.getInstance();
		String seqStr =  request.getParameter("seq");
		if(seqStr != null) seqStr = seqStr.trim();
		long seq = Long.parseLong(seqStr);
		
		
		ArrayList<Board> contents = service.contentS(seq);
		request.setAttribute("contents", contents);
		
		String view = "content.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }
	
	public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long seq = getSeq(request);
		if(seq != -1L) {
			BoardService service = BoardService.getInstance();
			service.delS(seq);
		}
		response.sendRedirect("board.do");
	}
	
	private long getSeq(HttpServletRequest request) {
		long seq = -1L;
		String seqStr = request.getParameter("seq");
		if(seqStr != null) {
			seqStr = seqStr.trim();
			try {
				seq = Long.parseLong(seqStr);
			}catch(NumberFormatException ne) {
			}
		}
		
		return seq;
	}
}