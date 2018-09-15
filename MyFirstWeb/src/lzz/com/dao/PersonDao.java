package lzz.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lzz.com.util.DBUtil;
import lzz.com.vo.Person;

public class PersonDao {
	private DBUtil util = DBUtil.getInstance();
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	public List<Person> pageQueryPerson(int start, int pagesize) {
		conn = util.getConnection();
		sql = "select * from person limit ? , ?";
		List<Person> list = new ArrayList<Person>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, pagesize);
			rs = ps.executeQuery();
			while (rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setSex(rs.getString("sex"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	
	public int getCount(){
		conn = util.getConnection();
		sql = "select count(*) c from person";
		int recordCount = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				recordCount = rs.getInt("c");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return recordCount;
	}
}
