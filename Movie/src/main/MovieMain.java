package main;

import viewer.CinemaViewer;
import viewer.MovieUserViewer;
import viewer.MovieViewer;
import viewer.ReviewViewer;

import java.util.Scanner;

public class MovieMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieUserViewer movieUserViewer = new MovieUserViewer(scanner);
        MovieViewer movieViewer = new MovieViewer(scanner);
        CinemaViewer cinemaViewer = new CinemaViewer(scanner);
        ReviewViewer reviewViewer = new ReviewViewer(scanner);

        movieUserViewer.setMovieViewer(movieViewer);
        movieViewer.setMovieUserViewer(movieUserViewer);
        movieUserViewer.setCinemaViewer(cinemaViewer);
        reviewViewer.setMovieViewer(movieViewer);

        movieUserViewer.showLogin();

    }

}
