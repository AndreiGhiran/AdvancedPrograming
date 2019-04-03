package GUI;

import Shapes.NodeShape;
import sun.awt.image.ToolkitImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    BufferedImage image = new BufferedImage(1500, 800, BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = image.createGraphics();
    List<NodeShape> nodes = new ArrayList<>();
    int nodeNumber = 0;
    Color colors[] = {Color.red, Color.blue, Color.black, Color.GRAY, Color.green, Color.yellow};

    public Canvas() {
        init();
    }

    public Canvas(Graphics2D aux){
        this.graphics = aux;
    }

    private void init() {
        paintComponent(graphics);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
//        g2.drawString("Heeere", 20 + (int) (Math.random() * (200-20)+1), 20 + (int) (Math.random() * (200-20)+1));
        nodeNumber = 0;
        for (NodeShape node : nodes) {
            g2.setColor(colors[node.getColorIndex()]);
            if ((node.getType().equals("Fill"))) {
                g2.fill(node);
            } else {
                g2.draw(node);
            }
            if (node.getColorIndex() == 2 && node.getType().equals("Fill"))
                g2.setColor(Color.WHITE);
            else
                g2.setColor(Color.BLACK);
            g2.drawString(String.valueOf(nodeNumber), (int) node.getCenterX() - 3, (int) node.getCenterY() + 3);
            nodeNumber++;
        }
    }

    public void drawNode(int x, int y, int size, int color, String type) {

        nodes.add(new NodeShape(x, y, size, color, type));
        nodeNumber++;
    }

    public void loadImage(String path){
//        Image img = Toolkit.getDefaultToolkit().getImage(path);
//        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null),
//                BufferedImage.TYPE_INT_RGB);
//        Graphics2D aux = bufferedImage.createGraphics();
//        Canvas canvas2 = new Canvas(aux);
//        this = canvas2;
    }

    public void saveImage(String path){
        BufferedImage bImg = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D cg = bImg.createGraphics();
        this.paintAll(cg);
        try {
            if (ImageIO.write(bImg, "png", new File(path)))
            {
                System.out.println("-- saved");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
