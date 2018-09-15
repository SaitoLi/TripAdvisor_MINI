package lzz.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lzz.com.util.DBUtil;
import lzz.com.vo.Student;

public class StudentDao {
	private DBUtil util = DBUtil.getInstance();
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	//查询所有学生信息
	public List<Student> queryAllstu(){
		conn = util.getConnection();
		//System.out.println("查询所有学生信息");
		sql = "select * from student";
		List<Student> list = new ArrayList<Student>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setStuname(rs.getString("stuname"));
				s.setAge(rs.getInt("age"));
				s.setScore(rs.getInt("score"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(conn!=null) {}
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	//根据ID查询学生信息
	public Student queryStuById(int id){
		conn = util.getConnection();
		//System.out.println("按ID查询学生信息");
		sql = "select * from student where id = ?";
		Student s = new Student();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			if(rs.next()) {
				s.setId(rs.getInt("id"));
				s.setStuname(rs.getString("stuname"));
				s.setAge(rs.getInt("age"));
				s.setScore(rs.getDouble("score"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(conn!=null) {}
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return s;
	}

	//添加一条学生信息
	public void insertStu(Student s){
		conn = util.getConnection();
		//System.out.println("插入学生信息");
		sql = "insert into student(id, stuname, age , score) values(?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getId());
			ps.setString(2, s.getStuname());
			ps.setInt(3, s.getAge());
			ps.setDouble(4, s.getScore());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(conn!=null) {}
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//删除学生信息
	public void deleteStu(int id){
		conn = util.getConnection();
		//System.out.println("删除学生信息");
		sql = "delete from student where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//更改学生信息
	public void updateStu(Student s , Double sco){
		conn = util.getConnection();
		//System.err.println("更新学生信息");
		sql = "update student set score = ? where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, sco);
			ps.setInt(2, s.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
