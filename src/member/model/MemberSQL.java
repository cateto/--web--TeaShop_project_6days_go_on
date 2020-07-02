package member.model;

class MemberSQL {

	final static String JOIN = "insert into MEMBER values(?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
	final static String QUIT = "insert into MEMBER2 values(?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
	final static String CLEAN = "delete from MEMBER where M_ID = ?";
	final static String CHECK = "select * from MEMBER";
	

}
