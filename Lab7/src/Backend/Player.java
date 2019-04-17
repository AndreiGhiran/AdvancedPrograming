package Backend;

import java.util.ArrayList;
import java.util.List;

import Backend.*;

public class Player implements Runnable {
  private static final long THINKING_TIME = 1000;
	//  ....
    private String name;
    private Game game;
    private Graph graph;
    public int playerIndex;
    private int numberOfNodes;
    private int nod1=-1;
    private int nod2=-1;
    //  ...
    
    public Player(String name) {
    	this.name=name;
    	List<Edge> edges = new ArrayList<Edge>();
    	this.graph = new Graph(edges,this.numberOfNodes);
    	
    }

	public void setIndex(int playerIndex) {
		// TODO Auto-generated method stub
		this.playerIndex=playerIndex;
	}

	public void serNrOfNodes(int numberOfNodes) {
		// TODO Auto-generated method stub
		this.numberOfNodes=numberOfNodes;
	}

    
    private boolean play() throws InterruptedException {
        Board board = game.getBoard();
        if (board.isEmpty()) { return false; }
        if(this.nod1!=-1 && this.nod2!=-1)
        {
           graph.add( board.extract(nod1,nod2,this.playerIndex));
           this.nod1=-1;
           this.nod2=-1;
           board.nextPlayer();
    	System.out.println(this.name + " extracted");
        Thread.sleep(THINKING_TIME); //declare this constant
        
        if (graph.isSpanningTree()) {
	        game.setWinner(this);
        }
        }
        Thread.sleep(THINKING_TIME);
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
    public int getIndex() {
    	return this.playerIndex;
    }
    // implement the toString() method

	public void doTheThing(int nod1, int nod2) {
		// TODO Auto-generated method stub
		this.nod1=nod1;
		this.nod2=nod2;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
}