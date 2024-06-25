package Graph;

import java.util.HashMap;
import java.util.TreeMap;

public class Code06_Dijkstra {

    public static class Result {
        HashMap<Node, Integer> index;
        HashMap<Node, Integer> dist;
        HashMap<Node, Node> pre;

        public Result(HashMap<Node, Integer> index, HashMap<Node, Integer> dist, HashMap<Node, Node> pre){
            this.index = index;
            this.dist = dist;
            this.pre = pre;
        }
        
    }

    public static Integer[][] dijkstra(Graph graph, Node node){   
        HashMap<Node, Integer> index = GraphUtils.convertIndex(graph.nodes);
        HashMap<Node, Integer> dist = new HashMap<>();
        HashMap<Node, Node> pre = new HashMap<>();

        TreeMap<Node, Integer> map = new TreeMap<>((a, b) -> 
            Integer.valueOf(b.value).compareTo(Integer.valueOf(a.value)));        // map:node-dist
        // sort by dist
        for (Node n : graph.nodes.values()) {
            map.put(node, Integer.MAX_VALUE);
            dist.put(n, Integer.MAX_VALUE);
            pre.put(n, null);
        }
        dist.put(node, 0);
        map.put(node, 0);

        Node key = null;
        Integer d = null;
        while (!map.isEmpty()){
            // 1. 找到dist中数值最小且不在的节点o
            key = map.firstKey();
            d = map.get(key);            
            // 2. 寻找o的联通结点 更新dist,pre 将o从set中移除
            for (Edge e : key.edges){
                if (d + e.weight < dist.get(key)){
                    dist.put(key, d + e.weight);
                    pre.put(e.to, key);
                }
            }
            map.remove(key);
        }
        
        Integer[][] info = new Integer[graph.nodes.size()][3];
        for (Integer[] integers : info) {
            
        }

    }
    
}
