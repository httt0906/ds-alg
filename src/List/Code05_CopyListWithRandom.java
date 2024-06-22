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

    public static void insertNode(Node pre, Node node){
        Node p = null;
        if (pre.next != null){
            p = pre.next;
            pre.next = node;
            node.next = p;
        } else {
            pre.next = node;
        }
    }

    public static Node copyListWithRandomByList(Node head){
        if (head == null) {
			return null;
		}
        // 插入链表
        Node p = head;
        while(p != null){
            insertNode(p, new Node(p.value));
            p = p.next.next;
        }

        // 
        p = head;
        Node q = p.next;
        while(p != null){
            // q.rand = p.rand.next;
            q.rand = (p.rand == null ? null : p.rand.next);
            p = p.next.next;
            // q = q.next.next;
            q = (q.next == null ? null : q.next.next);
        }

        p = head;
        q = head.next;
        head = q;
        while(p != null){
            p.next = q.next;
            p = q.next;
            q.next = (p == null ? null : p.next);
            q = (p == null ? null : p.next);
        }
        return head;
    }

    public static void printRandLinkedList(Node head) {
		Node cur = head;
		System.out.print("order: ");
        if (head == null) {System.out.print("-");}
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:  ");
		while (cur != null) {
			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
			cur = cur.next;
		}
		System.out.println();
    }

    public static void main(String[] args) {
		Node head = null;
		Node res1 = null;
		Node res2 = null;
		printRandLinkedList(head);
		res1 = copyListWithRandomByMap(head);
		printRandLinkedList(res1);
		res2 = copyListWithRandomByList(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

		printRandLinkedList(head);
		res1 = copyListWithRandomByMap(head);
		printRandLinkedList(res1);
        printRandLinkedList(head);

		res2 = copyListWithRandomByList(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

	}


}
