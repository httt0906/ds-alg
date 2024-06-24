package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code02_TopologySort {

    public static List<Node> topologySort(Graph graph){
        // key : node
        // value : node 剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        for (Node p : graph.nodes.values()){
            inMap.put(p, p.in);
            if (p.in == 0){
                queue.add(p);
            }
        }

        List<Node> list = new ArrayList<>();
        Node p = null;
        while (!queue.isEmpty()){
            p = queue.poll();
            list.add(p);
            for (Node q : p.nexts) {
                inMap.put(q, inMap.get(q) - 1);
                if (q.in == 0){
                    queue.add(q);
                }
            }
        }
        return list;
    }
}