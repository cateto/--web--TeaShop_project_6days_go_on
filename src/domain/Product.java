package domain;

public class Product {


	private Long p_code;
	private String p_type;
	private String p_name;
	private Long p_price;
	private Long p_amount;
	private String p_story;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(Long p_code, String p_type, String p_name, Long p_price, Long p_amount, String p_story) {
		super();
		this.p_code = p_code;
		this.p_type = p_type;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_amount = p_amount;
		this.p_story = p_story;
	}


	public Long getP_code() {
		return p_code;
	}


	public void setP_code(Long p_code) {
		this.p_code = p_code;
	}


	public String getP_type() {
		return p_type;
	}


	public void setP_type(String p_type) {
		this.p_type = p_type;
	}


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public Long getP_price() {
		return p_price;
	}


	public void setP_price(Long p_price) {
		this.p_price = p_price;
	}


	public Long getP_amount() {
		return p_amount;
	}


	public void setP_amount(Long p_amount) {
		this.p_amount = p_amount;
	}


	public String getP_story() {
		return p_story;
	}


	public void setP_story(String p_story) {
		this.p_story = p_story;
	}
	
	

}
