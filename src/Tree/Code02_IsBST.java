package Tree;

import java.util.LinkedList;

/**
 * 判断是否是二叉搜索树
 * 中序遍历 打印操作变成判断操作
 */
public class Code02_IsBST {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isBST(Node head) {
		if (head == null) {
			return true;
		}
		LinkedList<Node> inOrderList = new LinkedList<>();
		process(head, inOrderList);
		int pre = Integer.MIN_VALUE;
		for (Node cur : inOrderList) {
			if (pre >= cur.value) {
				return false;
			}
			pre = cur.value;
		}
		return true;
	}

	public static void process(Node node, LinkedList<Node> inOrderList) {
		if (node == null) {
			return;
		}
		process(node.left, inOrderList);
		inOrderList.add(node);
		process(node.right, inOrderList);
	}

}
