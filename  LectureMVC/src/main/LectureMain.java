package main;

import connector.DBConnector;
import connector.MysqlConnector;
import viewer.UserViewer;

import java.util.Scanner;

public class LectureMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DBConnector connector = new MysqlConnector();
        UserViewer userViewer = new UserViewer(scanner, connector);
        userViewer.showIndex();

        scanner.close();
    }

}
