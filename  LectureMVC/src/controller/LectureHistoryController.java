package controller;

import connector.DBConnector;
import model.LectureHistoryDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LectureHistoryController {
    private Connection conn;
    public LectureHistoryController(DBConnector connector) {
        conn = connector.makeConnection();
    }

    // 수강 신청 목록 넣어줄 메소드
    // 점수 빼고
    public boolean register(LectureHistoryDTO lh) {
        String query = "INSERT INTO `lectureHistory`(`lectureId`, `studentId`) VALUES (?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, lh.getLectureId());
            pstmt.setInt(2, lh.getStudentId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    // 내가 수강한 강의만 보여주는 메소드
    public ArrayList<Integer> selectLecture(int userId) {
        ArrayList<Integer> list = new ArrayList<>();
        String query = "SELECT * FROM `lectureHistory` WHERE `studentId` = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                int l = rs.getInt("lectureId");
                list.add(l);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 교수님의 성적 등록 메소드
    public void insertGrade(LectureHistoryDTO lh) {
        String query = "UPDATE `lectureHistory` SET `grade` = ? WHERE = `id` = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, lh.getGrade());
            pstmt.setInt(2, lh.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



















}
