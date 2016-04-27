package hk.ust.cse;

public class UniquePaths62 {
	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (m == 1 || n == 1) {
			return 1;
		}

		int[][] r = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					r[0][0] = 1;
				} else if (i == 0 && j > 0) {
					r[i][j] = 1;
				} else if (i > 0 && j == 0) {
					r[i][j] = 1;
				} else {
					r[i][j] = r[i - 1][j] + r[i][j - 1];
				}
			}
		}

		return r[m - 1][n - 1];
	}
}
