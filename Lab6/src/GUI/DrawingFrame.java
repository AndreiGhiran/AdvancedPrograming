package GUI;

import javax.swing.*;

public class DrawingFrame extends JFrame {
    Canvas canvas = new Canvas();
    Toolbar toolbar = new Toolbar();
    ControlPanel controlPanel = new ControlPanel();

    public DrawingFrame(){
        super("Graph Drawing");
        init();
    }

    private void init(){

    }
}
