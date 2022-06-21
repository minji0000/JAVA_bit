package controller;

import java.util.ArrayList;

import model.MemberDTO;

public class UserController {
    private ArrayList<MemberDTO> list;
    private int nextId;

    public UserController() {
        list = new ArrayList<>();
        nextId = 1;
    }

    public void insert(MemberDTO u) {
        u.setId(nextId++);
        list.add(u);
    }

    public boolean validateUsername(String username) {
        for(MemberDTO u : list) {
            if(u.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public MemberDTO auth(String username, String password) {
        for(MemberDTO u : list) {
            //AND 연산자를 통해username이 갖고 password가 같은지 확인 !
            if(u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password))
               return new UserDTO(u); }
        return null;
    }

    public void update(MemberDTO u) {
        int index = list.indexOf(u);
        list.set(index, u);
    }

    public void delete(int id) {
        list.remove(new MemberDTO(id));
    }

    public MemberDTO selectOne(int id) {
       MemberDTO u = new MemberDTO(id);
       if(list.contains(u)) {
           return new MemberDTO(list.get(list.indexOf(u)));
       }
        return null;
    }



}






















