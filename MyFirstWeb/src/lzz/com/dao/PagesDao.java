package lzz.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lzz.com.util.DBUtil;
import lzz.com.vo.Pages;

public class PagesDao {
	private DBUtil util = DBUtil.getInstance();
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	public List<Pages> queryAllPages(int start) {
		conn = util.getConnection();
		sql = "select * from pages limit ?,4 ";
		List<Pages> list = new ArrayList<Pages>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			rs = ps.executeQuery();
			while (rs.next()) {
				Pages page = new Pages();
				page.setId(rs.getInt("id"));
				page.setTitle(rs.getString("title"));
				page.setImgname(rs.getString("imgname"));
				page.setDestination(rs.getString("destination"));
				page.setMaintxt(rs.getString("maintxt"));
				list.add(page);
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
	
	public Pages queryPageByID(int id){
		conn = util.getConnection();
		sql = "select * from pages where id = ?";
		Pages page = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				page = new Pages();
				page.setId(rs.getInt("id"));
				page.setTitle(rs.getString("title"));
				page.setImgname(rs.getString("imgname"));
				page.setDestination(rs.getString("destination"));
				page.setMaintxt(rs.getString("maintxt"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
		return page;
	}
	
	public void insertPage(Pages p) {
		conn = util.getConnection();
		sql = "insert into pages(title,imgname,destination,maintxt) value(?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getTitle());
			ps.setString(2, p.getImgname());
			ps.setString(3, p.getDestination());
			ps.setString(4, p.getMaintxt());
			ps.executeUpdate();
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
	}

	public int getCount() {
		conn = util.getConnection();
		sql = "select count(*) c from pages";
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
