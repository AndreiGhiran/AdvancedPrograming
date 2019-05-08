package Controllers;

import Database.Database;

import javax.persistence.EntityManagerFactory;
import java.sql.*;

public class PersonController {

    int IdGenerator = 1;
    private EntityManagerFactory emf;

    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO persons values (?, ?)")) {
            pstmt.setInt(1, IdGenerator);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            IdGenerator++;
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id FROM persons WHERE name LIKE '%" + name + "%'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findByID(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name FROM persons WHERE id = '" + id + "'")) {
            return rs.next() ? rs.getString(2) : null;
        }
    }
}
