package edu.cpp.bankatm.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    private static final String DB = "ATM";
    private static final String DB_USERNAME = "newuser";
    private static final String DB_PASSWORD = "password";

    private static Connection connect = null;

    public static void init() throws Exception {
        connect = DriverManager.getConnection(
                "jdbc:mysql://localhost/" + DB + "?user=" + DB_USERNAME + "&password=" + DB_PASSWORD
        );
    }

    public static Connection getConnection() {
        return connect;
    }
}
