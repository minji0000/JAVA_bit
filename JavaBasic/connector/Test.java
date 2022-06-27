package connector;

import java.sql.Connection;

public class Test {
    private Connection conn;
    public Test(DBConnector connector) {
        this.conn = connector.makeConnection();
    }

    public static void main(String[] args) {
        DBConnector connector = new OracleConnector();
        // DBConnector connector = new MySqlConnector();
        // 내가 어떤 생성자를 부르냐에 따라 다양한 형태를 가진다.

        Test t = new Test(connector);
    }
}
