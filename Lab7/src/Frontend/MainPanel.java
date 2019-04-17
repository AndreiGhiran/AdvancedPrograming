package Frontend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JPanel {
    int numberOfNodes;
    List<Button> edgeButtons = new ArrayList<>();

    public MainPanel(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        init();
    }

    private void init() {
        this.setLayout(new FlowLayout());
//        this.setPreferredSize(new Dimension(1000, 200));
        this.setBorder(BorderFactory.createTitledBorder("Complete Graph"));

        for (int i = 1; i <= numberOfNodes; i++)
            for (int j = i + 1; j <= numberOfNodes; j++) {
                edgeButtons.add(new Button(i + "-" + j));
            }

        for (Button edgeButton : edgeButtons)
            add(edgeButton);

    }

    public String extract(Button edgeButton) {
        this.remove(edgeButton);
        return edgeButton.getLabel();
    }
}
