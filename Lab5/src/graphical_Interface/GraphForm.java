package graphical_Interface;

import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.*;

public class GraphForm extends JPanel {
	
    private final CatalogFrame frame = new CatalogFrame();

    String[] tipes = {"simple", "directed"};
    TextField nameTextField = new TextField(20);
    TextField defPathTextField = new TextField(20);
    TextField imgPathTextField = new TextField(20);
    
    JComboBox graphT = new JComboBox(tipes);
    JSpinner verticesField = new JSpinner(new SpinnerNumberModel(0,0, 1000,1));
    JSpinner edgesField = new JSpinner(new SpinnerNumberModel(0,0, 1000,1));
    
    JLabel titleLabel = new JLabel("Name of graph");
    JLabel definitionPath = new JLabel("Path of the definition file");
    JLabel imagePath = new JLabel("Path of the image file");
    JLabel graphType = new JLabel("Graph type");
    JLabel vericesNr = new JLabel("Number of verceces");
    JLabel edgesNr = new JLabel("Number of edges");
    public GraphForm()
    {
    	this.frame.setSize(500,600);
        CatalogList list = new CatalogList();
        titleLabel.add(nameTextField);
        titleLabel.setVerticalTextPosition(JLabel.TOP);
        titleLabel.setHorizontalTextPosition(JLabel.LEFT);
        this.frame.add(titleLabel);
        this.frame.add(nameTextField);
        this.frame.add(definitionPath);
        this.frame.add(defPathTextField);
        this.frame.add(imagePath);
        this.frame.add(graphT);
        list.setSize(100, 200);
        list.addGraph("ANA ARE MERE");
        this.frame.add(list);
        new ControlPanel(frame);
        nameTextField.setBounds(1, 2, 10, 50);
        frame.setLayout(new FlowLayout());
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