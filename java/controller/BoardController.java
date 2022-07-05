package controller;

import connector.DBConnector;
import model.BoardDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class BoardController {
    private Connection conn;
    public BoardController(DBConnector connerctor) {
        conn = connerctor.makeConnection();
    }

    // 1. 글 입력
    public int insert(BoardDTO b) {
        String query = "INSERT INTO `board`(`writerId`, `title`, `content`, `writtenDate`, `updatedDate`) VALUES(?, ?, ?, NOW(), NOW())";
        try {

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, b.getWriterId());
            pstmt.setString(2, b.getTitle());
            pstmt.setString(3, b.getContent());
          

            pstmt.executeUpdate();
            
            query = "SELECT LAST_INSERT_ID()";
            
            pstmt = conn.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();
            int lastId = 0;
            if(rs.next()) {
            	lastId = rs.getInt("LAST_INSERT_ID()");
            }
            
            return lastId;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    // 2. 글 수정
    public void update(BoardDTO b) {
        String query = "UPDATE `board` SET `title` = ?, `content` = ?, `updatedDate` = NOW() WHERE `id` = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, b.getTitle());
            pstmt.setString(2, b.getContent());
            pstmt.setInt(3, b.getId());
         

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 3. 글 삭제
    public void delete(int id) {
        String query = "DELETE FROM `board` WHERE `id` = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. 글 목록 조회
    public ArrayList<BoardDTO> selectAll() {
        ArrayList<BoardDTO> list = new ArrayList<>();
        String query = "SELECT * FROM `board`";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                BoardDTO b = new BoardDTO();
                b.setId(rs.getInt("id"));
                b.setWriterId(rs.getInt("writerId"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                Calendar temp = Calendar.getInstance();
                temp.setTime(rs.getTimestamp("writtenDate"));
                b.setWrittenDate(temp);
                Calendar temp2 = Calendar.getInstance();
                temp2.setTime(rs.getTimestamp("updatedDate"));
                b.setUpdatedDate(temp2);
        
                
                list.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 5. 글 개별 조회
    public BoardDTO selectOne(int id) {
        BoardDTO b = null;
        String query = "SELECT * FROM `board` WHERE `id` = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                b = new BoardDTO();
                b.setId(rs.getInt("id"));
                b.setWriterId(rs.getInt("writerId"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                Calendar temp = Calendar.getInstance();
                temp.setTime(rs.getTimestamp("writtenDate"));
                b.setWrittenDate(temp);
                Calendar temp2 = Calendar.getInstance();
                temp2.setTime(rs.getTimestamp("updatedDate"));
                b.setUpdatedDate(temp2);
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return b;
    }

}
