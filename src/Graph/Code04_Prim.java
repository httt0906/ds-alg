package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Code04_Prim {

    public static Graph prim(Graph graph){
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        HashSet<Edge> edgeSet = new HashSet<>();
        int r = (int) ((graph.nodes.size() + 1) * Math.random());

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        Node p = graph.nodes.get(r);
        Edge e = null;
        for (int i = 0; i < graph.nodes.size() - 1; i++) {
            nodeMap.put(i, p);
            for (Edge edge : p.edges) {
                if (!queue.contains(edge)){
                    queue.add(edge);
                }
            }
            e = queue.poll();
            while (nodeMap.values().contains(e.to)){
                e = queue.poll(); 
            }
            edgeSet.add(e);
            p = e.to;
        }
        Graph g = new Graph();
        g.nodes = nodeMap;
        g.edges = edgeSet;
        return g;
    }
    
}
