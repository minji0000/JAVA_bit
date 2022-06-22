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
    private int id;

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
                 movieList(2);
            } else if(userChoice == 2) {
                reviewMenu();
            } else if(userChoice == 10) {
                System.out.println("뒤로가기");
                break;
            }
        }
    }


    // 영화목록 보기
    private void movieList(int num) {
        ArrayList<MovieDTO> movieList = movieController.printAll();
        MovieDTO movieDTO;

        for(int i = 0; i < movieList.size(); i++ ) {
            movieDTO = movieList.get(i);
            System.out.println(movieDTO.getTitle());
        }

        int userChoice = ScannerUtil.nextInt(scanner, "상세보기할 영화를 선택해주세요.");
        while(userChoice != 0 && movieController.selectOne(userChoice) == null) {
            System.out.println("잘못 입력하셨습니다.");
            if(num == 1) { //상세보기 시 사용
                userChoice = ScannerUtil.nextInt(scanner, "상세보기 할 영화의 번호 입력");
            } else if(num == 2) { //수정할 때 사용
                userChoice = ScannerUtil.nextInt(scanner, "수정할 영화의 번호 입력");
            }
        }
        if(num == 1) {
            if (userChoice != 0) {
                movieDetailList(userChoice);
            }
        } else if(num == 2) {
            if(userChoice != 0) {
                //영화 수정 시 사용
                updateMovie(userChoice);
            }
        } else if(num == 3 ) {
            if(userChoice != 0) {
                deleteMovie(userChoice);
            }
        }

    }

    //영화 개별보기
    private void movieDetailList(int id) {
        MovieDTO movieDTO = movieController.selectOne(id);
        System.out.println("영화 제목: " + movieDTO.getTitle());
        System.out.println("영화 등급: " + movieDTO.getMovieGrade());
        System.out.println("영화 줄거리: " + movieDTO.getContent());

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
                break;
            }
        }


    }


    private void reviewList() {


    }

    private void normalReview() {
    }

    private void proReview() {
    }


    //관리자 메뉴
    public void movieManage() {
        while(true) {
            int managerChoice = ScannerUtil.nextInt(scanner, "1. 새로운 영화 등록 2. 영화 정보 수정 3. 영화 정보 삭제");
            MovieDTO m = new MovieDTO();

            if(managerChoice == 1) {
                //영화 등록
                addMovie();
            } else if(managerChoice == 2) {
                //영화 정보 수정
                movieList(2);
            } else if(managerChoice == 3) {
                // 영화 정보 삭제
                movieList(3);
            } else if(managerChoice == 10) {
                System.out.println("뒤로 가기");
                break;
            }
        }
    }

    private void addMovie() {
        MovieDTO m = new MovieDTO();

        m.setTitle(ScannerUtil.nextLine(scanner, "영화 제목 입력"));
        m.setMovieGrade(ScannerUtil.nextInt(scanner, "영화 등급 입력"));
        m.setContent(ScannerUtil.nextLine(scanner, "줄거리 입력"));

        movieController.insert(m);
        movieList(1);
    }

    private void updateMovie(int id) {
        System.out.println("id = " + id);
        MovieDTO m = movieController.selectOne(id);
        m.setTitle(ScannerUtil.nextLine(scanner, "새 영화 제목"));
        System.out.println("m = " + m);
        m.setMovieGrade(ScannerUtil.nextInt(scanner, "새 영화 등급"));
        m.setContent(ScannerUtil.nextLine(scanner, "새 영화 줄거리"));

        movieController.update(m);
        movieDetailList(id);

    }

    private void deleteMovie(int id) {
        String yesNo = ScannerUtil.nextLine(scanner, "정말로 삭제 하시겠습니까? Y/N");

        if(yesNo.equalsIgnoreCase("Y")) {
            movieController.deleteByWriterId(id);
            movieList(3);
        } else {
            movieDetailList(id);
        }

    }

}
