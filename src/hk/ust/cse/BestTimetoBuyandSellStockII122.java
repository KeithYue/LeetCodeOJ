package hk.ust.cse;

public class BestTimetoBuyandSellStockII122 {

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// }

	public int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int[] profit = new int[prices.length];
		for (int i = 0; i < prices.length - 1; i++) {
			profit[i] = prices[i + 1] - prices[i];
		}
		profit[profit.length - 1] = 0;
		// calculate sum
		int sum = 0;
		for (int i = 0; i < profit.length; i++) {
			if (profit[i] > 0) {
				sum = sum + profit[i];
			}
		}
		return sum;
	}

}
