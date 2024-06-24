package Tree;

import java.util.Stack;

public class Code01_PreInPosTraversal {

    public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

    public static void preOrderRecur(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.value + "-");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    
    public static void preOrderUnRecur(Node root){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node p = null;
        while(!stack.isEmpty()){
            p = stack.pop();
            System.out.print(p.value + "-");
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }
    }

    public static void inOrderRecur(Node root){
        if (root == null){
            return;
        }
        inOrderRecur(root.left);
        System.out.print(root.value + "-");
        inOrderRecur(root.right);
    }

    public static void inOrderUnRecur(Node root){
        if (root == null) {
            return;            
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node p = null;
        while (!stack.isEmpty()){
            p = stack.pop();
            if (p.right != null){
                stack.push(p.right);
            }
            System.out.print(p.value + "-");
            if (p.left != null){
                stack.push(p.left);
            }
        }
    }






    public static void main(String[] args) {
        Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

        System.out.println("==========PreOrder===========");
        System.out.print("  Recursion: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("UnRecursion: ");
        preOrderUnRecur(head);
        System.out.println();

        System.out.println("==========InOrder===========");
        System.out.print("  Recursion: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("UnRecursion: ");
        inOrderUnRecur(head);
        System.out.println();
    }


}
