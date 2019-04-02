package GUI;

import Shapes.NodeShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Canvas extends JPanel {
    BufferedImage image = new BufferedImage(1500, 800, BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = image.createGraphics();
    List<NodeShape> nodes = new ArrayList<>();
    int nodeNumber = 0;

    public Canvas(){
        init();
    }

    private void init(){
        System.out.println("init");
        paintComponent(graphics);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("event");
                drawNode(e.getX(), e.getY());
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
//        g2.drawString("Heeere", 20 + (int) (Math.random() * (200-20)+1), 20 + (int) (Math.random() * (200-20)+1));
        nodeNumber = 0;
        for(NodeShape node : nodes) {
            g2.setColor(Color.BLACK);
            g2.fill(node);
            g2.setColor(Color.WHITE);
            g2.drawString(String.valueOf(nodeNumber), (int) node.getCenterX() -3, (int) node.getCenterY() +3);
            nodeNumber++;
        }
    }

    private void drawNode(int x, int y){

        nodes.add(new NodeShape(x,y, 50, nodeNumber));
        nodeNumber++;
    }
}
