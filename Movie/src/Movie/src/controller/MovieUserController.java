package controller;

import model.MovieUserDTO;

import java.util.ArrayList;

public class MovieUserController {
    private ArrayList<MovieUserDTO> list;
    private int id;
    private int grade;

    public MovieUserController() {
        list = new ArrayList<>();
        id = 1;
        grade = 10;
    }

    // list에 객체 등록
    public void insert(MovieUserDTO mu) {
        mu.setUserId(id++);
        mu.setUserGrade(grade);
        list.add(mu);
    }


    // 아이디(username) 중복확인
    public boolean validateUsername(String username) {
        for(MovieUserDTO mu : list) {
            if(mu.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    // 아이디(username)와 password가 같은지 확인
    public MovieUserDTO auth(String username, String password) {
        for(MovieUserDTO mu : list) {
            if (mu.getUsername().equalsIgnoreCase(username)
                    && mu.getPassword().equals(password))
                return new MovieUserDTO(mu);
        }
        return null;
    }

    //매니저 로그인인지 확인
    public boolean managerLogin(String managerName, String managerPassword) {
        MovieUserDTO mu = new MovieUserDTO();
        if(mu.getManagerName().equalsIgnoreCase(managerName) && mu.getManagerPassword().equals(managerPassword)) {
            return true;
        }
        return false;
    }

    // 닉네임 넣어서 반갑다고 해주려고 쓰는 코드
    public String getum(String username) {
        for(MovieUserDTO mu : list) {
            if(mu.getUsername().equalsIgnoreCase(username)) {
                return mu.getNickname();
            }
        }
        return null;
    }

}
