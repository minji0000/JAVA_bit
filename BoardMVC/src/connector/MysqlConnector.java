package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnector implements DBConnerctor {
    private final String ADDRESS = "jdbc:mysql://localhost:3306/board";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    @Override
    public Connection makeConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn =
                    DriverManager.getConnection(ADDRESS, USERNAME, PASSWORD);
            System.out.println("mySql DB connection 성공");

            return conn;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
