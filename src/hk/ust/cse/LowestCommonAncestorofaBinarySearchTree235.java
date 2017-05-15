package hk.ust.cse;

//  Definition for a binary tree node.

public class LowestCommonAncestorofaBinarySearchTree235 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test");

	}

	/*
	 * The LCA for p, q in BST is the node with the first apperance of the node
	 * whose value is in [p,q]
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode x = root;
		while (!(fallIn(x, p, q))) {
			if (x.val <= min(p.val, q.val)) {
				x = x.right;
			} else if (x.val >= max(p.val, q.val)) {
				x = x.left;
			} else {
				return null;
			}
		}
		return x;
	}

	// whether value of x fall in the interval of p and q
	boolean fallIn(TreeNode x, TreeNode p, TreeNode q) {
		if ((x.val >= p.val && x.val <= q.val) || (x.val >= q.val && x.val <= p.val)) {
			return true;
		} else {
			return false;
		}
	}

	int max(int a, int b) {
		return a > b ? a : b;
	}

	int min(int a, int b) {
		return a < b ? a : b;
	}
}
