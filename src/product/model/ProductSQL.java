package product.model;

public class ProductSQL {
	static final String PRODUCT_LIST = "select * from PRODUCT order by P_NAME desc";
	static final String TEAWARE_LIST = "select * from TW_PRODUCT order by TW_NAME desc";
	static final String GIFTSET_LIST = "select * from G_PRODUCT order by G_NAME desc";
}
