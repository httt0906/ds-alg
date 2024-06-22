package List;

// import java.util.Map;
import java.util.Stack;

/**
 * 判断链表是否是回文结构
 */
public class Code04_IsPalindromenList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isPalindromeListByStack(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node p = head;
        while (p != null) {
            stack.push(p.value);
            p = p.next;
        }
        p = head;
        while (p != null){
            if (p.value != stack.pop()){
                return false;
            }
            p = p.next;
        }
        return true;
    }

    /**
     * 利用快慢指针
     * @param head
     * @return
     */
    public static boolean isPalindromeList(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        // 慢指针指向中间位置
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        // 链表后半部分反转
        slow = reverseList(slow);
        Node half = slow;
        while (slow != null) {
            if (head.value != slow.value){
                reverseList(half);
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        reverseList(half);
        return true;
    }

    public static Node reverseList(Node head){
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
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

		Node head = null;
		printLinkedList(head);
		System.out.print(isPalindromeListByStack(head) + " | ");
		System.out.println(isPalindromeList(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindromeListByStack(head) + " | ");
		System.out.println(isPalindromeList(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		printLinkedList(head);
		System.out.print(isPalindromeListByStack(head) + " | ");
		System.out.println(isPalindromeList(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindromeListByStack(head) + " | ");
		System.out.println(isPalindromeList(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printLinkedList(head);
		System.out.print(isPalindromeListByStack(head) + " | ");
		System.out.println(isPalindromeList(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindromeListByStack(head) + " | ");
		System.out.println(isPalindromeList(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindromeListByStack(head) + " | ");
		System.out.println(isPalindromeList(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindromeListByStack(head) + " | ");
		System.out.println(isPalindromeList(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindromeListByStack(head) + " | ");
		System.out.println(isPalindromeList(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

	}




}
