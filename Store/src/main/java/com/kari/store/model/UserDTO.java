package com.kari.store.model;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String name;
    private String username;
    private String password;
    private String number;
    private String address;
    private int grade;

    public boolean equals(Object o) {
        if(o instanceof UserDTO) {
            UserDTO u = (UserDTO) o;
            return id == u.id;
        }
        return false;
    }

}
