package member.model;

import domain.Member;


public class MemberService {
	private MemberDAO dao;
	private static final MemberService instance = new MemberService();
	private MemberService() {
		dao = new MemberDAO();
	}
	public static MemberService getInstance() {
		return instance;
	}
	
	public int checkMember(String id) {
		Member m = dao.getMember(id);
		if(m == null) {
			return MemberSet.PASS; //중복 아이디가 없음!
		}else {
			return MemberSet.YES_ID; // 중복아이디가 있음!
		}
	}
	
	public Boolean join(Member m) {
		Boolean flag = dao.join(m);
		return flag;
	}
	
	public Boolean quit(Member m) {
		Boolean flag = false;
		if(dao.quit(m)) {
		 flag = dao.clean(m);
		}else {
			return false;
		}
		return flag;
	}

}
