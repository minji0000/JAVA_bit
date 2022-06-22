package viewer;

import controller.ReviewController;

import java.util.Scanner;

public class ReviewViewer {
    private MovieViewer movieViewer;
    private Scanner scanner;


    public ReviewViewer(Scanner scanner) {
        ReviewController reviewController = new ReviewController();
        this.scanner = scanner;
    }

    public void setMovieViewer(MovieViewer movieViewer) {
        this.movieViewer = movieViewer;
    }

    public void pickId(int id) {
        
    }

}
