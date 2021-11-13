package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    private static final String DB = "";
    private static final String DB_USERNAME = "";
    private static final String DB_PASSWORD = "";

    private static Connection connect = null;

    static void init() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/" + DB_USERNAME + "?"
                        + "user=" + DB_USERNAME + "&password=" + DB_PASSWORD);
    }

    public static Connection getConnection() {
        return connect;
    }
}
