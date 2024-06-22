package List;

import java.util.Comparator;

public class Code01_HashAndTree {
    public static class Node {
		public int value;
		public Node next;

		public Node(int val) {
			value = val;
		}
	}

    public class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.value - o2.value;
        }        
    }

    public static void main(String[] args) {
        
    }

    
}