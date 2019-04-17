package Backend;

import java.util.*;

public class Game {

	 private Board board;
	 private final List<Player> players = new ArrayList<>();
	 private Player winner = null;
	 private int playerIndex = 1;
  
	 public void addPlayer(Player player) {
	        players.add(player);
	        player.setGame(this);
	        player.setIndex(playerIndex);
	        this.playerIndex++;
	    }
	    //Create getters and setters
	    //Create the method that will start the game: start one thread for each player
	    
	public void setWinner(Player player) {
		this.winner=player;
	}
	
	public void start() {
		this.board.setNumberOfPlayers(playerIndex);
		for (Player player : players)
		{
			new Thread(player).start();
		}
	}

	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board2) {
		// TODO Auto-generated method stub
		this.board=board2;
	}

	public Object getWinner() {
		// TODO Auto-generated method stub
		return this.winner;
	}
	
	public void showGameInfo()
	{
		this.board.show();
	}
	
}
