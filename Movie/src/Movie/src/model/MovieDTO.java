package model;

public class MovieDTO {
    private int movieId; // 영화번호
    private String Title; // 영화 제목
    private String content; //영화 줄거리
    private int movieGrade; //영화 등급

    //초기값 할당

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMovieGrade() {
        return movieGrade;
    }

    public void setMovieGrade(int movieGrade) {
        this.movieGrade = movieGrade;
    }

    public MovieDTO() {

    }

    public MovieDTO(int id) {
        this.movieId = id;
    }

    public MovieDTO(MovieDTO origin) {
        this.movieId = origin.movieId;
        this.Title = origin.Title;
        this.content = origin.content;
        this. movieGrade = origin.movieGrade;
    }

    public boolean equals(Object o){
        if(o instanceof MovieDTO){
            MovieDTO movieDTO = (MovieDTO) o;
            return this.movieId == movieDTO.movieId; //b.id = 힙에서 id의 값을 가져온다.
            // 둘다 힙영역에 있는 id의 실제 데이터를 비교하는 것
            // this.id는 해당 메소드를 실행시키는 주체의 id
        }
        return false;
    }



}
