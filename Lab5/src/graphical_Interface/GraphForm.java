package graphical_Interface;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class GraphForm extends JPanel {
	
    private final CatalogFrame frame;

    String[] tipes = {"simple", "directed"};
    TextField nameTextField = new TextField(70);
    TextField defPathTextField = new TextField(70);
    TextField imgPathTextField = new TextField(70);
    
    JComboBox graphT = new JComboBox(tipes);
    JSpinner verticesField = new JSpinner(new SpinnerNumberModel(0,0, 1000,1));
    JSpinner edgesField = new JSpinner(new SpinnerNumberModel(0,0, 1000,1));
    
    JLabel nameLabel = new JLabel("Name of graph",JLabel.LEFT);
    JLabel definitionPath = new JLabel("Path of the definition file");
    JLabel imagePath = new JLabel("Path of the image file");
    JLabel graphType = new JLabel("Graph type");
    JLabel vericesNr = new JLabel("Number of verceces");
    JLabel edgesNr = new JLabel("Number of edges");
    
    public GraphForm(CatalogFrame frame) {
        this.frame = frame;
    	init();
    }
    
    private void init() {
    	GridBagLayout gridBag = new GridBagLayout();
    	this.setLayout(gridBag);
    	
    	//main panel
    	GridBagConstraints c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=0;
    	this.add(nameLabel, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=1;
    	c.weightx=2;
    	c.weighty=2;
    	this.add(nameTextField, c);
    	
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=2;
    	this.add(definitionPath,c);
    	
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=3;
    	this.add(defPathTextField, c);
    	
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=4;
    	this.add(imagePath,c);
    	
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=5;
    	this.add(imgPathTextField, c);
    	
    	//info panel
    	JPanel graphInfoPanel = new JPanel();
    	graphInfoPanel.setLayout(new FlowLayout());
    	graphInfoPanel.add(graphType);
    	graphInfoPanel.add(graphT);
    	graphInfoPanel.add(vericesNr);
    	graphInfoPanel.add(verticesField);
    	graphInfoPanel.add(edgesNr);
    	graphInfoPanel.add(edgesField);
    	
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=6;
    	this.add(graphInfoPanel, c);
    	
    	//add button
    	JButton addGraphButt = new JButton("Add to repository");
    	c = new GridBagConstraints();
    	c.gridx=0;
    	c.gridy=7;
    	this.add(addGraphButt,c);
    	
    	//border and title
    	TitledBorder border = new TitledBorder("Add graph");
    	border.setTitleJustification(TitledBorder.LEFT);
    	border.setTitlePosition(TitledBorder.TOP);
    	this.setBorder(border);
      	
        //...
    //    addButton.addActionListener(//...);
    }
    
    private void addGraph() {
     //   frame.list.addGraph(//...);
    }
}