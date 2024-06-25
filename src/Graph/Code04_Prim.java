package Graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class Code04_Prim {

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }

    }

    public static Graph prim(Graph graph) {
        // index from Node to NodeIndex(Integer)
        HashMap<Node, Integer> index = new HashMap<>();
        for (Map.Entry<Integer, Node> entry : graph.nodes.entrySet()) {
            index.put(entry.getValue(), entry.getKey());
        }

        // MST newNodes newEdges chooseEdgeQueue
        HashMap<Integer, Node> nodes = new HashMap<>();
        HashSet<Edge> edgeSet = new HashSet<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>(new EdgeComparator());

        // Random Choose Node
        int r = (int) ((graph.nodes.size() + 1) * Math.random());

        Node p = graph.nodes.get(r);
        nodes.put(index.get(p), p);
        Edge e = null;
        for (int i = 0; i < graph.nodes.size() - 1; i++) {
            for (Edge edge : p.edges) {
                if (!queue.contains(edge)) {
                    queue.add(edge);
                }
            }
            e = queue.poll();
            while (nodes.values().contains(e.to)) {
                e = queue.poll();
            }
            edgeSet.add(e);
            p = e.to;
            nodes.put(index.get(p), p);
        }
        
        edgeSet = GraphUtils.dirEdges2UnDirEdges(edgeSet);
        return GraphUtils.createGraph(edgeSet, index);
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
        graph = prim(graph);
        graph.printGraph();


    }

}
