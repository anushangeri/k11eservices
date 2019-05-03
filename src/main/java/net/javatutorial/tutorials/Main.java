package net.javatutorial.tutorials;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        Connection connection = getConnection();
        
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
        stmt.executeUpdate("CREATE TABLE ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
        while (rs.next()) {
            System.out.println("Read from DB: " + rs.getTimestamp("tick"));
        }
    }
    
    public static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI("postgres://wseuddtxrosopu:b76f0ccacf297722b37a3532e10e761b414673467f080c4ef06d6beca429edd4@ec2-50-19-114-27.compute-1.amazonaws.com:5432/d24osnerf48752");

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://ec2-50-19-114-27.compute-1.amazonaws.com" + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
//    	String dbUrl = System.getenv("JDBC_DATABASE_URL");
//        return DriverManager.getConnection(dbUrl);
    }

}