package domain;

import java.sql.Date;

public class Order {
	
	private long o_seq;
	private long p_code;
	private long p_amount;
	private long p_name;
	private String m_id;
	private Date b_date;
	
	public Order() {
		
	}

	public Order(long o_seq, long p_code, long p_amount, long p_name, String m_id, Date b_date) {

		this.o_seq = o_seq;
		this.p_code = p_code;
		this.p_amount = p_amount;
		this.p_name = p_name;
		this.m_id = m_id;
		this.b_date = b_date;
	}

	public long getO_seq() {
		return o_seq;
	}

	public void setO_seq(long o_seq) {
		this.o_seq = o_seq;
	}

	public long getP_code() {
		return p_code;
	}

	public void setP_code(long p_code) {
		this.p_code = p_code;
	}

	public long getP_amount() {
		return p_amount;
	}

	public void setP_amount(long p_amount) {
		this.p_amount = p_amount;
	}

	public long getP_name() {
		return p_name;
	}

	public void setP_name(long p_name) {
		this.p_name = p_name;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public Date getB_date() {
		return b_date;
	}

	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	
	


}
