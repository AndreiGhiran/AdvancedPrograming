package graph_catalog;

import java.io.Serializable;

public class Graph implements Serializable{

	String name;
	String definition;
    String image;
	
    public Graph()
    {
    	
    }
	public Graph(String name, String definition, String image) {
		
		this.name=name;
		this.definition=definition;
		this.image=image;
	}
}
