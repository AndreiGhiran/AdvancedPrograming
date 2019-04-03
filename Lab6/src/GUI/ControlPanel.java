package GUI;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel{
	   
    private final DrawingFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    
    final JFileChooser filechoser = new JFileChooser();

    public ControlPanel(DrawingFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        this.add(this.loadBtn);
        this.add(this.saveBtn);
        this.add(this.resetBtn);
        
        loadBtn.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		loadImg();
        	}
        });
    }
    private void loadImg() {
    	int n = this.filechoser.showOpenDialog(this.frame);
    	filechoser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    	File path = filechoser.getCurrentDirectory();
    	System.out.println(path);
    	BufferedImage img = null;
    	try {
    		img = ImageIO.read(path);
    	}catch(IOException e) {
    		System.out.println("IO Exception");
    	}
    }
}
