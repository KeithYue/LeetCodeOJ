package hk.ust.cse;

import java.util.*;

public class BinaryTreePaths257 {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if (root == null) {
			return result;
		} else if (root.left == null && root.right == null) {
			String s = ((Integer) (root.val)).toString();
			List<String> tmp = new ArrayList<String>();
			tmp.add(s);
			return tmp;
		} else {
			if (root.left != null) {
				for (String s : binaryTreePaths(root.left)) {
					String new_s = ((Integer) (root.val)).toString() + "->" + s;
					result.add(new_s);
				}
			}
			if (root.right != null) {
				for (String s : binaryTreePaths(root.right)) {
					String new_s = ((Integer) (root.val)).toString() + "->" + s;
					result.add(new_s);
				}
			}

		}
		return result;
	}
}
