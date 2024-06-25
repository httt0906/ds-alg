package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 图的宽度优先遍历
 */
public class Code01_BFS {
    public static void bfs(Node node){
        if (node == null){
            return;
        }
        HashSet<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        set.add(node);
        Node p = null;
        while(!queue.isEmpty()){
            p = queue.poll();
            System.out.print(p.value + "-");
            for (Node q : p.nexts){
                if (!set.contains(q)){
                    set.add(q);
                    queue.add(q);
                }
            }
        }


    }
    
}
