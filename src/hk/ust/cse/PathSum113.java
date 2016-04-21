package hk.ust.cse;

import java.util.*;

public class PathSum113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}else{
			if (isLeaf(root)) {
				if (sum == root.val) {
					ArrayList<Integer> r1 = new ArrayList<Integer>();
					result.add(r1);
				r1.add(root.val);
			} 
		} else {
			if(root.left != null){
				List<List<Integer>> leftr = pathSum(root.left, sum-root.val);
				if(!leftr.isEmpty()){
					for(int i =0;i<leftr.size();i++){
						List<Integer> item = leftr.get(i);
						item.add(0, root.val);
						result.add(item);
					}
				}
			}
			if(root.right != null){
				List<List<Integer>> rightr = pathSum(root.right, sum-root.val);
				if(!rightr.isEmpty()){
					for(int i =0;i<rightr.size();i++){
						List<Integer> item = rightr.get(i);
						item.add(0, root.val);
						result.add(item);
					}
				}
			}
		}
			
		}
		return result;
	}

	public boolean isLeaf(TreeNode t) {
		return (t.left == null) && (t.right == null);
	}
}
