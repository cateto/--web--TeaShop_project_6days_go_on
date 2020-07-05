package product.model;

import java.util.ArrayList;

import domain.Product;
import domain.ProductGift;
import domain.ProductTW;

public class ProductService {
	private ProductDAO dao;
	private static final ProductService instance = new ProductService();
	
	
	private ProductService() {
		dao = new ProductDAO();
	}
	
	public static final ProductService getInstance() {
		return instance;
	}
	
	public ArrayList<Product> listS() {
		return dao.list();
	}
	
	public ArrayList<Product> contentsS(long p_code) {
		return dao.contents(p_code);
	}
	
	public ArrayList<ProductTW> listTWS() {
		return dao.listTW();
	}
	
	public ArrayList<ProductTW> contentsTWS(long tw_code) {
		return dao.contentsTW(tw_code);
	}
	
	public ArrayList<ProductGift> listGiftS() {
		return dao.listGift();
	}
	
	public ArrayList<ProductGift> contentsGiftS(long g_code) {
		return dao.contentsGift(g_code);
	}
}
