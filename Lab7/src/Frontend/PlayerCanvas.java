package Frontend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerCanvas extends JPanel {
    private List<Button> collectedEdges = new ArrayList<>();
    public int index;

    public PlayerCanvas(int id) {
        this.index = id;
        init();
    }

    private void init() {
        System.out.println("here");
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(400, 400));
        this.setBorder(BorderFactory.createTitledBorder("Player " + index));
    }

    public void addEdge(String buttonName) {
        Button button = new Button(buttonName);
        collectedEdges.add(button);
        this.add(button);
    }
}
