package hk.ust.cse;

import java.util.*;

public class BinaryTreePreorderTraversal144 {
	public static void main(String[] args) {
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(1);
		b.left = a;
		BinaryTreePreorderTraversal144 f = new BinaryTreePreorderTraversal144();
		System.out.println(f.preorderTraversal(b));
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> t = new Stack<TreeNode>();
		t.push(root);
		while (!t.empty()) {
			TreeNode current = t.pop();
			// System.out.println(result);
			result.add(current.val);
			if (current.right != null) {
				t.push(current.right);
			}

			if (current.left != null) {
				t.push(current.left);
			}
		}

		return result;
	}
}
