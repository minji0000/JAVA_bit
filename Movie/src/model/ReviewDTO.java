package model;

public class ReviewDTO {
    private int reviewId; //평점번호
    private int writerId; //작성 회원 번호
    private int movieId; //영화 번호 movieDTO에서 겟으로 가져오나 ?
    private int star; //평점 일반 + 전문평론가
    private String review; //댓글 * 일반 회원만 작성가능
    private String proReview; //평론 * 전문평론가만 작성가능


    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getProReview() {
        return proReview;
    }

    public void setProReview(String proReview) {
        this.proReview = proReview;
    }

    public ReviewDTO() {

    }

    public ReviewDTO(int id) {
        this.reviewId = id;
    }

    public ReviewDTO(ReviewDTO origin) {
        this.reviewId = origin.reviewId;
        this.review = origin.review;
        this.proReview = origin.proReview;
        this.star = origin.star;
    }



}
