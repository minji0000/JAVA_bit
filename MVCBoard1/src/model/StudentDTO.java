package model;

public class StudentDTO {
    private String name;
    private String username;
    private int id;
    private int korean;
    private int english;
    private int math;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public StudentDTO() {

    }

    public StudentDTO(int id) {
        this.id = id;
    }

    public StudentDTO(StudentDTO s) {
        this.id = s.id;
        this.name = s.name;
        this.username = s.username;
        this.korean = s.korean;
        this.english = s.english;
        this.math = s.math;
    }

    //Object
    public boolean equals(Object o) {
        if(o instanceof StudentDTO ) {
            StudentDTO s = (StudentDTO) o;
            return this.id == s.id;
            //equals를 호출한 애의 아이디
        }
        return false;
    }


}
