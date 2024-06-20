package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    //singleton design pattern

    private static Database instance = null;
    private  Connection connection = null;
    private  final String DB_URL = "jdbc:sqlserver://localhost:1433;database=ApiDb;encrypt=true;trustServerCertificate=true;";
    private final String DB_USERNAME  = "cihat.yildiz";
    private final String DB_PASSWORD  = "c190729.";

    private Database(){
        try {
            this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private Connection getConnection() {
        return connection;
    }

    public static Connection getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new Database();


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instance.getConnection();
    }
}
