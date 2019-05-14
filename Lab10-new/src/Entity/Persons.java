package Entity;

import javax.persistence.*;

@Entity
@Table(name="PERSONS")

public class Persons {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
	@Basic(optional = false)    
	@Column(name = "ID")
    private int id;
	
	@Basic(optional = false)
	@Column(name="NAME")
    private String name;

	public Persons(int personsID, String personName) {
		setId(personsID);
		setName(personName);
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
}
