package lab4;

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
	
	public void save() throws IOException
	{
		FileOutputStream f = new FileOutputStream(new File(path));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(cat);
		o.close();
		f.close();
	}

	
	
	
}
