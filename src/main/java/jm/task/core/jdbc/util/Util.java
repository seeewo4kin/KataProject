package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {

    private static Connection connection = null;
    private static Util instance = null;

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Sewo4kin123";

    public Util(){
        try {
            if (null == connection || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public static Util getInstance() {
        if (null == instance) {
            instance = new Util();
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }
}
