package hk.ust.cse;

public class BestTimetoBuyandSellStock121 {
	public int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		// > 2
		int[] sell = new int[prices.length];
		sell[0] = 0;
		int best = Integer.MIN_VALUE;
		for (int i = 1; i < prices.length; i++) {
			sell[i] = max(prices[i] - prices[i - 1] + sell[i - 1], 0);
			if (sell[i] > best) {
				best = sell[i];
			}
		}

		return best;
	}

	public int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
