package Graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	public HashMap<Integer, Node> nodes;
	public HashSet<Edge> edges;

	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}

	public void printGraphNodes(){
		GraphUtils.printGraphNodes(this.nodes);
	}


	public void printGraphEdges(){
		GraphUtils.printGraphEdges(this.edges, this.nodes);
	}

	public void printGraph(){
		printGraphNodes();
		printGraphEdges();
	}
}
