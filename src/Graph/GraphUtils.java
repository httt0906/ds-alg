package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class GraphUtils {
    
	// 将非无向图变为无向图
    public static HashSet<Edge> dirEdges2UnDirEdges(HashSet<Edge> dirEdges){
		HashSet<Edge> edges = new HashSet<>();
		for (Edge edge : dirEdges) {
			edges.add(edge);
			edges.add(new Edge(edge.weight, edge.to, edge.from));
		}
		return edges;
	}

	// 根据 matrix 创建图
	// [weight][nodeFromIndex(Integer)][nodeToIndex(Integer)]
	public static Graph createGraph(Integer[][] matrix) {
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {
			Integer weight = matrix[i][0];
			Integer from = matrix[i][1];
			Integer to = matrix[i][2];
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge newEdge = new Edge(weight, fromNode, toNode);
			fromNode.nexts.add(toNode);
			fromNode.out++;
			toNode.in++;
			fromNode.edges.add(newEdge);
			graph.edges.add(newEdge);
		}
		return graph;
	}

	// 根据 edgeSet 创建图
	public static Graph createGraph(HashSet<Edge> edges, HashMap<Node, Integer> index) {
		Integer[][] matrix = new Integer[edges.size()][3];
		int i = 0;
		for (Edge edge : edges) {
			matrix[i][0] = edge.weight;
			matrix[i][1] = index.get(edge.from);
			matrix[i][2] = index.get(edge.to);
			i = i + 1;
		}
		return createGraph(matrix);
	}

	// 打印图的点
	public static void printGraphNodes(HashMap<Integer, Node> nodes){
		System.out.println("Grpah:Nodes.-.-.-.-.-.-.-.-.");
		System.out.printf("%-8s|%-8s|%-8s|%-8s\n", "Node", "Value", "In", "Out");
		Integer key = null;
		Node value = null;
		for (Map.Entry<Integer, Node> entry : nodes.entrySet()) {
			key = entry.getKey();
			value = entry.getValue();
			System.out.printf("%- 8d|%- 8d|%- 8d|%- 8d\n",
			 key, value.value, value.in, value.out);
		}
	}

	// 打印图的边
	public static void printGraphEdges(HashSet<Edge> edges, HashMap<Integer, Node> nodes){
		System.out.println("Grpah:Edges.-.-.-.-.-.-.-.-.");
		System.out.printf("%-8s|%-8s|%-8s\n", "Weight", "From", "To");
		HashMap<Node,Integer> index = new HashMap<>();
		for (Map.Entry<Integer, Node> entry : nodes.entrySet()){
			index.put(entry.getValue(), entry.getKey());
		}
		for (Edge edge : edges) {
			System.out.printf("%- 8d|%- 8d|%- 8d\n", 
			edge.weight, index.get(edge.from),index.get(edge.to));	
		}
	}

	public static HashMap<Node, Integer> convertIndex (HashMap<Integer, Node> nodes){
		HashMap<Node, Integer> index = new HashMap<>();
		for (Integer i : nodes.keySet()) {
			index.put(nodes.get(i), i);			
		}
		return index;
	}
}
