package graphical_Interface;

import javax.swing.*;

public class GraphForm extends JPanel {
	
    private final CatalogFrame frame = new CatalogFrame();
    JLabel titleLabel = new JLabel("Name of the graph");
    JLabel definitionPath = new JLabel("Path of the definition file");
    JLabel imagePath = new JLabel("Path of the image file");
    
    JSpinner verticesField = new JSpinner(new SpinnerNumberModel(0,0, 1000,1));
    JSpinner edgesField = new JSpinner(new SpinnerNumberModel(0,0, 1000,1));
    //...
    public GraphForm()
    {
    	this.frame.setSize(500,600);
        CatalogList list = new CatalogList();
        frame.add(list);
    	this.frame.setVisible(true);
    }
    private void init() {               
        //...
    //    addButton.addActionListener(//...);
    }
    private void addGraph() {
     //   frame.list.addGraph(//...);
    }
}