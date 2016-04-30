package hk.ust.cse;

public class MinimumPathSum64 {
	public static void main(String[] args) {
		int[][] a = { { 1, 2 }, { 1, 1 } };
		MinimumPathSum64 f = new MinimumPathSum64();
		System.out.println(f.minPathSum(a));
	}

	public int minPathSum(int[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		int rows = grid.length;
		int columns = grid[0].length;
		int[][] dp = new int[rows][columns];
		dp[0][0] = grid[0][0];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == 0) {
					if (j == 0) {
						continue;
					}
					dp[i][j] = grid[i][j] + dp[i][j - 1];
				} else if (j == 0) {
					dp[i][j] = grid[i][j] + dp[i - 1][j];
				} else {
					dp[i][j] = grid[i][j]
							+ Math.min(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		// for (int i = 0; i < rows; i++) {
		// 	for (int j = 0; j < columns; j++) {
		// 		System.out.println(i + "  " + j + "  " + dp[i][j]);
		// 	}
		// }
		return dp[rows - 1][columns - 1];
	}
}
