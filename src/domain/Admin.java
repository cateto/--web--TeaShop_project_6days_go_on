package domain;

public class Admin {
	private static String admin = "gb11@naver.com";

	
	public Admin() {
	}

	public Admin(String admin) {
		this.admin = admin;
	}

	public static String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
}
