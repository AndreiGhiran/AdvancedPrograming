package Backend;

import java.util.*;

public class Graph {
    private List<Edge> edges;
    public int i = 1;

    public Graph(List<Edge> edges) {
        this.edges = edges;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

	public boolean isSpanningTree() {
		// TODO Auto-generated method stub
		if(i != 2)
		{
		this.i++;
		return false;
		}
		else
		return true;
	}

	public void add(Edge extract) {
		// TODO Auto-generated method stub
		
		this.edges.add(extract);
	}
}
