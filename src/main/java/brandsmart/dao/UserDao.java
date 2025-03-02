package brandsmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import brandsmart.model.User;

public class UserDao {
	private Connection con;
	private String query;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
		try {
			query = "SELECT * FROM users WHERE email=? AND password=?";
			stmt = this.con.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return user;
	}
}
