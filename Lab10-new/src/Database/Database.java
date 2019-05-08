package Database;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "STUDENT";
    private static final String PASSWORD = "STUDENT";
    private static Connection connection = null;


    private Database() { }

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        // TODO Auto-generated method stub
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Exception at driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Exception at database connection creation!");
            e.printStackTrace();
        }

    }
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Exception at conection close!");
            e.printStackTrace();
        }
    }
    public static void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Exception at commit!");
            e.printStackTrace();
        }
    }
    public static void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Exception at rollback!");
            e.printStackTrace();
        }
    }

}