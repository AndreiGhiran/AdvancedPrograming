package Main;

import Controllers.MovieController;
import Controllers.PersonController;
import Database.Database;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            PersonController persons = new PersonController();
            MovieController movies = new MovieController();

            persons.create("Francis Ford Coppola");
            persons.create("Marlon Brando");
            persons.create("Al Pacino");
            Database.commit();

            movies.create("The Godfather", persons.findByName("Coppola"));
            //Add other movies to the database
            Database.commit();

            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
