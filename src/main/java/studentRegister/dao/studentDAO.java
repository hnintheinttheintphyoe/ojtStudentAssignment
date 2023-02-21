package studentRegister.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import studentRegister.dto.StudentRequestDTO;
import studentRegister.dto.StudentResponseDTO;


public class studentDAO {
	static Connection con=MyConnection.getConnection();
	public void insertData(StudentRequestDTO dto) {
		
		String sql="insert into student(name,dob,gender,phone,education,attend,photo) values(?,?,?,?,?,?,?) ";
	    
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,dto.getName());
			stmt.setString(2,dto.getDob());
			stmt.setString(3,dto.getGender());
			stmt.setString(4, dto.getPhone());
			stmt.setString(5, dto.getEducation());
			
			stmt.setString(6, dto.getAttend());
			stmt.setString(7, dto.getPhoto());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	public int getId() {
		int id=0;
		String sql="select MAX(sid) from student";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				id=rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	public ArrayList<StudentResponseDTO> selectAll(String sid,String name,String attend){
		ArrayList<StudentResponseDTO> list=new ArrayList();
		String sql="select * from student";
		if(sid != null && name != null && attend != null && !sid.equals("") && !name.equals("") && !attend.equals("")  ) {
			sql="select * from student where sid=? and name Like ? and attend Like ?";
		}
		else if(sid != null && !sid.equals("")  ) {
			sql="select * from student where sid=?";
		}
		else if(name != null && !name.equals("")) {
			sql="select * from student where name Like ?";
		}
		else if(attend != null && !attend.equals("")  ) {
			sql="select * from student where attend Like ?";
		}
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			if(sid != null && name != null && attend != null && !sid.equals("") && !name.equals("") && !attend.equals("")) {
				stmt.setInt(1, Integer.parseInt(sid));
				stmt.setString(2,name+"%");
				stmt.setString(3, attend+"%");
			}
			else if(sid != null && !sid.equals("") ) {
				stmt.setInt(1, Integer.parseInt(sid));
			}
			else if(name != null && !name.equals("")) {
				stmt.setString(1,name+"%");
			}
			else if(attend != null && !attend.equals("")  ) {
				stmt.setString(1,"%"+attend+"%");
			}
			
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				StudentResponseDTO response=new StudentResponseDTO();
				response.setSid(rs.getInt(1));
				response.setName(rs.getString(2));
				response.setAttend(rs.getString(7));
				
				list.add(response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		System.out.print(e);
		}
		
		return list;
	}
	public StudentResponseDTO findOne(StudentRequestDTO dto){
		StudentResponseDTO res=new StudentResponseDTO();
		String sql="select * from student where sid=?";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,dto.getSid());
			
			
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				res.setSid(rs.getInt(1));
				res.setName(rs.getString(2));
				res.setDob(rs.getString(3));
				res.setGender(rs.getString(4));
				res.setPhone(rs.getString(5));
				res.setEducation(rs.getString(6));
				res.setAttend(rs.getString(7));
				res.setPhoto(rs.getString(8));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Database error!");
		}
	
		return res;
	}
	public void updateData(StudentRequestDTO dto) {
		
		String stmt="update student set name=?,dob=?,gender=?,phone=?,education=?,attend=?,photo=? where sid=?";
		if(dto.getPhoto()== null) {
		 stmt="update student set name=?,dob=?,gender=?,phone=?,education=?,attend=? where sid=?";
		}
		try {
			PreparedStatement ps=con.prepareStatement(stmt);
			
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getDob());
			ps.setString(3, dto.getGender());
			ps.setString(4, dto.getPhone());
			ps.setString(5, dto.getEducation());
			ps.setString(6, dto.getAttend());
			if(dto.getPhoto() != null) {
				ps.setString(7, dto.getPhoto());
				ps.setInt(8,dto.getSid());
			}else {
				ps.setInt(7,dto.getSid());
			}
		
			ps.executeUpdate();
			System.out.println(dto.getSid());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void deleteData(int sid) {
		String stmt="Delete from student where sid=?";
		try {
			PreparedStatement ps=con.prepareStatement(stmt);
			ps.setInt(1,sid);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}