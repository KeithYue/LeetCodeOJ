package hk.ust.cse;

public class MaximumSubarray53 {
	public int maxSubArray(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] max = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			max[i] = nums[i];
		}
		for(int i =1;i<nums.length;i++){
			int a = max[i-1] + nums[i];
			if(a>max[i]){
				max[i] = a;
			}
		}
		int result  = Integer.MIN_VALUE;
		for(int i =0;i<max.length;i++){
			if(max[i] > result){
				result = max[i];
			}
		}
		return result;
	}
}
