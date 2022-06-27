package day0627;

import connector.DBConnector;
import connector.MySqlConnector;
import java.util.Scanner;
import viewer.StudentViewer;

public class Ex02StudentMVC {
    public static void main(String[] args) {
        DBConnector connector = new MySqlConnector();
        Scanner scanner = new Scanner(System.in);

        StudentViewer viewer = new StudentViewer(scanner, connector);

        viewer.ShowMenu();
    }
}
