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
	
	//��ѯ����ѧ����Ϣ
	public List<Student> queryAllstu(){
		conn = util.getConnection();
		//System.out.println("��ѯ����ѧ����Ϣ");
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

	//����ID��ѯѧ����Ϣ
	public Student queryStuById(int id){
		conn = util.getConnection();
		//System.out.println("��ID��ѯѧ����Ϣ");
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

	//���һ��ѧ����Ϣ
	public void insertStu(Student s){
		conn = util.getConnection();
		//System.out.println("����ѧ����Ϣ");
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
	
	//ɾ��ѧ����Ϣ
	public void deleteStu(int id){
		conn = util.getConnection();
		//System.out.println("ɾ��ѧ����Ϣ");
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
	
	//����ѧ����Ϣ
	public void updateStu(Student s , Double sco){
		conn = util.getConnection();
		//System.err.println("����ѧ����Ϣ");
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
