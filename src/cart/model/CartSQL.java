package cart.model;

class CartSQL {
	final static String INSERT = "insert into CART values(?, ?, ?)";
	//cart�� ��ǰ ���� �߰�
	final static String DELETE = "delete from CART where M_ID=?";
	//cart�� �ִ� ��ǰ ��ü ����
	final static String DELETE2 = "delete from CART where M_ID=? and P_CODE=?";
	//cart�� �ִ� �ش� ��ǰ�� ����
	final static String UPDATE = "update CART set P_AMOUNT=? where M_ID=? and P_CODE=?";
	//cart�� �ִ� �ش�ȸ���� �ش� ��ǰ�� ���� ������Ʈ
	final static String SELECT = "select P.P_CODE, P.P_IMG, P.P_NAME, P.P_PRICE, C.P_AMOUNT from PRODUCT P join CART C on P.P_CODE=C.P_CODE where C.M_ID=?";
	//cart ��ǰ ��ü �˻�
}
