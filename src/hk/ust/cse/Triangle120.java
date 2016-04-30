package hk.ust.cse;

import java.util.*;

public class Triangle120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0) {
			return 0;
		}
		int[][] dp = new int[triangle.size()][triangle.size()];
		for (int i = triangle.size() - 1; i >= 0; i--) {
			List<Integer> current = triangle.get(i);
			for (int j = 0; j < current.size(); j++) {
				if (i == triangle.size() - 1) {
					dp[i][j] = current.get(j);
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1])
							+ current.get(j);
				}
			}
		}
		return dp[0][0];
	}
}
