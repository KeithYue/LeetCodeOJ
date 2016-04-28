package hk.ust.cse;

public class CoinChange322 {
	public static void main(String[] args) {
		CoinChange322 f = new CoinChange322();
		int[] c = { 411, 377, 14, 456, 434 };
		int amount = 6892;
		System.out.println(f.coinChange(c, amount));
	}

	public int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		int[] dp = new int[amount + 1];
		dp[0] = 0;

		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}

		for (int i = 0; i < coins.length; i++) {
			if (coins[i] < dp.length) {
				dp[coins[i]] = 1;
			}
		}

		// build up the array
		for (int i = 1; i < dp.length; i++) {
			if (dp[i] == -1) {
				// the value is not set
				int current = Integer.MAX_VALUE;
				for (int j = 0; j < coins.length; j++) {
					if ((i - coins[j]) >= 0) {
						if (dp[i - coins[j]] >= 0) {
							current = min(current, dp[i - coins[j]] + 1);
						}
					}
				}
				if (current != Integer.MAX_VALUE) {
					dp[i] = current;
				}
			}
		}

		// for (int i = 0; i < dp.length; i++) {
		// 	System.out.println(dp[i]);
		// }
		return dp[amount];
	}

	public int min(int a, int b) {
		return (a < b) ? a : b;
	}
}
