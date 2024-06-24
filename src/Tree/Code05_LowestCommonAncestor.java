package Tree;

import java.util.HashMap;
import java.util.HashSet;

public class Code05_LowestCommonAncestor {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node lowestAncestor1(Node root, Node o1, Node o2) {
        if (root == null || o1 == root || o2 == root) {
            return root;
        }
        Node left = lowestAncestor1(root.left, o1, o2);
        Node right = lowestAncestor1(root.right, o1, o2);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    public static Node lowestAncestor2(Node root, Node o1, Node o2) {
        if (o1 == o2){
            return o1;
        }

        HashMap<Node, Node> fm = new HashMap<>();
        fm.put(root, null);
        process(fm, root);
        
        HashSet<Node> set = new HashSet<>();
        set.add(o1);
        Node p = o1;
        while(fm.get(p) != null){
            set.add(fm.get(p));
            p = fm.get(p);
        }

        p = o2;
        while (fm.get(p) != null && !set.contains(fm.get(p))){
            if (fm.get(p) == null) {
                return root;
            }
            p = fm.get(p);
        }
        return fm.get(p);
    }

    private static void process(HashMap<Node, Node> fm, Node root) {
        if (root == null){
            return;
        }
        fm.put(root.left, root);   
        fm.put(root.right, root);
        process(fm, root.left);
        process(fm, root.right);
    }

}
