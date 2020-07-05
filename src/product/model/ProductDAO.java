package product.model;

import static product.model.ProductSQL.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Product;
import domain.ProductGift;
import domain.ProductTW;

public class ProductDAO {
	
	private DataSource ds;
	ProductDAO(){
		try {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		ds = (DataSource)envContext.lookup("jdbc/myoracle");
		
		}catch(NamingException ne) {
			System.out.println("Apache DBCP 객체 찾지 못함");
		}
	}
	
	ArrayList<Product> list(){
		ArrayList<Product> list = new ArrayList<Product>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
	    String sql = PRODUCT_LIST;

		try{
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				long p_code = rs.getLong("P_CODE");
				String p_type = rs.getString("P_TYPE");
				String p_name = rs.getString("P_NAME");
				long p_price = rs.getLong("P_PRICE");
				long p_amount = rs.getLong("P_AMOUNT");
				String p_story = rs.getString("P_STORY");
				String p_img = rs.getString("P_IMG");
				list.add(new Product(p_code, p_type, p_name, p_price, p_amount, p_story, p_img));
				}
				return list;
			}catch(SQLException se){
				System.out.println(se);
				return null;
			}finally{
				try{
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(con != null)  con.close();
				}catch(SQLException se){}
			}  
	}
	
	ArrayList<Product> contents(long p_code){
		 ArrayList<Product> contents = new ArrayList<Product>();
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
		    String sql = "select * from PRODUCT where P_CODE ="+ p_code;
		    
		    try{
				con = ds.getConnection();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					p_code = rs.getLong("P_CODE");
					String p_type = rs.getString("P_TYPE");
					String p_name = rs.getString("P_NAME");
					long p_price = rs.getLong("P_PRICE");
					long p_amount = rs.getLong("P_AMOUNT");
					String p_story = rs.getString("P_STORY");
					String p_img = rs.getString("P_IMG");
					contents.add(new Product(p_code, p_type, p_name, p_price, p_amount, p_story, p_img));
				}
				return contents;
			}catch(SQLException se){
				System.out.println(se);
				return null;
			}finally{
					try{
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
						if(con != null)  con.close();
					}catch(SQLException se){}
				}  
	 }
	
	
	ArrayList<ProductTW> listTW(){
		ArrayList<ProductTW> listTW = new ArrayList<ProductTW>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
	    String sql = TEAWARE_LIST;

		try{
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				long tw_code = rs.getLong("TW_CODE");
				String tw_type = rs.getString("TW_TYPE");
				String tw_name = rs.getString("TW_NAME");
				long tw_price = rs.getLong("TW_PRICE");
				long tw_amount = rs.getLong("TW_AMOUNT");
				String tw_story = rs.getString("TW_STORY");
				String tw_img = rs.getString("TW_IMG");
				String tw_info = rs.getString("TW_INFO");
				listTW.add(new ProductTW(tw_code, tw_type, tw_name, tw_price, tw_amount, tw_story, tw_img, tw_info));
				}
				return listTW;
			}catch(SQLException se){
				System.out.println(se);
				return null;
			}finally{
				try{
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(con != null)  con.close();
				}catch(SQLException se){}
			}  
	}
	
	ArrayList<ProductTW> contentsTW(long tw_code){
		 ArrayList<ProductTW> contentsTW = new ArrayList<ProductTW>();
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
		    String sql = "select * from TW_PRODUCT where TW_CODE ="+ tw_code;
		    
		    try{
				con = ds.getConnection();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					tw_code = rs.getLong("TW_CODE");
					String tw_type = rs.getString("TW_TYPE");
					String tw_name = rs.getString("TW_NAME");
					long tw_price = rs.getLong("TW_PRICE");
					long tw_amount = rs.getLong("TW_AMOUNT");
					String tw_story = rs.getString("TW_STORY");
					String tw_img = rs.getString("TW_IMG");
					String tw_info = rs.getString("TW_INFO");
					contentsTW.add(new ProductTW(tw_code, tw_type, tw_name, tw_price, tw_amount, tw_story, tw_img, tw_info));
				}
				return contentsTW;
			}catch(SQLException se){
				System.out.println(se);
				return null;
			}finally{
					try{
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
						if(con != null)  con.close();
					}catch(SQLException se){}
				}  
	 }
	
	ArrayList<ProductGift> listGift(){
		ArrayList<ProductGift> listGift = new ArrayList<ProductGift>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
	    String sql = GIFTSET_LIST;

		try{
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				long g_code = rs.getLong("G_CODE");
				String g_type = rs.getString("G_TYPE");
				String g_name = rs.getString("G_NAME");
				long g_price = rs.getLong("G_PRICE");
				long g_amount = rs.getLong("G_AMOUNT");
				String g_story = rs.getString("G_STORY");
				String g_img = rs.getString("G_IMG");
				String g_info = rs.getString("G_INFO");
				listGift.add(new ProductGift(g_code, g_type, g_name, g_price, g_amount, g_story, g_img, g_info));
				}
				return listGift;
			}catch(SQLException se){
				System.out.println(se);
				return null;
			}finally{
				try{
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(con != null)  con.close();
				}catch(SQLException se){}
			}  
	}
	
	ArrayList<ProductGift> contentsGift(long g_code){
		 ArrayList<ProductGift> contentsGift = new ArrayList<ProductGift>();
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
		    String sql = "select * from G_PRODUCT where G_CODE ="+ g_code;
		    
		    try{
				con = ds.getConnection();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					g_code = rs.getLong("G_CODE");
					String g_type = rs.getString("G_TYPE");
					String g_name = rs.getString("G_NAME");
					long g_price = rs.getLong("G_PRICE");
					long g_amount = rs.getLong("G_AMOUNT");
					String g_story = rs.getString("G_STORY");
					String g_img = rs.getString("G_IMG");
					String g_info = rs.getString("G_INFO");
					contentsGift.add(new ProductGift(g_code, g_type, g_name, g_price, g_amount, g_story, g_img, g_info));
				}
				return contentsGift;
			}catch(SQLException se){
				System.out.println(se);
				return null;
			}finally{
					try{
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
						if(con != null)  con.close();
					}catch(SQLException se){}
				}  
	 }
}
