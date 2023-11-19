package DatabaseConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private String url;
    private String user;
    private String password;


    public DatabaseConnectionManager() {
        this.url = System.getenv("JDBC_URL");
        this.user = System.getenv("DB_USER");
        this.password = System.getenv("DB_PASSWORD");
    }


    public Connection getConnection() {
        if (this.url != null && this.user != null && this.password != null) {
            try {
                Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
                if (connection != null && connection.isValid(2)) {
                    System.out.println("Connected successfully");
                    return connection;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("error");
        }

        return null;
    }
}
