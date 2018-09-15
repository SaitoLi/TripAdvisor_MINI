package lzz.com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lzz.com.util.DBUtil;

public class Test {
	public static void main(String[] args) {

		DBUtil util = DBUtil.getInstance();
		Connection conn = util.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into person(name, age, sex) values(?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 1; i < 300; i++) {

				ps.setString(1, "Name" + i);
				ps.setInt(2, (int) (Math.random() * 100));
				if (i % 3 == 0) {
					ps.setString(3, "ÄÐ");
				} else {
					ps.setString(3, "Å®");
				}
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
