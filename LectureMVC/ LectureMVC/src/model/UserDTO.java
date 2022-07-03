package model;

public class UserDTO {
    private int id; //
    private String name;
    private String username; // 학번 넣을거양
    private String password;
    private int level; // 등급을 1~3으로 나눠 권한 제어 1: 학생 2: 교수 3: 직원

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean equals(Object o) {
        if(o instanceof UserDTO) {
            UserDTO u = (UserDTO) o;
            return id == u.id;
        }
        return false;
    }
}
