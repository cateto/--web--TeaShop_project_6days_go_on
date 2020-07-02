package login.model;

import domain.Member;

public class LoginService {
	private LoginDAO dao;
	private static final LoginService instance = new LoginService();
	private LoginService() {
		dao = new LoginDAO();
	}
	public static LoginService getInstance() {
		return instance;
	}
	
	public int checkMember(String id, String pwd) {
		Member m = dao.getMember(id);
		if(m == null) {
			return LoginSet.NO_ID; //�׷� �̸����� ���� ȸ���� ����
		}else {
			String pwdDb = m.getM_pwd();
			if(pwdDb != null) pwdDb = pwdDb.trim();
			
			if(!pwd.equals(pwdDb)) {
				return LoginSet.NO_PWD; //PWD����ġ 
			}else {
				return LoginSet.PASS; //PWD ��ġ 
			}
		}
	}
	
	public Member getMemberS(String id) {
		Member m = dao.getMember(id);
		m.setM_pwd("");
		
		return m;
	}
}
