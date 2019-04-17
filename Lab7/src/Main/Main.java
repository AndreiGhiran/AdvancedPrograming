package Main;

import Backend.*;
import Frontend.GameFrame;

public class Main {

    public static void main(String[] args) {
    	 Game game = new Game();
         game.setBoard(new Board(10,3));
         game.addPlayer(new Player("Player 1"));
         game.addPlayer(new Player("Player 2"));
         game.addPlayer(new Player("Player 3"));
         game.showGameInfo();
         game.start();
         System.out.println("is spanning tree test: " + game.getBoard().isSpanningTreeTest());
         System.out.println("main done");

        new GameFrame().setVisible(true);
    }
}
