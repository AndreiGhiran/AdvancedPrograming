package Controllers;


import Entity.Movies;
import Entity.Persons;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class MovieController {

	private EntityManagerFactory emf;

    public MovieController(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
    public void create(Movies movie) throws SQLException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();
        em.close();
    }

    public Movies findByName(String movieName) throws SQLException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select * from movies t where t.name like :name");
        List<Movies> movies = query.setParameter("name", "'%" + movieName + "%'").getResultList();
        em.close();
        return movies.isEmpty() ? null : movies.get(0);
    }

	public void listMovies(int directorID) {
		EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select * from movies t where t.director_id = :director_id");
        List<Movies> movies = query.setParameter("director_id", directorID).getResultList();
        em.close();
        if(movies.isEmpty())
        {
        	System.out.println("This pesrson hasn't directed any movies.");
        	return;
        }
        else
        {
        	for(Movies movie : movies)
        	{
        		System.out.println(movie.getName());
        	}
        }
		
	}

}
