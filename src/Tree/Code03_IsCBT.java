package Tree;

import java.util.LinkedList;

/** 
 * 层序遍历
 * 1. 任意节点有右节点而无左节点 false
 * 2. 1.的前提下 第一个有左无右的结点 往后的节点都是叶节点 否则 false
 */
public class Code03_IsCBT {

	
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		LinkedList<Node> queue = new LinkedList<>();
		// 是否遇到过左右孩子不双全的节点
		boolean leaf = false;
		Node l = null;
		Node r = null;
		queue.add(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
				return false;
			}
			if (l != null) {
				queue.add(l);
			}
			if (r != null) {
				queue.add(r);
			} else {
				leaf = true;
			}
		}
		return true;
	}

}
