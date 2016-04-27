package hk.ust.cse;

public class LongestIncreasingSubsequence300 {
	public static void main(String[] args) {
		LongestIncreasingSubsequence300 f = new LongestIncreasingSubsequence300();
		int[] a = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
		System.out.println(f.lengthOfLIS(a));
	}

	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}

		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i]) {
					dp[i] = max(dp[i], dp[j] + 1);
				}
			}
		}

		int result = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			// System.out.println(i+":"+dp[i]);
			result = max(result, dp[i]);
		}

		return result;
	}

	public int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
