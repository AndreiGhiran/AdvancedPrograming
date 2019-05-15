package Entity;

import javax.persistence.*;

@Entity
@Table(name="MOVIES")
public class Movies {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

	@Basic(optional = false)
	@Column(name="NAME")
    private String name;
	
	@Basic(optional = false)
	@Column(name="DIRECTOR_ID")
    private int director_id;

    public Movies(int moviesID, String movieName, int directorID) {
    	setId(moviesID);
    	setName(movieName);
    	setDirector_id(directorID);
    }

    public Movies() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }
}
