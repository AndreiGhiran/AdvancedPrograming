package Backend;

public class Edge {
    private int node1;
    private int node2;

    public Edge(int node1, int node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    public int getNode1() {
        return node1;
    }

    public void setNode1(int node1) {
        this.node1 = node1;
    }

    public int getNode2() {
        return node2;
    }

    public void setNode2(int node2) {
        this.node2 = node2;
    }

	public void show() {
		// TODO Auto-generated method stub
		System.out.println("node1: "+ this.node1 + " node 2: " + this.node2);
	}
}
