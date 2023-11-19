package DatabaseConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private String JDBC_URL;
    private String DB_USER;
    private String DB_PASSWORD;


    public DatabaseConnectionManager() {
        this.url = System.getenv("JDBC_URL");
        this.user = System.getenv("DB_USER");
        this.password = System.getenv("DB_PASSWORD");
    }



}
