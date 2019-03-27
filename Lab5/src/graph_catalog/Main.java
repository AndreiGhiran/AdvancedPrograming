package graph_catalog;

import java.io.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException 
	{	
		Catalog c=new Catalog(".\\graphs");
		c.add(new Graph("k4", "k4.tgf", "k4.pdf"));
		c.add(new Graph("k3","k3.tgf","k3.pdf"));
		c.add(new Graph("bull","bull.tgf","bull.pdf"));
		c.add(new Graph("butterfly","butterfly.tgf","butterfly.pdf"));
		c.add(new Graph("diamond","diamond.tgf","diamond.pdf"));
		c.list();
		//c.open("butterfly");
		c.save("C:\\Users\\AndreiG\\Desktop\\an2sem2\\AP\\git\\AdvancedPrograming\\Lab5\\catalogs\\catalog1.txt");
		Catalog c2 = new Catalog(".\\graphs");
		c2.load("C:\\Users\\AndreiG\\Desktop\\an2sem2\\AP\\git\\AdvancedPrograming\\Lab5\\catalogs\\catalog1.txt");
		c2.list();
				

	}

}
