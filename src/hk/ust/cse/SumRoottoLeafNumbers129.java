package hk.ust.cse;

public class SumRoottoLeafNumbers129 {
	public int sumNumbers(TreeNode root) {
		return sumPath(root, 0);
	}

	public int sumPath(TreeNode root, int current) {
		// leaf node
		if(root == null){
			return current;
		}
		if (root.left == null && root.right == null) {
			return 10 * current + root.val;
		} else if (root.left == null && root.right != null) {
			return sumPath(root.right, current * 10 + root.val);
		} else if (root.left != null && root.right == null) {
			return sumPath(root.left, current * 10 + root.val);
		} else {
			return sumPath(root.left, current * 10 + root.val)
					+ sumPath(root.right, current * 10 + root.val);
		}

	}
}
