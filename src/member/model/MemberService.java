package member.model;

import java.sql.Date;

import domain.Member;
import login.model.LoginSet;


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
			return MemberSet.PASS; //�ߺ� ���̵� ����!
		}else {
			return MemberSet.YES_ID; // �ߺ����̵� ����!
		}
	}
	
	public int checkPwd(String id, String pwd) {
		Member m = dao.getMember(id);
		if(m != null) {
			String pwdDb = m.getM_pwd();
			if(pwdDb != null) pwdDb = pwdDb.trim();
			
			if(!pwd.equals(pwdDb)) {
				return MemberSet.NO_PWD; //PWD����ġ 
			}else {
				return MemberSet.YES_ID; //PWD ��ġ 
			}
		}else { 
			return MemberSet.PASS; // ID�� ����
		}
	}
	
	public Boolean join(Member m) {
		Boolean flag = dao.join(m);
		return flag;
	}
	
	public Boolean edit(Member m) {
		Boolean flag = dao.edit(m);
		return flag;
	}
	
	public Member getMember(String id) {
		return dao.getMember(id);
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
	
	public String findID(String name, Date birth) {
		String id = dao.findID(name, birth);
		if(id != null) {
			return id; // ID �ٰ� 
		}else { 
			return null; // ID�� ����
		}
	}

	public String findPWD(String id, String email) {
		String pwd = dao.findPWD(id, email);
		if(pwd != null) {
			return pwd; //PWD �ٰ�
		}else { 
			return null; // PWD ����
		}
	}	
	
}
