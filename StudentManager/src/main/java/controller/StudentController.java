package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connector.DBConnector;
import model.StudentDTO;

public class StudentController {
	private Connection conn;
	public StudentController(DBConnector connector) {
		this.conn = connector.makeConnection();
	}
	
	public void insert(StudentDTO s) {
		String query = "INSERT INTO `student` (`name`, `korean`,`english`, `math`, `entryDate`,`updatedDate) VALUES(?, ?, ?, ?, NOW(), NOW())";
		

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getKorean());
			pstmt.setInt(3, s.getEnglish());
			pstmt.setInt(4, s.getMath());
			
			pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public void update(StudentDTO s) {
		// NOW()로 바꿈 (내가) 
		String query = "UPDATE `student` SET `name`= ?, `korean` = ?, `english` =?, `math` =?, `updatedDate` = NOW() WHERE `id` = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, s.getName());
			pstmt.setInt(2,  s.getKorean());
			pstmt.setInt(3, s.getEnglish());
			pstmt.setInt(4, s.getMath());
			pstmt.setInt(5, s.getId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void delete(int id) {
		String query = "delete from `student` where `id` = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<StudentDTO> selectAll() {
		ArrayList<StudentDTO> list = new ArrayList<>();
		String query = "SELECT * FROM `student`";
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO s = new StudentDTO();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setKorean(rs.getInt("korean"));
				s.setEnglish(rs.getInt("english"));
				s.setMath(rs.getInt("math"));
				s.setEntryDate(rs.getTimestamp("entryDate"));
				s.setUpdatedDate(rs.getTimestamp("updatedDate"));
				
				list.add(s);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	
	public StudentDTO selectOne(int id) {
		StudentDTO s = null;
		String query = "SELECT * FROM `student` WHERE id = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				s = new StudentDTO();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setKorean(rs.getInt("korean"));
				s.setEnglish(rs.getInt("english"));
				s.setMath(rs.getInt("math"));
				s.setEntryDate(rs.getTimestamp("entryDate"));
				s.setUpdatedDate(rs.getTimestamp("updatedDate"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
