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

    // 학생 본인이 수강하는 강의만 보여주는 메소드
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

    // 교수님의 성적 등록 메소드 *******
    public void insertGrade(int stuId, String grade, int id ) {
        String query = "UPDATE `lectureHistory` SET `grade` = ? WHERE `studentId` = ? AND `lectureId` = ?" ;

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, grade);
            pstmt.setInt(2, stuId);
            pstmt.setInt(3, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    // 강의를 수강하는 학생만 보여주는 메소드
    public ArrayList<Integer> selectStudent(int lectureId) {
        ArrayList<Integer> list = new ArrayList<>();
        String query = "SELECT * FROM `lectureHistory` WHERE `lectureId` = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, lectureId);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                int s = rs.getInt("studentId");
                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }






















}
