package brandsmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import brandsmart.model.*;

public class ProductDao {
	private Connection con;
	private String query;
	private PreparedStatement stmt;
	private ResultSet rs;
	public ProductDao(Connection con) {
		this.con = con;
	}
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<Product>();
		
		try {
			query = "SELECT * FROM products  ";
			stmt = this.con.prepareStatement(query);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Product row = new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getString("price"));
				row.setImage(rs.getString("image"));
				
				products.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}
}
