package hk.ust.cse;

public class MinimumSizeSubarraySum209 {
	public static void main(String[] args) {
		int[] a = { 1, 4, 4 };
		int s = 4;
		MinimumSizeSubarraySum209 f = new MinimumSizeSubarraySum209();
		System.out.println(f.minSubArrayLen(s, a));
	}

	public int minSubArrayLen(int s, int[] nums) {
		if (s == 0 || nums.length == 0) {
			return 0;
		}
		// initial
		int i = 0;
		int current = 0;
		int result;
		int[] dp = new int[nums.length];
		for (int j = 0; j < nums.length; j++) {
			current += nums[j];
			if (current >= s) {
				while (i <= j && current - nums[i] >= s) {
					current -= nums[i];
					i++;
				}
				dp[j] = j - i + 1;
			} else {
				dp[j] = 0;
				continue;
			}
		}

		boolean can = false;
		for (int k = 0; k < dp.length; k++) {
			if (dp[k] != 0) {
				can = true;
			}
		}
		if (can) {
			result = Integer.MAX_VALUE;
			for (int k = 0; k < dp.length; k++) {
				if(dp[k] > 0){
					result = Math.min(result, dp[k]);
				}
			}

		}else{
			return 0;
		}

		return result;
	}
}
