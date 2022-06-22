package model;

public class MovieUserDTO {
    private int managerId = 0; // 관리자
    private String managerName = "manager";
    private String managerPassword = "1234";

    private int userId; //회원번호
    private String username; //아이디
    private String password; //비밀번호
    private String nickname; //닉네임
    private int userGrade;//등급의 경우 일반 관람객. 전문 평론가, 관리자로 나뉜다.
    // 회원 가입 시 무조건 일반 회원으로 가입이 되며, 관리자가 특정 회원의 등급 변경 가능

    public MovieUserDTO() {
        //생성자
    }

    public MovieUserDTO(int id) {
        this.userId = id;
    }

    public MovieUserDTO(MovieUserDTO mu) {
        this.userId = mu.userId;
        this.username = mu.username;
        this.password = mu.password;
        this.nickname = mu.nickname;
        this.userGrade = mu.userGrade;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }


    // 관리자
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }
}
