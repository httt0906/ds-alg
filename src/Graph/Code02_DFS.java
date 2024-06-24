package Graph;

import java.util.HashSet;
import java.util.Stack;

public class Code02_DFS {
    public static void dfs(Node node){
        if (node == null){
            return;
        }

        HashSet<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        set.add(node);
        stack.add(node);
        System.out.print(node.value + "-");

        Node p = null;
        while(!stack.isEmpty()){
            p = stack.pop();
            for (Node q : p.nexts) {
                if (!set.contains(q)){
                    set.add(q);
                    stack.push(p);
                    stack.push(q);
                    System.out.print(q.value + "-");
                    break;
                }
                
            }
        }
    }
    
}
