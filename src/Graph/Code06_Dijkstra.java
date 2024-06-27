package Graph;

import java.util.HashMap;
import java.util.HashSet;

public class Code06_Dijkstra {

    public static Integer[][] dijkstra(Graph graph, Node node){
        // 1. 初始化算法起点 S V-S 
        HashMap<Node, Integer> index = GraphUtils.convertIndex(graph.nodes);

        HashMap<Node, Integer> dist = new HashMap<>();
        HashMap<Node, Node> pre = new HashMap<>();

        HashSet<Node> S = new HashSet<>();
        HashSet<Node> V = new HashSet<>();
        for (Node n : index.keySet()) {
            V.add(n);
            pre.put(n, null);
            dist.put(n, null);
        }
        dist.put(node, 0);

        // 2. 从V-S中选择出具有最短特殊路径的节点u 特殊路径是从源出发只经过S中点到达u的路径
        
        Node p = null;
        while (!V.isEmpty()){
            p = findNotNullMinDistNodeInSetV(dist, V);
            // System.out.println("Get" + index.get(p));
            V.remove(p);
            S.add(p);

            if (p == null) {
                break;
            }

            for (Edge e : p.edges) {
                if (dist.get(e.to) == null || dist.get(e.to) > dist.get(p) + e.weight){
                    dist.put(e.to, dist.get(p) + e.weight);
                    pre.put(e.to, p);
                }
            }
        }

        int i = 0;
        Integer[][] matrix = new Integer[graph.nodes.size()][3];
        for (Node q : graph.nodes.values()) {
            matrix[i][0] = index.get(q);
            matrix[i][1] = dist.get(q);
            matrix[i][2] = index.get(pre.get(q));
            i++;
        }
        return matrix;
    }


    private static Node findNotNullMinDistNodeInSetV(HashMap<Node, Integer> dist, HashSet<Node> v) {
        Node p = null;
        Integer min = Integer.MAX_VALUE;
        for (Node q : dist.keySet()) {
            if (v.contains(q) && dist.get(q) != null && dist.get(q) < min){
                p = q;
                min = dist.get(q);
            }
        }
        return p;
    }

    public static void printDijkstraResult(Integer[][] matrix){
        System.out.println("==========Dijstra Result==========");
        System.out.printf("%-6s|%-6s|%-6s\n", "Node", "Dist", "Pre");
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%-6d|%-6d|%-6d\n", matrix[i][0], matrix[i][1], matrix[i][2]);
        }
    }

    public static void main(String[] args) {
        Integer[][] matrix = {
            {10, 1, 2},
            {50, 2, 3},
            {20, 4, 3},
            {60, 4, 5},
            {100, 1, 5},
            {30, 1, 4},
            {10, 3, 5}
        };

        Graph graph = GraphUtils.createGraph(matrix);
        graph.printGraph();

        Integer r = (int) ((graph.nodes.size()) * Math.random()) + 1;
        Node p = graph.nodes.get(r);
    
        Integer[][] infoMatrix =  dijkstra(graph, p);
        printDijkstraResult(infoMatrix);
    }
   
}
