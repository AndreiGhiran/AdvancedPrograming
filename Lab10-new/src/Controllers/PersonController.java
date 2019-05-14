package Controllers;

import Entity.Persons;

import javax.persistence.*;
import java.sql.*;
import java.util.List;

public class PersonController {

	private EntityManagerFactory emf;

	public PersonController(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
    public void create(Persons person) throws SQLException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    public Persons findByName(String personName) throws SQLException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select * from persons t where t.name like :name");
        List<Persons> persons = query.setParameter("name", "'%" + personName + "%'").getResultList();
        em.close();
        return persons.isEmpty() ? null : persons.get(0);
    }
	/*
	 * public String findByID(int id) throws SQLException { Connection con =
	 * Database.getConnection(); try (Statement stmt = con.createStatement();
	 * ResultSet rs = stmt.executeQuery("SELECT name FROM persons WHERE id = '" + id
	 * + "'")) { return rs.next() ? rs.getString(2) : null; } }
	 */
}
