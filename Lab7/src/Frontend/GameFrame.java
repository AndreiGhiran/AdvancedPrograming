package Frontend;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameFrame extends JFrame {
    MainPanel mainPanel = new MainPanel(12);
    PlayerPanelContainer playersContainer = new PlayerPanelContainer(3);

    public GameFrame() {
        super("Graph game, yeey");
        init();
    }

    private void init() {
        this.getContentPane().setPreferredSize( Toolkit.getDefaultToolkit().getScreenSize());
        this.setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainPanel.setPreferredSize(new Dimension(200, 200));
        mainPanel.setBackground(Color.gray);
        playersContainer.setPreferredSize(new Dimension(300, 300));
        playersContainer.setBackground(Color.gray);

        BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS);

        this.setLayout(boxLayout);

        add(mainPanel);
        add(playersContainer);

        this.pack();

        buttonListeners();
    }

    private void buttonListeners() {
        for (Button edgeButton : mainPanel.edgeButtons) {
            edgeButton.addActionListener(e -> {
                System.out.println(mainPanel.extract(edgeButton));
            });
        }
    }
}
