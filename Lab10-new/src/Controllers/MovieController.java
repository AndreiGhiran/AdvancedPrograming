package Controllers;

import Database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieController {

    int IdGenerator = 1;

    public void create (String name, int id) throws SQLException {
        Connection con = Database.getConnection();
        try(PreparedStatement pstms = con.prepareStatement("INSERT INTO movies VALUES (?,?,?)")){
            pstms.setInt(1, IdGenerator);
            pstms.setString(2, name);
            pstms.setInt(3, id);
            pstms.executeUpdate();
            IdGenerator++;
        }
    }
}
