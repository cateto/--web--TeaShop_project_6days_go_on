package domain;

public class ProductTW {
	
	private Long tw_code;
	private String tw_type;
	private String tw_name;
	private Long tw_price;
	private Long tw_amount;
	private String tw_story;
	private String tw_img;
	private String tw_info;
	
	
	public ProductTW() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProductTW(Long tw_code, String tw_type, String tw_name, Long tw_price, Long tw_amount, String tw_story,
			String tw_img, String tw_info) {
		super();
		this.tw_code = tw_code;
		this.tw_type = tw_type;
		this.tw_name = tw_name;
		this.tw_price = tw_price;
		this.tw_amount = tw_amount;
		this.tw_story = tw_story;
		this.tw_img = tw_img;
		this.tw_info = tw_info;
	}


	public Long getTw_code() {
		return tw_code;
	}


	public void setTw_code(Long tw_code) {
		this.tw_code = tw_code;
	}


	public String getTw_type() {
		return tw_type;
	}


	public void setTw_type(String tw_type) {
		this.tw_type = tw_type;
	}


	public String getTw_name() {
		return tw_name;
	}


	public void setTw_name(String tw_name) {
		this.tw_name = tw_name;
	}


	public Long getTw_price() {
		return tw_price;
	}


	public void setTw_price(Long tw_price) {
		this.tw_price = tw_price;
	}


	public Long getTw_amount() {
		return tw_amount;
	}


	public void setTw_amount(Long tw_amount) {
		this.tw_amount = tw_amount;
	}


	public String getTw_story() {
		return tw_story;
	}


	public void setTw_story(String tw_story) {
		this.tw_story = tw_story;
	}


	public String getTw_img() {
		return tw_img;
	}


	public void setTw_img(String tw_img) {
		this.tw_img = tw_img;
	}


	public String getTw_info() {
		return tw_info;
	}


	public void setTw_info(String tw_info) {
		this.tw_info = tw_info;
	}
	
	
	
}
