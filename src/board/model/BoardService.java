package board.model;

import java.util.ArrayList;
import java.util.List;

import board.vo.ListResult;
import domain.Board;

import domain.Member;

public class BoardService {
	private BoardDAO dao;
	private static final BoardService instance = new BoardService();
	private BoardService() {
		dao = new BoardDAO();
	}
	public static BoardService getInstance() {
		return instance;
	}
	public ListResult getListResult(int currentPage, int pageSize) {
		ArrayList<Board> list = dao.list(currentPage, pageSize);
		long totalCount = dao.getTotalCount();
		ListResult r = new ListResult(currentPage, totalCount, pageSize, list);
		
		return r;
	}
	public ArrayList<Board> listS(){
		return dao.list();
	}
	public ArrayList<Board> contentS(long seq){
		return dao.content(seq);
	}
	public boolean insertS(Board board) {
		return dao.insert(board);
	}
	public Board getBoardS(long seq) {
		return dao.getBoard(seq);
	}
	public boolean updateS(Board board){
		return dao.update(board);
	}
	public void delS(long seq){
		dao.del(seq);
	}
}
