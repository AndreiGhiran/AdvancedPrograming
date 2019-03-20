package lab4;

public class Graph extends GraphIO{

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
