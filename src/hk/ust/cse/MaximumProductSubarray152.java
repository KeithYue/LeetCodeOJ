package hk.ust.cse;

public class MaximumProductSubarray152 {
	public static void main(String [] args){
		MaximumProductSubarray152 f = new MaximumProductSubarray152();
		int [] a = {2, -1, 1, 1};
		System.out.println(f.maxProduct(a));
	}
	public int maxProduct(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}
		int[] minp = new int[nums.length];
		int[] maxp = new int[nums.length];
		minp[0] = nums[0];
		maxp[0] = nums[0];
		int result = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			int a = nums[i];
			minp[i] = min(a, min(a * maxp[i - 1], a * minp[i - 1]));
			maxp[i] = max(a, max(a * maxp[i - 1], a * minp[i - 1]));
			result = max(result, maxp[i]);
		}
		result = max(result, maxp[0]);
		
		// for(int i =0;i<nums.length;i++){
		// 	System.out.println("min: " + minp[i] + "    max: " + maxp[i]);
		// }
		
		return result;

	}

	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public int min(int a, int b) {
		return (a < b) ? a : b;
	}
}
