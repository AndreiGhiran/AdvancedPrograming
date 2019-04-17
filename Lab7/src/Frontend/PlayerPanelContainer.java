package Frontend;

import Backend.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerPanelContainer extends JPanel {
    List<PlayerCanvas> playersCanvas = new ArrayList<>();
    private int generateID = 1;
    private int numberOfPlayers;

    public PlayerPanelContainer(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        init();
    }

    private void init() {
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createTitledBorder("Players"));
//        this.add(new Button("adh"));
//        this.add(new Button("sd"));
//        this.add(new Button("addfsdfh"));
//        JPanel test = new JPanel();
//        test.setBorder(BorderFactory.createTitledBorder("DOOOO it"));
//        this.add(test);
        addPlayers(numberOfPlayers);
    }

    private void addPlayers(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            PlayerCanvas player = new PlayerCanvas(generateID);
            playersCanvas.add(player);
            this.add(player);
            generateID++;
        }
    }
}
