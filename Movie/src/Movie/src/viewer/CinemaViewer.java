package viewer;

import controller.CinemaController;
import model.CinemaDTO;
import util.ScannerUtil;

import java.util.Scanner;

public class CinemaViewer {
    private Scanner scanner;
    private CinemaDTO c;
    private CinemaController cinemaController;

    private MovieUserViewer movieUserViewer;

    public CinemaViewer(Scanner scanner) {
        cinemaController = new CinemaController();
        this.scanner = scanner;
    }

    public void setMovieUserViewer(MovieUserViewer movieUserViewer) {
        this.movieUserViewer = movieUserViewer;
    }

    // 유저 뷰어에서 넘어올 첫 메뉴
    public void cinemaMenu() {
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, "1. 극장 목록보기 10. 뒤로가기");

            if (userChoice == 1) {
                cinemaList();
            }else if(userChoice == 2) {
                //
            }else if(userChoice == 10) {
                System.out.println("뒤로가기");
                break;
            }
        }
    }

    // 극장목록 보기
    private void cinemaList() {
        System.out.println("1. " + cinemaController.getSampleCinemaName());
        System.out.println("2. " + cinemaController.getSampleCinemaName2());
        System.out.println("3. " + cinemaController.getSampleCinemaName3());

        int userChoice = ScannerUtil.nextInt(scanner, "상세보기할 영화의 번호를 입력해주세요.");
        if(userChoice == 1) {
            cinemaDetailList();
        } else if(userChoice == 2) {
            cinemaDetailList2();
        } else if(userChoice == 3) {
            cinemaDetailList3();
        } else if(userChoice == 10) {
            System.out.println("뒤로가기");
        }
    }

    private void cinemaDetailList() {
        System.out.println("1. " + cinemaController.getSampleCinemaName());
        System.out.println(cinemaController.getSampleCinemaLocation());
        System.out.println(cinemaController.getSampleCinemaNumber());
    }

    private void cinemaDetailList2() {
        System.out.println("2. " + cinemaController.getSampleCinemaName2());
        System.out.println(cinemaController.getSampleCinemaLocation2());
        System.out.println(cinemaController.getSampleCinemaNumber2());
    }

    private void cinemaDetailList3() {
        System.out.println("3. " + cinemaController.getSampleCinemaName3());
        System.out.println(cinemaController.getSampleCinemaLocation3());
        System.out.println(cinemaController.getSampleCinemaNumber3());
    }

}
