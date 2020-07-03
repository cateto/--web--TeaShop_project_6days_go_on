package board.model;

public class BoardSQL {
	final static String LIST = "select * from BOARD order by b_SEQ desc";
	final static String INSERT = "insert into BOARD values(BOARD_SEQ.nextval, ?, ?, SYSDATE, 0)";
	final static String DEL = "delete from BOARD where b_SEQ=?";
	final static String UPDATE = "Update BOARD set bwriter=?, b_email=?, b_subject=?, b_content=? where b_seq=?";
	public static final String LIST_PAGE = null;
	public static final String COUNT = "select B_count from BOARD";
	public static final String SELECT_COUNT = "select count(*) from BOARD";
	public static final String CONTENT = "select * from BOARD where B_SEQ=?";
	
}
