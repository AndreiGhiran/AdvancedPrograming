package graphical_Interface;

import javax.swing.*;

public class GraphForm extends JPanel {
    private final CatalogFrame frame;
    JLabel titleLabel = new JLabel("Name of the graph");
    //...
    JSpinner verticesField = new JSpinner(new SpinnerNumberModel(0, 1000));
    //...
    private void init() {               
        //...
        addButton.addActionListener(//...);
    }
    private void addGraph() {
        frame.list.addGraph(//...);
    }
}