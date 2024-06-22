package List;

/**
 * 打印两个有序链表的公共部分
 */
public class Code03_PrintCommonPart {
   
    public static class Node {
		public int value;
		public Node next;
		public Node(int data) {
			this.value = data;
		}
	}

    public static void printCommonPart(Node head1, Node head2){
        Node p1 = head1;
        Node p2 = head2;
        System.out.print("Common Part: ");
        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                p1 = p1.next;
            } else if (p1.value == p2.value) {
                System.out.print(p1.value + " ");
                p1 = p1.next;
                p2 = p2.next;
            } else {
                p2 = p2.next;
            }
        }
        System.out.println();
    }

    public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

    public static void main(String[] args) {
		Node node1 = new Node(2);
		node1.next = new Node(3);
		node1.next.next = new Node(5);
		node1.next.next.next = new Node(6);

		Node node2 = new Node(1);
		node2.next = new Node(2);
		node2.next.next = new Node(5);
		node2.next.next.next = new Node(7);
		node2.next.next.next.next = new Node(8);

		printLinkedList(node1);
		printLinkedList(node2);
		printCommonPart(node1, node2);

	}

    
}
