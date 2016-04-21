package hk.ust.cse;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null){
    		return false;
    	}
    	if(root.left == null && root.right == null){
    		if(sum == root.val){
    			return true;
    		}else{
    			return false;
    		}
    	}else{
    		return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    	}
    }
}

