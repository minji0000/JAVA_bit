package controller;

import model.StudentDTO;

import java.util.ArrayList;

public class StudentController {
    private ArrayList<StudentDTO> list;
    private int id;

    // 이건 생성자야
    public StudentController() {
        list = new ArrayList<>();
        id = 1;
    }


    public void insert(StudentDTO s) {
        s.setId(id++);
        list.add(s);
    }

    public void update(StudentDTO s) {
        int index = list.indexOf(s);
        list.set(index, s);
    }

    public void delete(int id) {
        list.remove(new StudentDTO(id));
    }

    public ArrayList<StudentDTO> printAll() {
        ArrayList<StudentDTO> temp = new ArrayList<>();

        for(StudentDTO s : list) {
            temp.add(new StudentDTO(s));
        }
        return temp;
    }

    public StudentDTO printOne(int id) {

        for(StudentDTO s : list) {
            if(s.getId() == id) {
                return new StudentDTO(s);
            }
        }
        return null;
    }

    //아이디 중복검사
    public boolean validateUsername(String username) {
        for(StudentDTO s : list) {
            if(s.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

}
