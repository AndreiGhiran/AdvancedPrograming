package Backend;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Graph completeGraph;
    private List<Graph> playerGraphs = new ArrayList<>();

    public Board(int numberOdEdges) {
        List<Edge> generatedEdges = new ArrayList<>();
        for(int i = 0; i < numberOdEdges; i+=2){
            generatedEdges.add(new Edge(i, i+1));
        }
        completeGraph = new Graph(generatedEdges);
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

    public synchronized Edge extract(int node1, int node2){
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
}
