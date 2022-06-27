package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector implements DBConnector {
    private final String ADDRESS = "jdbc:mysql://localhost:3306/sqlbasic";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    @Override
    public Connection makeConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlbasic", "root", "");
            System.out.println("mySql DB connection 성공");

            return conn;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
