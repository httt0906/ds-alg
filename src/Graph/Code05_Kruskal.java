package Graph;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class Code05_Kruskal {
    /**
     * 1. 初始化 各个节点分别指向各自集合 各边按照权重放入队列
     * 2. 每次选择一条权值最小的边 不成环就更新 成环就放弃
     * @param graph
     * @return
     */

    public static class UnionFind {
		private HashMap<Node, Node> fatherMap;
		private HashMap<Node, Integer> rankMap;

		public UnionFind() {
			fatherMap = new HashMap<Node, Node>();
			rankMap = new HashMap<Node, Integer>();
		}

		private Node findFather(Node n) {
			Node father = fatherMap.get(n);
			if (father != n) {
				father = findFather(father);
			}
			fatherMap.put(n, father);
			return father;
		}

		public void makeSets(Collection<Node> nodes) {
			fatherMap.clear();
			rankMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				rankMap.put(node, 1);
			}
		}

		public boolean isSameSet(Node a, Node b) {
			return findFather(a) == findFather(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aFather = findFather(a);
			Node bFather = findFather(b);
			if (aFather != bFather) {
				int aFrank = rankMap.get(aFather);
				int bFrank = rankMap.get(bFather);
				if (aFrank <= bFrank) {
					fatherMap.put(aFather, bFather);
					rankMap.put(bFather, aFrank + bFrank);
				} else {
					fatherMap.put(bFather, aFather);
					rankMap.put(aFather, aFrank + bFrank);
				}
			}
		}
	}
    public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

	}

    public static Graph kruskal(Graph graph){
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());

        PriorityQueue<Edge> queue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges){
            queue.add(edge);
        }
        HashSet<Edge> edges = new HashSet<>();
        Edge edge = null;
        while (!queue.isEmpty()) {
            edge = queue.poll();
            if (!unionFind.isSameSet(edge.from, edge.to)){
                edges.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }

        HashMap<Node, Integer> index = new HashMap<>();
        for (Map.Entry<Integer, Node> entry : graph.nodes.entrySet()) {
            index.put(entry.getValue(), entry.getKey());
        }

        edges = GraphUtils.dirEdges2UnDirEdges(edges);
        return GraphUtils.createGraph(edges, index);
    }

    public static void main(String[] args) {
        Integer[][] graphMatrix = {
            { 2, 1, 2 }, { 2, 2, 1 },
            { 4, 1, 3 }, { 4, 3, 1 },
            { 1, 1, 4 }, { 1, 4, 1 },
            { 3, 2, 4 }, { 3, 4, 2 },
            { 10, 2, 5 }, { 10, 5, 2 },
            { 2, 3, 4 }, { 2, 4, 3 },
            { 5, 3, 6 }, { 5, 6, 3 },
            { 7, 4, 5 }, { 7, 5, 4 },
            { 8, 4, 6 }, { 8, 6, 4 },
            { 4, 4, 7 }, { 4, 7, 4 },
            { 6, 5, 7 }, { 6, 7, 5 },
            { 1, 6, 7 }, { 1, 7, 6 }
    };

    Graph graph = GraphUtils.createGraph(graphMatrix);
    graph.printGraph();
    graph = kruskal(graph);
    graph.printGraph();
    }
    
}
