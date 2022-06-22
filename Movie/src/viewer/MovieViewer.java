package viewer;

import controller.MovieController;
import model.MovieDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieViewer {
    private Scanner scanner;
    private MovieDTO m;
    private MovieController movieController;
    private MovieUserViewer movieUserViewer;

    public MovieViewer(Scanner scanner) {
        movieController = new MovieController();
        this.scanner = scanner;
    }

    public void setMovieUserViewer(MovieUserViewer movieUserViewer) {
        this.movieUserViewer = movieUserViewer;
    }

    // 유저 뷰어에서 넘어올 첫 메뉴
    public void movieMenu() {
        while(true) {
            int userChoice = ScannerUtil.nextInt(scanner, "1. 영화 목록 보기 2. 평점 보기 10. 뒤로가기");

            if (userChoice == 1) {
                 movieList();
            } else if(userChoice == 2) {
                reviewMenu();
            } else if(userChoice == 10) {
                System.out.println("뒤로가기");
                break;
            }
        }
    }


    // 영화목록 보기
    private void movieList() {
        ArrayList<MovieDTO> movieList = movieController.printAll();
        MovieDTO movieDTO;

        for(int i = 0; i < movieList.size(); i++ ) {
            movieDTO = movieList.get(i);
            System.out.println(movieDTO.getTitle());
        }

        int userChoice = ScannerUtil.nextInt(scanner, "상세보기할 영화를 선택해주세요.");
        if(userChoice == 1) {
            movieDetailList();
        } else if(userChoice == 2) {
            movieDetailList2();
        } else if(userChoice == 3) {
            movieDetailList3();
        }

    }

    //영화 개별보기
    private void movieDetailList() {
        MovieDTO movieDTO = movieController.selectOne(1);
        System.out.println(movieDTO.getTitle());
        System.out.println(movieDTO.getMovieGrade());
        System.out.println(movieDTO.getContent());

    }

    private void movieDetailList2() {
        MovieDTO movieDTO = movieController.selectOne(2);
        System.out.println(movieDTO.getTitle());
        System.out.println(movieDTO.getMovieGrade());
        System.out.println(movieDTO.getContent());
    }

    private void movieDetailList3() {
        MovieDTO movieDTO = movieController.selectOne(3);
        System.out.println(movieDTO.getTitle());
        System.out.println(movieDTO.getMovieGrade());
        System.out.println(movieDTO.getContent());
    }

    //관리자 메뉴
    public void movieManage() {
        while(true) {
            int managerChoice = ScannerUtil.nextInt(scanner, "1. 새로운 영화 등록 2. 영화 정보 수정 3. 영화 정보 삭제");

            if(managerChoice == 1) {
                //영화 등록
            } else if(managerChoice == 2) {
                //영화 정보 수정
            } else if(managerChoice == 3) {
                // 영화 정보 삭제
            } else if(managerChoice == 10) {
                System.out.println("뒤로 가기");
                break;
            }
        }
    }

    // 전체 평점보기
    private void reviewMenu() {
        while(true) {
            int userChoice = ScannerUtil.nextInt(scanner,
                    "1. 영화별 전체 평점 보기 2. 영화별 평론가 평점 보기 3.영화별 일반 관람객 평점 보기 ");

            if(userChoice == 1) {
                //영화별 전체
                reviewList();
            } else if(userChoice == 2) {
                // 영화별 평론가
                proReview();
            } else if(userChoice == 3) {
                // 영화별 일반
                normalReview();
            } else if(userChoice == 10) {

            }
        }


    }


    private void reviewList() {


    }

    private void normalReview() {
    }

    private void proReview() {
    }


}
