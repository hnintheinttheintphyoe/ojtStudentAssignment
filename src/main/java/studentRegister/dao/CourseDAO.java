package studentRegister.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import studentRegister.dto.CourseRequestDTO;
import studentRegister.dto.CourseResponseDTO;


public class CourseDAO {
	static Connection con=MyConnection.getConnection();
	public void insertData(CourseRequestDTO dto) {
		
		String sql="insert into course(course) values(?) ";
	    
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,dto.getName());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	public ArrayList<CourseResponseDTO> selectAll() {
		ArrayList<CourseResponseDTO> list=new ArrayList<>();
		
		String stmt="select * from course";
		try {
			PreparedStatement ps=con.prepareStatement(stmt);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CourseResponseDTO response=new CourseResponseDTO();
				response.setName(rs.getString(2));
				
				list.add(response);
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
		
	}
	public int getId() {
		int id=0;
		String sql="select MAX(cid) from course";
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
}
