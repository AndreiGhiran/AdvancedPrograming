package graphical_Interface;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class GraphForm extends JPanel {
	
    private final CatalogFrame frame = new CatalogFrame();

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
    public GraphForm()
    { 	
    	GridBagLayout gridBag = new GridBagLayout();
    	this.frame.setSize(565,350);
    	this.frame.setLayout(gridBag);
    	JPanel addGraphPanel = new JPanel();
    	JPanel graphInfoPanel = new JPanel();
    	addGraphPanel.setLayout(gridBag);
    	graphInfoPanel.setLayout(new FlowLayout());
    	TitledBorder border = new TitledBorder("Add graph");
    	
    	border.setTitleJustification(TitledBorder.LEFT);
    	border.setTitlePosition(TitledBorder.TOP);
    	
    	GridBagConstraints c = new GridBagConstraints(); //Define the constraints
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=0;
    	c.weightx=1;
    	c.weighty=1;
    	addGraphPanel.add(nameLabel, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=1;
    	c.weightx=2;
    	c.weighty=2;
    	addGraphPanel.add(nameTextField, c);
    	
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=2;
    	c.weightx=3;
    	c.weighty=3;
    	addGraphPanel.add(definitionPath,c);
    	
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=3;
    	c.weightx=4;
    	c.weighty=4;
    	addGraphPanel.add(defPathTextField, c);
    	
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=4;
    	c.weightx=5;
    	c.weighty=5;
    	addGraphPanel.add(imagePath,c);
    	
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=5;
    	c.weightx=6;
    	c.weighty=6;
    	addGraphPanel.add(imgPathTextField, c);
    	
    	JButton addGraphButt = new JButton("Add to repository");
    	c = new GridBagConstraints();
    	c.gridx=0;
    	c.gridy=7;
    	addGraphPanel.add(addGraphButt,c);
    	
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
    	addGraphPanel.add(graphInfoPanel, c);
    	
    	addGraphPanel.setBorder(border);
    	
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=0;
    	frame.add(addGraphPanel, c);
    	
    	CatalogList list = new CatalogList();
    	list.addGraph("ceva");
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.BOTH;
    	c.gridx=0;
    	c.gridy=1;
    	frame.add(list, c);
    	
    	c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx=0;
    	c.gridy=2;
    
    	frame.add(new ControlPanel(frame),c);
    	
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