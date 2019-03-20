package lab4;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Catalog c=new Catalog("C:\\Users\\User\\Desktop\\Uni\\pa\\lab4\\graphs");
		c.add(new Graph("k4", "k4.tgf", "k4.pdf"));
		c.add(new Graph("k3","k3.tgf","k3.pdf"));
		c.add(new Graph("bull","bull.tgf","bull.pdf"));
		c.add(new Graph("butterfly","butterfly.tgf","butterfly.pdf"));
		c.add(new Graph("diamond","diamond.tgf","diamond.pdf"));
		c.list();
	}

}
