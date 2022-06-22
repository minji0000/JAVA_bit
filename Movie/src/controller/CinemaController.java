package controller;

import model.CinemaDTO;

import java.util.ArrayList;

public class CinemaController {

    private ArrayList<CinemaDTO> cinemaList;
    private int id;

    //샘플 극장 목록
    private int sampleCinemaId = 1;
    private String sampleCinemaName = "[롯데시네마 신림]";
    private String sampleCinemaLocation = "위치: 서울 관악구 신림로 330(신림동) 타임스트림 10층-15층";
    private String sampleCinemaNumber = "전화번호: 1554 - 8855";

    private int sampleCinemaId2 = 2;
    private String sampleCinemaName2 ="[CGV 압구정]";
    private String sampleCinemaLocation2 = "위치: 서울특별시 강남구 압구정로30길 45 (신사동)";
    private String sampleCinemaNumber2 = "전화번호: 1544 - 1122";

    private int sampleCinemaId3 = 3;
    private String sampleCinemaName3 = "[롯데시네마 강남]";
    private String sampleCinemaLocation3 = "위치: 서울특별시 강남구 남부순환로 2742";
    private String sampleCinemaNumber3 = "전화번호: 1544 - 3251";

    public ArrayList<CinemaDTO> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(ArrayList<CinemaDTO> cinemaList) {
        this.cinemaList = cinemaList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSampleCinemaId() {
        return sampleCinemaId;
    }

    public void setSampleCinemaId(int sampleCinemaId) {
        this.sampleCinemaId = sampleCinemaId;
    }

    public String getSampleCinemaName() {
        return sampleCinemaName;
    }

    public void setSampleCinemaName(String sampleCinemaName) {
        this.sampleCinemaName = sampleCinemaName;
    }

    public String getSampleCinemaLocation() {
        return sampleCinemaLocation;
    }

    public void setSampleCinemaLocation(String sampleCinemaLocation) {
        this.sampleCinemaLocation = sampleCinemaLocation;
    }

    public String getSampleCinemaNumber() {
        return sampleCinemaNumber;
    }

    public void setSampleCinemaNumber(String sampleCinemaNumber) {
        this.sampleCinemaNumber = sampleCinemaNumber;
    }

    public int getSampleCinemaId2() {
        return sampleCinemaId2;
    }

    public void setSampleCinemaId2(int sampleCinemaId2) {
        this.sampleCinemaId2 = sampleCinemaId2;
    }

    public String getSampleCinemaName2() {
        return sampleCinemaName2;
    }

    public void setSampleCinemaName2(String sampleCinemaName2) {
        this.sampleCinemaName2 = sampleCinemaName2;
    }

    public String getSampleCinemaLocation2() {
        return sampleCinemaLocation2;
    }

    public void setSampleCinemaLocation2(String sampleCinemaLocation2) {
        this.sampleCinemaLocation2 = sampleCinemaLocation2;
    }

    public String getSampleCinemaNumber2() {
        return sampleCinemaNumber2;
    }

    public void setSampleCinemaNumber2(String sampleCinemaNumber2) {
        this.sampleCinemaNumber2 = sampleCinemaNumber2;
    }

    public int getSampleCinemaId3() {
        return sampleCinemaId3;
    }

    public void setSampleCinemaId3(int sampleCinemaId3) {
        this.sampleCinemaId3 = sampleCinemaId3;
    }

    public String getSampleCinemaName3() {
        return sampleCinemaName3;
    }

    public void setSampleCinemaName3(String sampleCinemaName3) {
        this.sampleCinemaName3 = sampleCinemaName3;
    }

    public String getSampleCinemaLocation3() {
        return sampleCinemaLocation3;
    }

    public void setSampleCinemaLocation3(String sampleCinemaLocation3) {
        this.sampleCinemaLocation3 = sampleCinemaLocation3;
    }

    public String getSampleCinemaNumber3() {
        return sampleCinemaNumber3;
    }

    public void setSampleCinemaNumber3(String sampleCinemaNumber3) {
        this.sampleCinemaNumber3 = sampleCinemaNumber3;
    }
}
