package domain;

public class ProductGift {
	
	private Long g_code;
	private String g_type;
	private String g_name;
	private Long g_price;
	private Long g_amount;
	private String g_story;
	private String g_img;
	private String g_info;
	
	
	public ProductGift() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProductGift(Long g_code, String g_type, String g_name, Long g_price, Long g_amount, String g_story,
			String g_img, String g_info) {
		super();
		this.g_code = g_code;
		this.g_type = g_type;
		this.g_name = g_name;
		this.g_price = g_price;
		this.g_amount = g_amount;
		this.g_story = g_story;
		this.g_img = g_img;
		this.g_info = g_info;
	}


	public Long getG_code() {
		return g_code;
	}


	public void setG_code(Long g_code) {
		this.g_code = g_code;
	}


	public String getG_type() {
		return g_type;
	}


	public void setG_type(String g_type) {
		this.g_type = g_type;
	}


	public String getG_name() {
		return g_name;
	}


	public void setG_name(String g_name) {
		this.g_name = g_name;
	}


	public Long getG_price() {
		return g_price;
	}


	public void setG_price(Long g_price) {
		this.g_price = g_price;
	}


	public Long getG_amount() {
		return g_amount;
	}


	public void setG_amount(Long g_amount) {
		this.g_amount = g_amount;
	}


	public String getG_story() {
		return g_story;
	}


	public void setG_story(String g_story) {
		this.g_story = g_story;
	}


	public String getG_img() {
		return g_img;
	}


	public void setG_img(String g_img) {
		this.g_img = g_img;
	}


	public String getG_info() {
		return g_info;
	}


	public void setG_info(String g_info) {
		this.g_info = g_info;
	}
	
	
	

}
