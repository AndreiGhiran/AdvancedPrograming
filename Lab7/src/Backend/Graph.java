package Backend;

import java.util.*;

public class Graph {
    private List<Edge> edges;
    public int nrOfNodes;
    public int i=1;

    public Graph(List<Edge> edges, int numberOfNodes) {
        this.edges = edges;
        this.nrOfNodes=numberOfNodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

	public void add(Edge extract) {
		// TODO Auto-generated method stub
		
		this.edges.add(extract);
	}
	
	public void show()
	{
		int index = 1;
		for(Edge edge : edges) {
			System.out.println("edge " + index + ": ");
			edge.show();
			index++;
		}
	}
	
     boolean isCyclicUnit(int v, Boolean visited[], int parent) {
		visited[v]=true;
		int i;
		
		for(Edge edge : this.edges)
		{
			if(edge.getNode1()==v)
			{
				i=edge.getNode2();
				if(!visited[i])
				{
					if(isCyclicUnit(i,visited,v))
						return true;
				}
				else if (i!=parent)
					return true;
			}
			else
		    if( edge.getNode2()==v)
			{
		    	i = edge.getNode1();
				if(!visited[i])
				{
					if(isCyclicUnit(i,visited,v))
						return true;
				}
				else if (i!=parent)
					return true;
			}
		}
		return false;
		
	}
     
 	public boolean isSpanningTree() {
		// TODO Auto-generated method stub
 		Boolean visited[]=new Boolean[this.nrOfNodes];
 		for (int i=0;i<this.nrOfNodes;i++)
 		{
 			visited[i]=false;
 		}
 		
 		if (isCyclicUnit(0, visited, -1))
 			return false;
 		for(int u = 0;u<this.nrOfNodes;u++)
 		{
 			if(!visited[u])
 				return false;
 		}
		return true;
	}
}
