package List;

public class Code02_ReverseList {
    public static class Node {
		public int value;
		public Node next;

		public Node(int val) {
			value = val;
		}
	}

    public static class DoubleNode {
		public int value;
		public DoubleNode last;
		public DoubleNode next;

		public DoubleNode(int data) {
			this.value = data;
		}
	}

    public static Node reverseList(Node head){
        Node pre = head;
        Node p = null;
        while (pre.next != null) {
            p = pre.next;
            pre.next = p.next;
            p.next = head;
            head = p;  
        }
        return head;
    }

    public static DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = head;
        DoubleNode p = null;
        while (pre.next != null) {
            p = pre.next;
            pre.next = p.next;
			if (p.next != null){
				p.next.last = pre;
			}           
			p.last = null;
			p.next = head;
			head.last = p;
            head = p;
        }
        return head;
    }

    public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

    public static void printDoubleLinkedList(DoubleNode head) {
		System.out.print("Double Linked List: ");
		DoubleNode end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.next;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.last;
		}
		System.out.println();
	}


    public static void main(String[] args) {
        Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		printLinkedList(head1);
		head1 = reverseList(head1);
		printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
		head2.next = new DoubleNode(2);
		head2.next.last = head2;
		head2.next.next = new DoubleNode(3);
		head2.next.next.last = head2.next;
		head2.next.next.next = new DoubleNode(4);
		head2.next.next.next.last = head2.next.next;
		printDoubleLinkedList(head2);
		printDoubleLinkedList(reverseList(head2));
    }
}
