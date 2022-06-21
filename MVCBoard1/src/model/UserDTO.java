package model;

public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String nickname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean equals(Object o ) {
        if(o instanceof MemberDTO) {
            MemberDTO u = (MemberDTO) o; {
                if(id == u.id) {
                    return true;
                }
            }
        }
        return false;
    }

    public UserDTO() {

    }

    public UserDTO(MemberDTO u) {
        this.id = u.id;
        this.username = u.username;
        this.password = u.password;
        this.nickname = u.nickname;
    }

    public UserDTO(int id) {
        this.id = id;
    }

}
