package model;

public class CinemaDTO {
    private int cinemaId; //극장번호
    private String cinemaName; //극장이름
    private String cinemaLocation; //극장위치
    private String cinemaNumber; //극장 전화번호


    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaLocation() {
        return cinemaLocation;
    }

    public void setCinemaLocation(String cinemaLocation) {
        this.cinemaLocation = cinemaLocation;
    }

    public String getCinemaNumber() {
        return cinemaNumber;
    }

    public void setCinemaNumber(String cinemaNumber) {
        this.cinemaNumber = cinemaNumber;
    }
}
