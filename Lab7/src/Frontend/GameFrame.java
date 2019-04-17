package Frontend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import Backend.*;

public class GameFrame extends JFrame {
    MainPanel mainPanel = new MainPanel(10);
    PlayerPanelContainer playersContainer = new PlayerPanelContainer(3);
    private Game game;

    public GameFrame(Game game) {
        super("Graph game, yeey");
        this.game=game;
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

    private synchronized void buttonListeners() {
        for (Button edgeButton : mainPanel.edgeButtons) {
            edgeButton.addActionListener(e -> {
               String edge = mainPanel.extract(edgeButton);
               int index = this.game.getBoard().getCurrentIndex();
               List<PlayerCanvas> canvases = this.playersContainer.getPlayerCnavas(); 
               for (PlayerCanvas canvas : canvases)
               {
            	   if(canvas.index==index)
            	   {
            		   canvas.addEdge(edge);
            	   }
               }
               List<Player> players = this.game.getPlayers();
               for(Player player : players)
               {
            	  if(player.getIndex()==index)
            	  {
            		  player.doTheThing((int) edge.charAt(0), (int) edge.charAt(2));
            		  
            	  }
               }
            });
        }
    }
}
