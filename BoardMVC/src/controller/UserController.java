package controller;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;
import connector.DBConnerctor;
import model.UserDTO;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {
    private Connection conn;
    public UserController(DBConnerctor connerctor) {
        conn = connerctor.makeConnection();
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
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setNickname(rs.getString("nickname"));

                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // 2. 회원가입
    public boolean register(UserDTO u) {
        String query = "INSERT INTO `user`(`username`, `password`, `nickname`) VALUES(?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, convertToSha(u.getPassword()));
            pstmt.setString(3, u.getNickname());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    // 3. 회원정보 수정
    public void update(UserDTO u) {
        String query = "UPDATE `user` SET `password` = ?, `nickname` = ? WHERE `id` = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, convertToSha(u.getPassword()));
            pstmt.setString(2, u.getNickname());
            pstmt.setInt(3, u.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 4. 회원정보 삭제
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

    // 5. sha2 암호화
    public String convertToSha(String password) {
        String converted = null;
        StringBuilder builder = null;
        //다양한 값을 스트링의 형태로 바꿔 자기 안에 필드로 저장

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // 암호화 해주는 클래스
            // 256글자  ? ?
            // 특정 값을 바이트로 바꿔 처리해주는

            byte[] hash = md.digest(password.getBytes("UTF-8"));
            // 총 64개의 바이트값이 있음, 2진법의 형태
            // 여기서 암호화

            builder = new StringBuilder();
            //해쉬의 i번째 값을 2자리 16진법으로 바꿔줘
            for(int i = 0; i<hash.length; i++) {
                builder.append(String.format("%02x", 255 & hash[i])); //두 자릿수 모두 1일 때만 1이 나온다.
                //빌더에 저장된 값에 파라미터로 들어온 값을 추가해준다.
            }

            converted = builder.toString();


        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return  converted;
    }

    //6. 회원 번호를 토대로 회원을 리턴하는 메소드
    public UserDTO seleteOne(int id) {
        UserDTO u = null;
        String query = "SELECT * FROM `user` WHERE `id` = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                u = new UserDTO();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setNickname(rs.getString("nickname"));
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        }

        return u;
    }

}
