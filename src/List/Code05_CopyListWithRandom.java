package List;

import java.util.HashMap;

public class Code05_CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node copyListWithRandomByMap(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.value));
            p = p.next;            
        }
        p = head;
        while (p != null){
            map.get(p).next = map.get(p.next);
            map.get(p).rand = map.get(p.rand);
            p = p.next;
        }
        return map.get(head);
    }


    public static Node copyListWithRandomByList(Node head){
        Node p = head;
        while()
    }

}
