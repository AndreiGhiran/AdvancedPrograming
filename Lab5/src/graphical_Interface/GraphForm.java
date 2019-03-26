package graphical_Interface;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class GraphForm extends JPanel {
	
    private final CatalogFrame frame = new CatalogFrame();

    String[] tipes = {"simple", "directed"};
    TextField nameTextField = new TextField(70);
    TextField defPathTextField = new TextField(20);
    TextField imgPathTextField = new TextField(20);
    
    JComboBox graphT = new JComboBox(tipes);
    JSpinner verticesField = new JSpinner(new SpinnerNumberModel(0,0, 1000,1));
    JSpinner edgesField = new JSpinner(new SpinnerNumberModel(0,0, 1000,1));
    
    JLabel nameLabel = new JLabel("Name of graph",JLabel.LEFT);
    JLabel definitionPath = new JLabel("Path of the definition file");
    JLabel imagePath = new JLabel("Path of the image file");
    JLabel graphType = new JLabel("Graph type");
    JLabel vericesNr = new JLabel("Number of verceces");
    JLabel edgesNr = new JLabel("Number of edges");
    public GraphForm()
    { 	
    	GridBagLayout gridBag = new GridBagLayout();
    	this.frame.setSize(550,450);
    	this.frame.setLayout(new FlowLayout());
    	JPanel addGraphPanel = new JPanel();
    	JPanel graphListPanel = new JPanel();
    	addGraphPanel.setLayout(gridBag);
    	TitledBorder border = new TitledBorder("Add graph");
    	
    	border.setTitleJustification(TitledBorder.LEFT);
    	border.setTitlePosition(TitledBorder.TOP);
    	GridBagConstraints c = new GridBagConstraints(); //Define the constraints 
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=0;
    	gridBag.setConstraints(nameLabel, c);
    	addGraphPanel.add(nameLabel );
    	c.gridx=0;
    	c.gridy=1;
    	gridBag.setConstraints(nameTextField, c);
    	addGraphPanel.add(nameTextField );
    	c.gridx=0;
    	c.gridy=2;
    	gridBag.setConstraints(definitionPath, c);
    	addGraphPanel.add(definitionPath);
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=3;
    	gridBag.setConstraints(defPathTextField, c);
    	addGraphPanel.add(defPathTextField);
    	c.gridx=0;
    	c.gridy=4;
    	gridBag.setConstraints(imagePath, c);
    	addGraphPanel.add(imagePath);
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=5;
    	gridBag.setConstraints(imgPathTextField, c);
    	addGraphPanel.add(imgPathTextField);
    	addGraphPanel.setBorder(border);

    	frame.add(addGraphPanel);
    	
     	CatalogList list = new CatalogList();
        list.setSize(100, 200);
        list.addGraph("ANA ARE MERE");
    	graphListPanel.add(list);
      //  this.frame.add(titleLabel);
      //  this.frame.add(nameTextField);
      //  this.frame.add(definitionPath);
      //  this.frame.add(defPathTextField);
      //  this.frame.add(imagePath);
      //  this.frame.add(graphT);
      //  this.frame.add(list);
      //  new ControlPanel(frame);
      //  nameTextField.setBounds(1, 2, 100, 50);
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