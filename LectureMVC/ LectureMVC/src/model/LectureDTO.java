package model;

public class LectureDTO {
    private int id;
    private int professorId;
    private String classname;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean equals(Object o) {
        if (o instanceof LectureDTO) {
            LectureDTO l = (LectureDTO) o;
            return id == l.id;
        }
        return false;
    }

}
