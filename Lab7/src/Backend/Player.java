package Backend;

import java.util.ArrayList;
import java.util.List;

import Backend.*;

public class Player implements Runnable {
  private static final long THINKING_TIME = 5000;
	//  ....
    private String name;
    private Game game;
    private Graph graph;
    private int playerIndex;
    //  ...
    
    public Player(String name) {
    	this.name=name;
    	List<Edge> edges = new ArrayList<Edge>();
    	this.graph = new Graph(edges);
    	
    }
    
    private boolean play() throws InterruptedException {
        Board board = game.getBoard();
        if (board.isEmpty()) { return false; }
        graph.add( board.extract(0,1,this.playerIndex));
    	System.out.println(this.name + " extracted");
    	board.nextPlayer();
        Thread.sleep(THINKING_TIME); //declare this constant
        
        if (graph.isSpanningTree()) {
	        game.setWinner(this);
        }
//        ...
        return true;
	}
    
    public void setGame(Game game) {
    	this.game=game;
    }
    
    @Override
    public void run() {       //method, that will repeatedly extract edges

    	    try {
				while(this.play() && game.getWinner()==null)
					System.out.println(this.name + ": still plaing");
				System.out.println(this.name + " play done");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception trown at " + this.name);
				e.printStackTrace();
			}
   	
    }
    // implement the toString() method

	public void setIndex(int playerIndex) {
		// TODO Auto-generated method stub
		this.playerIndex=playerIndex;
	}
}