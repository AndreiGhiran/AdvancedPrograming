package graph_catalog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GraphIO
{
	String path;
	Catalog cat;
	
	public GraphIO(String name, Catalog C) 
	{
		this.path=name;
		this.cat=C;
	}
	
	public void save() 
	{
		try
		{
			//SAVE BEGIN
			FileOutputStream f = new FileOutputStream(new java.io.File(this.path));
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(this.cat);
			o.close();
			f.close();
			
		}  catch (FileNotFoundException e) {
			System.out.println("File not found");
		} 
		catch (IOException e) {
			System.out.println("Error initializing stream");
		} 
	}
	
	public void load()
	{
		try
		{
			//LOAD BEGIN
			FileInputStream fi = new FileInputStream(new File(this.path));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			this.cat = (Catalog) oi.readObject();
			oi.close();
			fi.close();

			
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
