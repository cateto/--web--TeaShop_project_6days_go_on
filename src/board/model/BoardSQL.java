package board.model;

public class BoardSQL {
	final static String LIST = "select * from BOARD order by b_SEQ desc";
	final static String INSERT = "insert into BOARD values(BOARD_SEQ.nextval, ?, ?, SYSDATE, 0)";
	final static String DEL = "delete from BOARD where b_SEQ=?";
	final static String UPDATE = "Update BOARD set b_subject=?, b_content=?, b_date=SYSDATE where b_seq=?";
	//public static String LIST_PAGE = null;
	public static String COUNT = "select B_count from BOARD";
	public static String SELECT_COUNT = "select count(*) from BOARD";
	public static String CONTENT = "select * from BOARD where B_SEQ=?";
	
}
