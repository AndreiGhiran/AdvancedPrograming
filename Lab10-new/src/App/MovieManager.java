package App;

import Controllers.MovieController;
import Controllers.PersonController;
import Entity.Movies;
import Entity.Persons;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieManager {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesPU");
    private int personsID = 1;
    private int moviesID = 1;
    List<Persons> persons = new ArrayList<>();
    List<Movies> movies = new ArrayList<>();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input command: ");
            String command = scanner.nextLine();
            if (command.equals("exit"))
                break;
            String[] params = command.trim().split("\\s+");
            switch (params[0]) {
                case "create-person":
                    createPerson(params[1]);
                    break;
                case "create-movie":
                    createMovie(params[1], params[2]);
                    break;
                case "list-movies":
                    listMovies(params[1]);
                    break;
                case "help":
                    System.out.println("Available commands: \n" +
                            "create-person <person_name> \n" +
                            "create-movie <movie_name> <director_name> \n" +
                            "list-movies \n" +
                            "exit");
                    break;
            }
        }
    }

    private void createPerson(String personName) {
        Persons person = new Persons(personsID, personName);
        persons.add(person);
        personsID++;
        PersonController personController = new PersonController(emf);
        personController.create(person);
    }

    private void createMovie(String movieName, String directorName) {
        Movies movie = new Movies(moviesID, movieName, directorName);
        movies.add(movie);
        moviesID++;
        MovieController movieController = new MovieController(emf);
        movieController.create(movie);
    }

    private void listMovies(String directorName) {
        for(Persons person : persons){
            if(person.getName().equals(directorName)) {
                MovieController movieController = new MovieController(emf);
                movieController.listMovies(person);
                return;
            }
        }
        System.out.println("The name introduced for the director does not exist.\n");
    }

    public static void main(String args[]) {
        new MovieManager().run();
    }
}
