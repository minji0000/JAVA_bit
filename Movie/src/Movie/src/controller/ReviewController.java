package controller;

import model.ReviewDTO;
import model.MovieDTO;
import model.MovieUserDTO;

import java.util.ArrayList;

public class ReviewController {

    private ArrayList<ReviewDTO> reviewList;
    private int nextId;

    public ReviewController() {
        reviewList = new ArrayList<>();
        nextId = 1;

        ReviewDTO temp1 = new ReviewDTO();
        ReviewDTO temp2 = new ReviewDTO();
        ReviewDTO temp3 = new ReviewDTO();

        temp1.setReview("재밌어요");
        temp1.setStar(5);

        insert(temp1);

        temp2.setProReview("프로 리뷰");
        temp2.setStar(4);

        insert(temp1);

        temp3.setReview("일반 리뷰");
        temp3.setStar(1);

        insert(temp1);

    }

    public void insert(ReviewDTO r) {

        r.setReviewId(nextId++);
        reviewList.add(r);

    }






}
