package model;

public class LectureHistoryDTO {
    private int id;
    private int lectureId;
    private int studentId;
    private String grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean equals(Object o) {
        if (o instanceof LectureHistoryDTO) {
            LectureHistoryDTO lh = (LectureHistoryDTO) o;
            return id == lh.id;
        }
        return false;
    }

}
