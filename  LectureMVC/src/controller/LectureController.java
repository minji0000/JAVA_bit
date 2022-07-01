package controller;

import connector.DBConnector;
import model.LectureDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LectureController {
    private Connection conn;
    public LectureController(DBConnector connector) {
        conn = connector.makeConnection();
    }

    public ArrayList<LectureDTO> selectAll() {

        ArrayList<LectureDTO> list = new ArrayList<>();
        String query = "SELECT * FROM `lecture`";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                LectureDTO l = new LectureDTO();
                l.setId(rs.getInt("id"));
                l.setClassname(rs.getString("classname"));
                l.setContent(rs.getString("content"));
                l.setProfessorId(rs.getInt("professorId"));

                list.add(l);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    //강의 등록하는 메소드
    public boolean register(LectureDTO l) {
        String query = "INSERT `lecture`(`classname`, `content`, `professorId`) VALUES (?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, l.getClassname());
            pstmt.setString(2, l.getContent());
            pstmt.setInt(3, l.getProfessorId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // 강의 수정하는 메소드
    public void update(LectureDTO l) {
        String query = "UPDATE `lecture` SET `classname` = ? , `content` = ? , `professorId` =? WHERE `id` = ? ";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, l.getClassname());
            pstmt.setString(2, l.getContent());
            pstmt.setInt(3, l.getProfessorId());
            pstmt.setInt(4, l.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 강의 삭제 메소드
    public void delete(int id) {
        String query = "DELETE FROM `lecture` WHERE `id` = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 강의 하나만 보여주는 메소드
    public LectureDTO selectOne(int id) {
        LectureDTO l = null;
        String query = "SELECT * FROM `lecture` WHERE `id` = ? ";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                l = new LectureDTO();
                l.setId(rs.getInt("id"));
                l.setClassname(rs.getString("classname"));
                l.setContent(rs.getString("content"));
                l.setProfessorId(rs.getInt("professorId"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }




























}
