package hk.ust.cse;
import java.util.*;

public class BinaryTreeMaximumPathSum124 {
	public int maxPathSum(TreeNode root){
		if(root == null){
			return 0;
		}
		int [] maximum = {Integer.MIN_VALUE};
		maxSum(root, maximum);
		return maximum[0];
	}

    public int maxSum(TreeNode root, int [] maximum) {
    	// return the maximum path ending this root, but update the max value 
    	if(root == null){
    		return 0;
    	}
    	int leftm = maxSum(root.left, maximum);
    	int rightm = maxSum(root.right, maximum);
    	
    	int mediumPath = leftm + rightm + root.val;
    	
    	int current_max = max(mediumPath, max(root.val+leftm, max(root.val+rightm, root.val)));
    	// update the max
    	if(current_max>maximum[0]){
    		maximum[0] = current_max;
    	}
    	
    	return max(root.val, max(root.val+leftm, root.val+rightm));
    }
    public int max(int a, int b){
    	return (a>b)?a:b;
    }
    
}
