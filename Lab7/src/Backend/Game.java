package Backend;

import java.util.*;

public class Game {

	 private Board board;
	 private final List<Player> players = new ArrayList<>();
	 private int numberOfNodes;
	 private Player winner = null;
	 private int playerIndex = 1;
  
	 public void setNrOfNodes(int numberOfNodes)
	 {
		 this.numberOfNodes=numberOfNodes;
	 }
	 public void addPlayer(Player player) {
	        players.add(player);
	        player.setGame(this);
	        player.setIndex(playerIndex);
	        player.serNrOfNodes(this.numberOfNodes);
	        this.playerIndex++;
	    }
	    //Create getters and setters
	    //Create the method that will start the game: start one thread for each player
	    
	public void setWinner(Player player) {
		this.winner=player;
		System.out.println("WINNER: " + this.winner.getName());
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
	
	public List<Player> getPlayers()
	{
		return this.players;
	}
	
	
}
