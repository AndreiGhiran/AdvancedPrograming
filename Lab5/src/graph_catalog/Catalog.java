package graph_catalog;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.io.Serializable;

public class Catalog implements Serializable{

	String path;
	ArrayList<Graph> graphs = new ArrayList<Graph>();
	
	Catalog(String path)
	{
		this.path=path;
	}
	
	public void add(Graph graph) {
		
		graphs.add(graph);
	}

	public void open(String name) {
		
		for (int i = 0; i < graphs.size(); i++) {
			if(graphs.get(i).name==name) {
				if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = new File(path+"\\"+graphs.get(i).image);
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for PDFs
				    }
				}
			}
		}
	}
	
	public void list() throws FileNotFoundException, IOException {
		
		for (int i = 0; i < graphs.size(); i++) 
		{
			System.out.println(graphs.get(i).name+":");
			try (BufferedReader br = new BufferedReader(new FileReader(path+"\\"+graphs.get(i).definition))) {
				   String line = null;
				   while ((line = br.readLine()) != null) {
				       System.out.println(line);
				   }
				}
			System.out.println();
		}
		
	}
	
	public void save(String name)
	{
		GraphIO ceva=new GraphIO(name,this);
		ceva.save();
	}
	
	public void load (String name)
	{
		GraphIO ceva=new GraphIO(name,this);
		ceva.save();
	}

}
