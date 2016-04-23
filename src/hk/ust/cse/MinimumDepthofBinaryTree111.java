package hk.ust.cse;

public class MinimumDepthofBinaryTree111 {
	public int minDepth(TreeNode root) {
		if(root == null){
			return 0;
		}else if(root.left == null && root.right == null){
			return  1;
		}else if(root.left != null && root.right == null){
			return 1 + minDepth(root.left);
		}else if(root.left == null && root.right != null){
			return 1 + minDepth(root.right);
		}else{
			return 1 + min(minDepth(root.left), minDepth(root.right));
		}
	}
	
	public int min(int a, int  b){
		return (a<b)?a:b;
	}
}
