package Backend;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Graph completeGraph;
    private List<Graph> playerGraphs = new ArrayList<>();
    private int numberOfPlayrs=0;
    private int index = 1;

    public Board(int numberOdEdges, int numberOfPlayers) {
        List<Edge> generatedEdges = new ArrayList<>();
        for(int i = 0; i < numberOdEdges; i+=2){
            generatedEdges.add(new Edge(i, i+1));
        }
        completeGraph = new Graph(generatedEdges);
        this.numberOfPlayrs=numberOfPlayers;
    }

    public Graph getCompleteGraph() {
        return completeGraph;
    }

    public void setCompleteGraph(Graph completeGraph) {
        this.completeGraph = completeGraph;
    }

    public List<Graph> getPlayerGraphs() {
        return playerGraphs;
    }

    public void setPlayerGraphs(List<Graph> playerGraphs) {
        this.playerGraphs = playerGraphs;
    }

    public synchronized Edge extract(int node1, int node2 , int playerIndex ){
    	while(this.index!=playerIndex)
    	{
    		try
    		{
    			wait();
    		}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception trown at board for " + playerIndex);
				e.printStackTrace();
			}
    	}
    	System.out.println("current index: "+ this.index);
        List<Edge> completeGraphEdges = completeGraph.getEdges();
        for(Edge edge : completeGraphEdges)
            if(edge.getNode1() == node1 && edge.getNode2() == node2){
                completeGraphEdges.remove(edge);
                completeGraph.setEdges(completeGraphEdges); 
                return edge;
            }
        
        return null;
    }

    public boolean isEmpty(){
        return completeGraph.getEdges().isEmpty();
    }

	public Edge extract() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setNumberOfPlayers(int number) {
		this.numberOfPlayrs=number;
	}
	public void show()
	{
		System.out.println("board nr players: " + this.numberOfPlayrs);
		System.out.println("board initial index: " + this.index);
	}
	public synchronized void nextPlayer() {
        //System.out.println("NextPlayer, index=" + this.index + " nr of players= " + this.numberOfPlayrs);
        if(this.index == this.numberOfPlayrs-1)
        {
        	this.index=1;
       // 	System.out.println("ramura 1 " + this.index);
        }
        else
        {
        	this.index++;
      //      System.out.println("ramura 2 " + this.index);
        }
        notify();
	}
}
