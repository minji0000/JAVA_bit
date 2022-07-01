package controller;

import connector.DBConnector;
import model.UserDTO;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserController {
    private Connection conn;
    public UserController(DBConnector connector) {
        conn = connector.makeConnection();
    }

    // 1. 로그인
    public UserDTO logIn(String username, String password) {
        String query = "SELECT * FROM `user` WHERE `username` = ? AND `password` = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, convertToSha(password));

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                UserDTO u = new UserDTO();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setLevel(rs.getInt("level"));

                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // 비밀번호 암호화해서 저장
    public String convertToSha(String password) {
        String converted = null;
        StringBuilder builder = null;
        // 다양한 값을 스트링의 형태로 바꿔 자기 안에 필드로 저장

            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                // 암호화해주는 클래스
                byte[] hash = md.digest(password.getBytes("UTF-8"));
                builder = new StringBuilder();

                for(int i = 0; i <hash.length; i++) {
                    builder.append(String.format("%02x", 255 & hash[i]));
                }

                converted = builder.toString();

            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        return converted;

    }

    public boolean register(UserDTO u) {
        String query = "INSERT INTO `user`(`name`,`username`,`password`, `level`) VALUES(?, ?, ?, 1)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getUsername());
            pstmt.setString(3, convertToSha(u.getPassword()));

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    // 회원정보 삭제
    public void delete(int id) {
        String query = "DELETE FROM `user` WHERE `id` = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    // 비밀번호 변경
    public void update(UserDTO u) {
        String query = "UPDATE `user` SET `password` = ? WHERE `id` = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, convertToSha(u.getPassword()));
            pstmt.setInt(2, u.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 직원의 회원 등급관리
    public void levelSet(UserDTO u) {
        String query = "UPDATE `user` SET `level` = ? WHERE `id` = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, u.getLevel());
            pstmt.setInt(2, u.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 유저 정보 다 보여주는 메소드
    public ArrayList<UserDTO> selectAll() {
        ArrayList<UserDTO> list = new ArrayList<>();
        String query = "SELECT * FROM `user`";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                UserDTO u = new UserDTO();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setLevel(rs.getInt("level"));

                list.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 교수만 보여주는 메소드
    public ArrayList<UserDTO> selectPro() {
        ArrayList<UserDTO> list = new ArrayList<>();
        String query = "SELECT * FROM `user` WHERE `level` = 2";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                UserDTO u = new UserDTO();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setUsername(rs.getString("username"));

                list.add(u);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 회원 번호를 토대로 회원을 리턴하는 메소드
    public UserDTO selectOne(int id) {
        UserDTO u = null;
        String query = "SELECT * FROM `user` WHERE `id` = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                u = new UserDTO();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setUsername(rs.getString("username"));
                u.setLevel(rs.getInt("level"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

}
