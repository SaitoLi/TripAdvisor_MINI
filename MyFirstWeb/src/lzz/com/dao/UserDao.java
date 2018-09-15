package lzz.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lzz.com.util.DBUtil;
import lzz.com.vo.User;

public class UserDao {
	private DBUtil util = DBUtil.getInstance();
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public User queryByUserName(String username){
		conn = util.getConnection();
		sql = "select * from t_user where username = ?";
		User user = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUsername(username);
				user.setPassword(rs.getString("password"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
	
}
