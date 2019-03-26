package lab4;

import java.io.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException 
	{	
		Catalog c=new Catalog("C:\\Users\\User\\Desktop\\Uni\\pa\\lab4\\graphs");
		c.add(new Graph("k4", "k4.tgf", "k4.pdf"));
		c.add(new Graph("k3","k3.tgf","k3.pdf"));
		c.add(new Graph("bull","bull.tgf","bull.pdf"));
		c.add(new Graph("butterfly","butterfly.tgf","butterfly.pdf"));
		c.add(new Graph("diamond","diamond.tgf","diamond.pdf"));
		//c.list();
		//c.open("butterfly");
		try
		{
			//SAVE BEGIN
			FileOutputStream f = new FileOutputStream(new java.io.File("C:\\Users\\User\\Desktop\\Uni\\pa\\lab4\\catalogs\\catalog1.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(c);
			o.close();
			f.close();
			//SAVE END
			
			//LOAD BEGIN
			FileInputStream fi = new FileInputStream(new File("C:\\Users\\User\\Desktop\\Uni\\pa\\lab4\\catalogs\\catalog1.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			Catalog c2 = (Catalog) oi.readObject();
			oi.close();
			fi.close();
			
			c2.list();
			
		}  catch (FileNotFoundException e) {
			System.out.println("File not found");
		} 
		catch (IOException e) {
			System.out.println("Error initializing stream");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
