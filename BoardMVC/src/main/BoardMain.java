package main;

import connector.DBConnerctor;
import connector.MysqlConnector;
import viewer.UserViewer;

import java.util.Scanner;

public class BoardMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DBConnerctor connerctor = new MysqlConnector();
        UserViewer userViewer = new UserViewer(scanner, connerctor);
        userViewer.ShowIndex();

        scanner.close();
    }
}
