package controller;

import connector.DBConnector;
import model.UserDTO;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {
    private Connection conn;
    public UserController(DBConnector connector) {
        conn = connector.makeConnection();
    }

    // 1. 로그인
    public UserDTO logIn(int id, String password) {
        String query = "SELECT * FROM `user` WHERE `id` = ? AND `password` = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, convertTosha(password));

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                UserDTO u = new UserDTO();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
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

    private String convertTosha(String password) {
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

}
