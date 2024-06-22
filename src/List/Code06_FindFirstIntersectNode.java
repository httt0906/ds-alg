package List;

import java.util.Stack;

public class Code06_FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNodeIfNoRing(Node head1, Node head2){
        if (head1 == head2){
            return head1;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node p1 = head1;
        Node p2 = head2;
        while (p1 != null) {
            stack1.push(p1);
            p1 = p1.next;           
        }
        while (p2 != null) {
            stack2.push(p2);
            p2 = p2.next;
        }
        while (true) {
            p1 = stack1.pop();
            p2 = stack2.pop();
            if (p1 != p2){
                return p1.next;
            }
            if(stack1.isEmpty() || stack2.isEmpty()){
                return null;
            }
        }
    }

    public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNodeIfNoRing(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		// System.out.println(getIntersectNode(head1, head2).value);

		// // 0->9->8->6->4->5->6..
		// head2 = new Node(0);
		// head2.next = new Node(9);
		// head2.next.next = new Node(8);
		// head2.next.next.next = head1.next.next.next.next.next; // 8->6
		// System.out.println(getIntersectNode(head1, head2).value);

	}

}
