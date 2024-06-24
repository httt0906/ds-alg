package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
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
        Node p = root;
        while (p != null || !stack.isEmpty()){
            if (p != null){
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                System.out.print(p.value + "-");
                p = p.right;
            } 
        }
        System.out.println();



        // while (p != null) {
        //     stack1.push(p);
        //     p = p.left;           
        // }
        // while(!stack1.isEmpty()){
        //     p = stack1.pop();
        //     System.out.print(p.value + "-");
        //     if (p.right != null){
        //         q = p.right;
        //         while(q != null){
        //             stack1.push(q);
        //             q = q.left;
        //         }
        //     }
        // }
    }

    public static void posOrderRecur(Node root){
        if (root == null){
            return;
        }
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.print(root.value + "-");
    }

    public static void posOrderUnRecur(Node root){
        if (root == null){
            return;
        }
        Node p = null;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            p = stack1.pop();
            if (p.left != null){
                stack1.push(p.left);
            }
            if (p.right != null){
                stack1.push(p.right);
            }
            stack2.push(p);
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().value + "-");
        }
        System.out.println();
    }

    public static HashMap<Node,Integer> hierarchyTraversal(Node root){
        HashMap<Node,Integer> levelMap = new HashMap<>();
        if (root == null){
            return levelMap;
        }
        Queue<Node> queue = new LinkedList<>();
        Node p = root;
        queue.add(p);
        levelMap.put(p, 1);
        while (!queue.isEmpty()){
            p = queue.poll();
            System.out.print(p.value + "(" + levelMap.get(p) + ")" + "-");
            if (p.left != null){
                queue.add(p.left);
                levelMap.put(p.left, levelMap.get(p) + 1);
            }
            if (p.right != null){
                queue.add(p.right);
                levelMap.put(p.right, levelMap.get(p) + 1);
            }   
        }
        System.out.println();
        return levelMap;
    }

    public static void printHashMap(HashMap<Node,Integer> hm){
        for (Node key : hm.keySet()) {
            System.out.println(key.value + " | " + hm.get(key));            
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

        System.out.println("==========PosOrder===========");
        System.out.print("  Recursion: ");
        posOrderRecur(head);
        System.out.println();
        System.out.print("UnRecursion: ");
        posOrderUnRecur(head);

        System.out.println("==========FloorOrder===========");
        HashMap<Node,Integer> lm = hierarchyTraversal(head);
        printHashMap(lm);
    }


}
