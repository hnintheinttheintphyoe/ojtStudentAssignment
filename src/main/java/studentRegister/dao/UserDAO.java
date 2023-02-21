package studentRegister.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import studentRegister.dto.UserRequestDTO;
import studentRegister.dto.UserResponseDTO;
public class UserDAO {
	static Connection con=MyConnection.getConnection();
	public void insertData(UserRequestDTO dto) {
		
		String sql="insert into user(email,password,role,name) values(?,?,?,?) ";
	    
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1,dto.getEmail());
			stmt.setString(2,dto.getPassword());
			stmt.setString(3, dto.getRole());
			stmt.setString(4, dto.getName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Database error!");
		}
	}
	public UserResponseDTO selectOne(UserRequestDTO dto){
		UserResponseDTO res=new UserResponseDTO();
		String sql="select name,password from user where name=? and password=?";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,dto.getName());
			stmt.setString(2,dto.getPassword());
			
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				
				res.setName(rs.getString(1));
				res.setPassword(rs.getString(2));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Database error!");
		}
	
		return res;
	}
	public UserResponseDTO findOne(UserRequestDTO dto){
		UserResponseDTO res=new UserResponseDTO();
		String sql="select * from user where uid=?";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,dto.getUid());
			
			
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				res.setUid(rs.getInt(1));
				res.setName(rs.getString(2));
				res.setEmail(rs.getString(3));
				res.setPassword(rs.getString(4));
				res.setRole(rs.getString(5));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Database error!");
		}
	
		return res;
	}
	
	public ArrayList<UserResponseDTO> selectAll(String uid,String name){
		ArrayList<UserResponseDTO> list=new ArrayList();
		String sql="select * from user";
		
		if(uid != null && name!=null && !uid.equals("") && !name.equals("")) {
			sql+=" where uid=? and name Like ?";
		}
		else if(uid != null && !uid.equals("")) {
			sql+=" where uid=? ";
		}
		else if( name!=null && !name.equals("")) {
			sql+=" where  name Like ?";
		}
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			if(uid != null && name!=null && !uid.equals("") && !name.equals("")) {
				stmt.setInt(1, Integer.parseInt(uid));
				stmt.setString(2, name+"%");
			}
			else if(uid != null  && !uid.equals("")) {
				stmt.setInt(1, Integer.parseInt(uid));
				
			}
			else if( name!=null && !name.equals("")) {
				
				stmt.setString(1, name+"%");
			}
			
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				UserResponseDTO response=new UserResponseDTO();
				response.setUid(rs.getInt(1));
				response.setName(rs.getString(2));
				list.add(response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		System.out.print(e);
		}
		
		return list;
	}
	public void updateData(UserRequestDTO dto) {
		String stmt="Update user set name=?,email=?,password=?,role=? where uid=?";
		try {
			PreparedStatement ps=con.prepareStatement(stmt);
			ps.setInt(5,dto.getUid());
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getPassword());
			ps.setString(4, dto.getRole());
		
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void deleteData(int uid) {
		String stmt="Delete from user where uid=?";
		try {
			PreparedStatement ps=con.prepareStatement(stmt);
			ps.setInt(1,uid);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
